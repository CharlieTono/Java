package com.telran.person.persistence;

import com.telran.person.dto.PersonDto;
import com.telran.person.model.Person;
import com.telran.person.model.PhoneNumber;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IPersonRepositoryTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    IPersonRepository iPersonRepository;

    @Test
    public void testFindByName_oneRecord_found() {
        Person person = new Person("AA", "BB", LocalDate.now().minusYears(11));

        entityManager.persist(person);
        entityManager.flush();

        List<Person> foundPersonsFromDB = iPersonRepository.findByName("AA");
        assertEquals(1, foundPersonsFromDB.size());

        assertEquals("AA", foundPersonsFromDB.get(0).getName());
        assertEquals("BB", foundPersonsFromDB.get(0).getLastName());
        assertEquals(LocalDate.now().minusYears(11), foundPersonsFromDB.get(0).getBirthday());
    }

    @Test
    public void testFindByBirthdayCustom_oneRecord_found() {
        LocalDate bd = LocalDate.now().minusYears(29);
        LocalDate before = LocalDate.now().minusYears(30);
        LocalDate after = LocalDate.now().minusYears(10);
        Person person = new Person("AA", "BB", bd);

        entityManager.persist(person);
        entityManager.flush();

        List<Person> foundPersonsFromDB = iPersonRepository.findByBirthdayBetweenCustom(before, after);
        assertEquals(1, foundPersonsFromDB.size());

        assertEquals("AA", foundPersonsFromDB.get(0).getName());
        assertEquals("BB", foundPersonsFromDB.get(0).getLastName());
        assertEquals(bd, foundPersonsFromDB.get(0).getBirthday());
    }

    @Test
    public void testRemoveWithLastname_oneRecords_removed1() {
        LocalDate bd = LocalDate.now().minusYears(29);

        Person person01 = new Person("AA", "BB", bd);

        entityManager.persist(person01);
        entityManager.flush();

        iPersonRepository.removeWithLastnameStarting("B");
        List<Person> foundPersonsFromDB = iPersonRepository.findAll();

        assertEquals(0, foundPersonsFromDB.size());
    }

    @Test
    public void testRemoveWithLastname_twoRecords_removed1() {
        LocalDate bd = LocalDate.now().minusYears(29);

        Person person01 = new Person("AA", "BB", bd);
        Person person02 = new Person("AA", "CC", bd);

        entityManager.persist(person01);
        entityManager.persist(person02);
        entityManager.flush();

        iPersonRepository.removeWithLastnameStarting("C");
        List<Person> foundPersonsFromDB = iPersonRepository.findAll();

        assertEquals(1, foundPersonsFromDB.size());

        assertEquals("AA", foundPersonsFromDB.get(0).getName());
        assertEquals("BB", foundPersonsFromDB.get(0).getLastName());
        assertEquals(bd, foundPersonsFromDB.get(0).getBirthday());
    }

    @Test
    public void testRemoveWithLastnamePersonWithNumber_twoRecords_removed1() {
        LocalDate bd = LocalDate.now().minusYears(29);

        Person person01 = new Person("AA", "BB", bd);
        Person person02 = new Person("AA", "CC", bd);

        PhoneNumber phoneNumber01 = new PhoneNumber("111111", person01);
        PhoneNumber phoneNumber02 = new PhoneNumber("222222", person02);

        entityManager.persist(person01);
        entityManager.persist(person02);
        entityManager.flush();

        iPersonRepository.removeWithLastnameStarting("C");
        List<Person> foundPersonsFromDB = iPersonRepository.findAll();

        assertEquals(1, foundPersonsFromDB.size());

        assertEquals("AA", foundPersonsFromDB.get(0).getName());
        assertEquals("BB", foundPersonsFromDB.get(0).getLastName());
        assertEquals(bd, foundPersonsFromDB.get(0).getBirthday());
    }

    public void testFindAll_noPersonExists_emptyList() {
        List<Person> foundPersons = iPersonRepository.findAll();
        assertEquals(0, foundPersons.size());
    }

}