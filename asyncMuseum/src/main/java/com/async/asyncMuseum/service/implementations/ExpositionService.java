package com.async.asyncMuseum.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.async.asyncMuseum.dto.ExpositionCreateDto;
import com.async.asyncMuseum.dto.ExpositionDto;
import com.async.asyncMuseum.exception.DeleteException;
import com.async.asyncMuseum.exception.ResourceNotFoundException;
import com.async.asyncMuseum.model.Exposition;
import com.async.asyncMuseum.repository.ExpositionRepository;
import com.async.asyncMuseum.service.interfaces.ExpositionServiceInterface;
import com.async.asyncMuseum.util.MyUtil;

@Service
public class ExpositionService implements ExpositionServiceInterface {
    @Autowired
    public ExpositionRepository expositionRepository;

    @Override
    public List<ExpositionDto> getAll() {
        List<ExpositionDto> listExpositionDtos = expositionRepository.findAll().stream()
                .map(exposition -> MyUtil.convert(exposition, new ExpositionDto())).toList();
        return listExpositionDtos;
    }

    @Override
    public ExpositionDto getById(Long id) {
        return expositionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aucune rxposition trouvée")).toDto();
    }

    @Override
    public ExpositionDto create(ExpositionCreateDto dto) {
        Exposition exposition = dto.toModel();
        return expositionRepository.save(exposition).toDto();
    }

    @Override
    public ExpositionDto update(Long id, ExpositionCreateDto dto) { 
        Exposition exposition = MyUtil.convert(dto, getById(id)).toModel();
        exposition.setId(id);
        return expositionRepository.save(exposition).toDto();
    }

    @Override
    public String delete(Long id) {
        try {
            expositionRepository.deleteById(id);
        } catch (Exception e) {
            throw new DeleteException("Erreur lors de la suppresion de l'exposition");
        }
        return "L'exposition a été supprimée avec succès";
    }

}
