package com.async.asyncMuseum.service.implementations;

import com.async.asyncMuseum.dto.MuseeDto;
import com.async.asyncMuseum.exception.ResourceNotFoundException;
import com.async.asyncMuseum.model.Musee;
import com.async.asyncMuseum.repository.MuseeRepository;
import com.async.asyncMuseum.service.interfaces.MuseeServiceInterface;
import com.async.asyncMuseum.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MuseeService implements MuseeServiceInterface {
    @Autowired
    MuseeRepository museeRepository;
    @Override
    public List<MuseeDto> getAllMusee() {
        return museeRepository.findAll().stream().map((musees)-> MyUtil.convert(musees,new MuseeDto())).toList();
    }

    @Override
    public MuseeDto getMuseeById(Long id) {
        return museeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Cette musée n'Existe pas")).toDto();
    }

    @Override
    public MuseeDto create(MuseeDto museeDto) {
        Musee musee=museeDto.toModel();
        return museeRepository.save(musee).toDto();
    }

    @Override
    public MuseeDto updateMusee(Long id, MuseeDto museeDto) {
        Musee musee=MyUtil.convert(museeDto,getMuseeById(id)).toModel();
        musee.setId(id);
        musee=museeRepository.save(musee);
        return musee.toDto();
    }

    @Override
    public String deleteMusee(Long id) {
        try {
            museeRepository.deleteById(id);
        }catch (Exception e){
        }
        return "Musée supprimer avec succès";
    }
}
