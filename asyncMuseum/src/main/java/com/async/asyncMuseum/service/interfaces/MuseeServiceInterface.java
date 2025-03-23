package com.async.asyncMuseum.service.interfaces;

import com.async.asyncMuseum.dto.MuseeDto;

import java.util.List;

public interface MuseeServiceInterface {
    List<MuseeDto> getAllMusee();
    MuseeDto getMuseeById(Long id);
    MuseeDto create(MuseeDto compte);
    MuseeDto updateMusee(Long id,MuseeDto museeDto);
    String deleteMusee(Long id);
}
