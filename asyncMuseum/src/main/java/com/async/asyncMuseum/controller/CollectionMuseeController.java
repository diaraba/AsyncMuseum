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

import com.async.asyncMuseum.dto.CollectionMuseeCreateDto;
import com.async.asyncMuseum.dto.CollectionMuseeDto;
import com.async.asyncMuseum.service.implementations.CollectionMuseeService;

@RestController
@RequestMapping("/musees")
public class CollectionMuseeController {
    @Autowired
    CollectionMuseeService collectionMuseeService;
    @GetMapping(path = "/collections")
    public ResponseEntity<List<CollectionMuseeDto>> getListe(){
        List<CollectionMuseeDto>listes=collectionMuseeService.getAll();
        return new ResponseEntity<>(listes, HttpStatus.OK);
    }
    @GetMapping(path="/collections/{id}")    
    public CollectionMuseeDto getById(@PathVariable Long id){
        return collectionMuseeService.getById(id);
    } 
    @PostMapping(path = "/collections")
    public CollectionMuseeDto create(@RequestBody CollectionMuseeCreateDto collectionMuseeDto){
        return collectionMuseeService.create(collectionMuseeDto);
    }
    @PutMapping(path="/collections/{id}")
    public CollectionMuseeDto update(@PathVariable Long id, @RequestBody CollectionMuseeCreateDto collectionMuseeDto){
        return collectionMuseeService.update(id,collectionMuseeDto);
    }
    @DeleteMapping(path ="/collections/{id}")
    public String delete(@PathVariable Long id){
        return collectionMuseeService.delete(id);
    }
}