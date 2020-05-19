package com.telran.person.service;

import com.telran.person.dto.NumberDto;
import com.telran.person.dto.PersonDto;
import com.telran.person.mapper.NumberMapper;
import com.telran.person.mapper.PersonMapper;
import com.telran.person.model.Person;
import com.telran.person.persistence.INumberRepository;
import com.telran.person.persistence.IPersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {
   // @Mock
    IPersonRepository personRepository;

   // @Mock
    INumberRepository numberRepository;

   // @Spy
    PersonMapper personMapper = new PersonMapper();

   // @Spy
    NumberMapper numberMapper = new NumberMapper();

   // @InjectMocks
    PersonService personService;

    @BeforeEach
    public void init() {
        personRepository = mock(IPersonRepository.class);
        numberRepository = mock(INumberRepository.class);
        personMapper = spy(new PersonMapper());
        numberMapper = spy(new NumberMapper());

        personService = new PersonService(
                personRepository,
                numberRepository,
                personMapper,
                numberMapper);
    }

    @Test
    public void testAdd_personWithoutNumbers_passesToRepo() {
        LocalDate bd = LocalDate.now().minusYears(25);
        PersonDto personIn = new PersonDto(5, "A", "B", bd);
        personService.add(personIn);
        verify(personRepository).save(argThat(person ->

                person.getLastName().equals(personIn.lastName)
                        && person.getName().equals(personIn.firstName)
                        && bd.equals(person.getBirthday())
        ));

        verify(personRepository, times(1)).save(any());
        verify(numberRepository, times(0)).save(any());
    }

    @Captor
    ArgumentCaptor<Person> personCaptor;

    @Test
    public void testAdd_personWithNumbers_Number1Saved() {
        LocalDate bd = LocalDate.now().minusYears(25);
        PersonDto personIn = new PersonDto(0, "A", "B", bd);

        personIn.numbers = Arrays.asList(new NumberDto(0, "111111", 0));

        personService.add(personIn);

        verify(personRepository).save(personCaptor.capture());

        List<Person> capturedPersons = personCaptor.getAllValues();
        assertEquals(1, capturedPersons.size());
        Person capturedPerson = capturedPersons.get(0);

        assertEquals(personIn.firstName, capturedPerson.getName());
        assertEquals(personIn.lastName, capturedPerson.getLastName());
        assertEquals(bd, capturedPerson.getBirthday());

        verify(numberRepository, times(1)).save(any());
        verify(numberRepository, times(1)).save(argThat(
                number -> number.getNumber().equals("111111") &&
                        number.getPerson().equals(capturedPerson)));

    }

    @Test
    public void testGetAll_noPersonFound_EmptyList() {
        when(personRepository.findAll()).thenReturn(new ArrayList<>());
        List<PersonDto> personFound = personService.getAll();
        assertEquals(0, personFound.size());
    }

    @Test
    public void testGetAll_twoPersonFound_ReturnsListWithTwoPerson() {
        LocalDate bd01 = LocalDate.now().minusYears(25);
        LocalDate bd02 = LocalDate.now().minusYears(28);

        Person one = new Person("A", "B", bd01);
        Person two = new Person("B", "A", bd02);

        List<Person> personsFromDb = Arrays.asList(one, two);

        when(personRepository.findAll()).thenReturn(personsFromDb);

        List<PersonDto> personsFound = personService.getAll();
        assertEquals(2, personsFound.size());

        verify(personMapper, times(1)).mapPersonToDto(one);
        verify(personMapper, times(1)).mapPersonToDto(two);

    }

    @Test
    public void testGetById_personWithNumber_Person() {
        LocalDate bd = LocalDate.now().minusYears(25);
        PersonDto personIn = new PersonDto(1, "A", "B", LocalDate.now().minusYears(25));
        personIn.numbers = Arrays.asList(new NumberDto(1, "111111", 1));

        Person personFromDB = new Person("A", "B", bd);

        when(personRepository.findById(personIn.id)).thenReturn(java.util.Optional.of(personFromDB));

        PersonDto personFounded = personService.getById(personIn.id);

        assertEquals(personIn.firstName, personFounded.firstName);
        assertEquals(personIn.lastName, personFounded.lastName);
        assertEquals(personIn.birthday, personFounded.birthday);

        verify(personMapper, times(1)).mapPersonToDto(personFromDB);
        verify(personRepository, times(1)).findById(argThat(
                id -> id.intValue() == personIn.id));
    }

    @Captor
    ArgumentCaptor<Person> personCaptor02;

    @Test
    public void testRemoveById_personWithNumber_EmptyList() {
        LocalDate bd = LocalDate.now().minusYears(25);
        PersonDto personIn = new PersonDto(1, "A", "B", bd);
        personIn.numbers = Arrays.asList(new NumberDto(1, "111111", 1));

        personService.removeById(personIn.id);

        List<PersonDto> allPersons = personService.getAll();
        verify(personRepository, times(1)).deleteById(personIn.id);
        assertEquals(0, allPersons.size());

        //the same with captor
        List<Person> capturedPersons = personCaptor02.getAllValues();
        assertEquals(0, capturedPersons.size());

    }

    @Test
    public void testEdit_personWithNumber_UpdatedPerson() {
        LocalDate bd = LocalDate.now().minusYears(25);
        PersonDto personOld = new PersonDto(1, "A", "B", bd);
        PersonDto personNew = new PersonDto(1, "B", "C", bd);

        personOld.numbers = Arrays.asList(new NumberDto(1, "111111", 1));

        Person personFromDB = new Person("B", "C", bd);
        when(personRepository.findById(personNew.id)).thenReturn(java.util.Optional.of(personFromDB));

        personService.edit(personNew);
        PersonDto personFounded = personService.getById(personOld.id);

        verify(personMapper, times(1)).mapPersonToDto(personFromDB);
        verify(personRepository, times(1)).save(any());
        verify(personRepository, times(2)).findById(argThat(
                id -> id.intValue() == personOld.id));

        assertEquals(personNew.firstName, personFounded.firstName);
        assertEquals(personNew.lastName, personFounded.lastName);
        assertEquals(personNew.birthday, personFounded.birthday);

    }
}
