package com.async.asyncMuseum.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.async.asyncMuseum.dto.CollectionMuseeCreateDto;
import com.async.asyncMuseum.dto.CollectionMuseeDto;
import com.async.asyncMuseum.exception.DeleteException;
import com.async.asyncMuseum.exception.ResourceNotFoundException;
import com.async.asyncMuseum.model.CollectionMusee;
import com.async.asyncMuseum.model.Musee;
import com.async.asyncMuseum.repository.CollectionMuseeRepository;
import com.async.asyncMuseum.service.interfaces.CollectionMuseeServiceInterface;
import com.async.asyncMuseum.util.MyUtil;

@Service
public class CollectionMuseeService implements CollectionMuseeServiceInterface {
    @Autowired
    public CollectionMuseeRepository collectionMuseeRepository;
    @Autowired 
    public MuseeService museeService; 

    @Override
    public List<CollectionMuseeDto> getAll() {
        List<CollectionMuseeDto> listDtos = collectionMuseeRepository.findAll().stream()
                .map(collectionMusee -> MyUtil.convert(collectionMusee, new CollectionMuseeDto())).toList();
        return listDtos;
    }

    @Override
    public CollectionMuseeDto getById(Long id) {
        return collectionMuseeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aucune collection n'a été trouvée")).toDto();
    }

    @Override
    public CollectionMuseeDto create(CollectionMuseeCreateDto dto) {
        CollectionMusee collectionMusee = dto.toModel();
        Musee musee=museeService.getById(dto.getIdMusee()).toModel();
        collectionMusee.setMusee(musee);
        return collectionMuseeRepository.save(collectionMusee).toDto();
    }

    @Override
    public CollectionMuseeDto update(Long id, CollectionMuseeCreateDto dto) {
        CollectionMusee collectionMusee = MyUtil.convert(dto, getById(id)).toModel();
        collectionMusee.setId(id);
        return collectionMuseeRepository.save(collectionMusee).toDto();
    }

    @Override
    public String delete(Long id) {
        try {
            collectionMuseeRepository.deleteById(id);
        } catch (Exception e) {
            throw new DeleteException("Erreur lors de la suppresion de la collection");
        }
        return "La collection a été supprimée avec succès";
    }

}
