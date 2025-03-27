package com.async.asyncMuseum.controller;

import com.async.asyncMuseum.dto.MuseeCreateDto;
import com.async.asyncMuseum.dto.MuseeDto;
import com.async.asyncMuseum.service.implementations.MuseeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musees")
public class MuseeController {
    @Autowired
    MuseeService museeService;
    @GetMapping(path = "")
    public ResponseEntity<List<MuseeDto>> getListe(){
        List<MuseeDto>listMusee=museeService.getAll();
        return new ResponseEntity<>(listMusee, HttpStatus.OK);
    }
    @GetMapping(path="/{id}")    
    public MuseeDto getById(@PathVariable Long id){
        return museeService.getById(id);
    } 
    @PostMapping(path = "")
    public MuseeDto create(@RequestBody MuseeCreateDto museeDto){
        return museeService.create(museeDto);
    }
    @PutMapping(path="/{id}")
    public MuseeDto update(@PathVariable Long id, @RequestBody MuseeCreateDto museeDto){
        return museeService.update(id,museeDto);
    }
    @DeleteMapping(path ="/{id}")
    public String delete(@PathVariable Long id){
        return museeService.delete(id);
    }
}