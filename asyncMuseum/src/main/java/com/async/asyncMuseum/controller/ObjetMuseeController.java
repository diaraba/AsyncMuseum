package com.async.asyncMuseum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.async.asyncMuseum.dto.ObjetMuseeCreateDto;
import com.async.asyncMuseum.dto.ObjetMuseeDto;
import com.async.asyncMuseum.service.implementations.ObjetMuseeService;

@RestController
@RequestMapping("/musees")
public class ObjetMuseeController {
    @Autowired
    ObjetMuseeService objetMuseeService;

    @GetMapping(path = "/objetMusees")
    public ResponseEntity<List<ObjetMuseeDto>> getListe() {
        List<ObjetMuseeDto> listObjetMuseeDtos = objetMuseeService.getAll();
        return new ResponseEntity<>(listObjetMuseeDtos, HttpStatus.OK);
    }

    @GetMapping(path = "/objetMusees/{id}")
    public ObjetMuseeDto getById(@PathVariable Long id) {
        return objetMuseeService.getById(id);
    }

    @PostMapping(path = "/objetMusees")
    public ObjetMuseeDto create(@RequestBody ObjetMuseeCreateDto objetMuseeDto) {
        return objetMuseeService.create(objetMuseeDto);
    }

    @PutMapping(path = "/objetMusees/{id}")
    public ObjetMuseeDto update(@PathVariable Long id, @RequestBody ObjetMuseeCreateDto objetMuseeDto) {
        return objetMuseeService.update(id, objetMuseeDto);
    }

    @DeleteMapping(path = "/objetMusees/{id}")
    public String delete(@PathVariable Long id) {
        return objetMuseeService.delete(id);
    }
}