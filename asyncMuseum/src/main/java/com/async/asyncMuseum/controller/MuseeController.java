package com.async.asyncMuseum.controller;

import com.async.asyncMuseum.model.Musee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musee")
public class MuseeController {
    @GetMapping(path = "")
    public ResponseEntity<List<Musee>> museeListe(){
        return null;
    }
    @PostMapping(path = "")
    public Musee createMusee(@RequestBody Musee musee){
        return new Musee();
    }
}
