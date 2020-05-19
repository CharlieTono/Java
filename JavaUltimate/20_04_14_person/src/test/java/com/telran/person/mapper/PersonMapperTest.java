package com.telran.person.mapper;

import com.telran.person.dto.PersonDto;
import com.telran.person.model.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonMapperTest {

    PersonMapper personMapper = new PersonMapper();

    @Test
    void PersonDTO () {

        Person person = new Person("A", "B", LocalDate.now().minusYears(30));
        PersonDto personDto = new PersonDto(1, "A", "B", LocalDate.now().minusYears(30));

        PersonDto personDtoMapped = personMapper.mapPersonToDto(person);
        assertEquals(personDto.firstName, personDtoMapped.firstName);
        assertEquals(personDto.lastName, personDtoMapped.lastName);

    }

}