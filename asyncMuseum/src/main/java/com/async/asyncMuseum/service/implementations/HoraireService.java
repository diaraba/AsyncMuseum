package com.async.asyncMuseum.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.async.asyncMuseum.dto.HoraireCreateDto;
import com.async.asyncMuseum.dto.HoraireDto;
import com.async.asyncMuseum.exception.DeleteException;
import com.async.asyncMuseum.exception.ResourceNotFoundException;
import com.async.asyncMuseum.model.Horaire;
import com.async.asyncMuseum.repository.HoraireRepository;
import com.async.asyncMuseum.service.interfaces.HoraireServiceInterface;
import com.async.asyncMuseum.util.MyUtil;

@Service
public class HoraireService implements HoraireServiceInterface{

    @Autowired
    public HoraireRepository horaireRepository;
    @Override
    public List<HoraireDto> getAll() {
        List<HoraireDto> listDtos= horaireRepository.findAll().stream().map(horaire->MyUtil.convert(horaire,new HoraireDto())).toList();
        return listDtos; 
    }

    @Override
    public HoraireDto getById(Long id) {
        return horaireRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Aucune horaire trouvée")).toDto();
    }

    @Override
    public HoraireDto create(HoraireCreateDto horaireDto) {
       Horaire horaire=horaireDto.toModel();
       return  horaireRepository.save(horaire).toDto();
    }

    @Override
    public HoraireDto update(Long id, HoraireCreateDto horaireDto) {
       Horaire horaire=MyUtil.convert(horaireDto, getById(id)).toModel();
       horaire.setId(id);
       return horaireRepository.save(horaire).toDto();
    }

    @Override
    public String delete(Long id) {
        try {
            horaireRepository.deleteById(id);
        }catch (Exception e){
            throw new DeleteException("Erreur lors de la suppression de l'horaire");
        }
        return "Horaire supprimer avec succès";
    }
    
}
