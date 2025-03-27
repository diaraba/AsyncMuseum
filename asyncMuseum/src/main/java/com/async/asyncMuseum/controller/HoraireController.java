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

import com.async.asyncMuseum.dto.HoraireCreateDto;
import com.async.asyncMuseum.dto.HoraireDto;
import com.async.asyncMuseum.service.implementations.HoraireService;



@RestController
@RequestMapping("/musees")
public class HoraireController {
    @Autowired
    HoraireService horaireService;
    @GetMapping(path = "/horaires")
    public ResponseEntity<List<HoraireDto>> getListe(){
        List<HoraireDto>listHoraire=horaireService.getAll();
        return new ResponseEntity<>(listHoraire, HttpStatus.OK);
    }
    @GetMapping(path="/horaires/{id}")    
    public HoraireDto getById(@PathVariable Long id){
        return horaireService.getById(id);
    } 
    @PostMapping(path = "/horaires")
    public HoraireDto create(@RequestBody HoraireCreateDto horaireDto){
        return horaireService.create(horaireDto);
    }
    @PutMapping(path="/horaires/{id}")
    public HoraireDto update(@PathVariable Long id, @RequestBody HoraireCreateDto horaireDto){
        return horaireService.update(id,horaireDto);
    }
    @DeleteMapping(path ="/horaires/{id}")
    public String delete(@PathVariable Long id){
        return horaireService.delete(id);
    }
}
