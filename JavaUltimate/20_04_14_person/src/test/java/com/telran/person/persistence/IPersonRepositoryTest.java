package com.telran.person.persistence;

import com.telran.person.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
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

}