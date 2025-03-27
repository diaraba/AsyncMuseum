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

import com.async.asyncMuseum.dto.ExpositionCreateDto;
import com.async.asyncMuseum.dto.ExpositionDto;
import com.async.asyncMuseum.service.implementations.ExpositionService;

@RestController
@RequestMapping("/musees")
public class ExpositionController {
     @Autowired
    ExpositionService expositionService;
    @GetMapping(path = "/expositions")
    public ResponseEntity<List<ExpositionDto>> getListe(){
        List<ExpositionDto>listHoraire=expositionService.getAll();
        return new ResponseEntity<>(listHoraire, HttpStatus.OK);
    }
    @GetMapping(path="/expositions/{id}")    
    public ExpositionDto getById(@PathVariable Long id){
        return expositionService.getById(id);
    } 
    @PostMapping(path = "/expositions")
    public ExpositionDto create(@RequestBody ExpositionCreateDto expositionDto){
        return expositionService.create(expositionDto);
    }
    @PutMapping(path="/expositions/{id}")
    public ExpositionDto update(@PathVariable Long id, @RequestBody ExpositionCreateDto expositionDto){
        return expositionService.update(id,expositionDto);
    }
    @DeleteMapping(path ="/expositions/{id}")
    public String delete(@PathVariable Long id){
        return expositionService.delete(id);
    }
}
