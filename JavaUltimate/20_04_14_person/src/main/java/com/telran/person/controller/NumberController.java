package com.telran.person.controller;

import com.telran.person.dto.NumberDto;
import com.telran.person.dto.PersonDto;
import com.telran.person.model.PhoneNumber;
import com.telran.person.service.NumberService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
public class NumberController {

    NumberService numberService;

    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @PostMapping("/number")
    public void create(@RequestBody NumberDto numberDto) {
        numberService.add(numberDto);
    }

    @GetMapping("/number/{id}")
    public NumberDto getById(@PathVariable @Min(1) int id) {
        return numberService.getById(id);
    }

    @PutMapping("/number")
    public void edit(@RequestBody @Valid NumberDto numberDto) {
        numberService.edit(numberDto);
    }

    @DeleteMapping("/number/{id}")
    public void removeById(@PathVariable int id) {
        numberService.removeById(id);
    }
}
