package com.telran.person.service;

import com.telran.person.dto.NumberDto;
import com.telran.person.mapper.NumberMapper;
import com.telran.person.model.Person;
import com.telran.person.model.PhoneNumber;
import com.telran.person.persistence.INumberRepository;
import com.telran.person.persistence.IPersonRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class NumberService {

    private static final String NUMBER_NOT_FOUND = "No such number";
    INumberRepository numberRepository;
    IPersonRepository personRepository;
    NumberMapper numberMapper;

    public NumberService(IPersonRepository personRepository, INumberRepository numberRepository, NumberMapper numberMapper) {
        this.personRepository = personRepository;
        this.numberRepository = numberRepository;
        this.numberMapper = numberMapper;
    }

    public void add(NumberDto numberDto) {
        Person person = personRepository.findById(numberDto.personId).orElseThrow(() -> new EntityNotFoundException(PersonService.PERSON_NOT_FOUND));
        PhoneNumber number = new PhoneNumber(numberDto.number, person);
        numberRepository.save(number);
    }

    public void edit(NumberDto numberDto) {
        PhoneNumber phoneNumber = numberRepository.findById(numberDto.personId).orElseThrow(() -> new EntityNotFoundException(NUMBER_NOT_FOUND));
        phoneNumber.setNumber(numberDto.number);
        numberRepository.save(phoneNumber);

    }

    public NumberDto getById(int id) {
        PhoneNumber phoneNumber = numberRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(NUMBER_NOT_FOUND));
        NumberDto numberDto = numberMapper.mapNumberToDto(phoneNumber);
        return numberDto;

    }

    public void removeById(int id) {
        numberRepository.deleteById(id);
    }

}
