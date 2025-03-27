package com.async.asyncMuseum.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.async.asyncMuseum.dto.ObjetMuseeCreateDto;
import com.async.asyncMuseum.dto.ObjetMuseeDto;
import com.async.asyncMuseum.exception.DeleteException;
import com.async.asyncMuseum.exception.ResourceNotFoundException;
import com.async.asyncMuseum.model.ObjetMusee;
import com.async.asyncMuseum.repository.ObjetMuseeRepository;
import com.async.asyncMuseum.service.interfaces.ObjetMuseeServiceInterface;
import com.async.asyncMuseum.util.MyUtil;

@Service
public class ObjetMuseeService implements ObjetMuseeServiceInterface {
    @Autowired
    public ObjetMuseeRepository objetMuseeRepository;

    @Override
    public List<ObjetMuseeDto> getAll() {
        List<ObjetMuseeDto> listObjetMuseeDtos = objetMuseeRepository.findAll().stream()
                .map(objetMusee -> MyUtil.convert(objetMusee, new ObjetMuseeDto())).toList();
        return listObjetMuseeDtos;
    }

    @Override
    public ObjetMuseeDto getById(Long id) {
        return objetMuseeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aucun objet de musée trouvée")).toDto();
    }

    @Override
    public ObjetMuseeDto create(ObjetMuseeCreateDto dto) {
        ObjetMusee objetMusee = dto.toModel();
        return objetMuseeRepository.save(objetMusee).toDto();
    }

    @Override
    public ObjetMuseeDto update(Long id, ObjetMuseeCreateDto dto) {
        ObjetMusee objetMusee = MyUtil.convert(dto, getById(id)).toModel();
        objetMusee.setId(id);
        return objetMuseeRepository.save(objetMusee).toDto();
    }

    @Override
    public String delete(Long id) {
       try {
         objetMuseeRepository.deleteById(id);
       } catch (Exception e) {
        throw new DeleteException("Erreur lors de la suppression de l'objet de musée");
       }
       return "Objet musée supprimée avec succès";
    }

}
