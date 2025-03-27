package com.async.asyncMuseum.service.implementations;

import com.async.asyncMuseum.dto.MuseeCreateDto;
import com.async.asyncMuseum.dto.MuseeDto;
import com.async.asyncMuseum.exception.DeleteException;
import com.async.asyncMuseum.exception.ResourceNotFoundException;
import com.async.asyncMuseum.model.Horaire;
import com.async.asyncMuseum.model.Musee;
import com.async.asyncMuseum.repository.MuseeRepository;
import com.async.asyncMuseum.service.interfaces.MuseeServiceInterface;
import com.async.asyncMuseum.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuseeService implements MuseeServiceInterface {
    @Autowired
    MuseeRepository museeRepository;
    @Autowired
    HoraireService horaireService;

    @Override
    public List<MuseeDto> getAll() {
        return museeRepository.findAll().stream().map((musees) -> MyUtil.convert(musees, new MuseeDto())).toList();
    }

    @Override
    public MuseeDto getById(Long id) {
        return museeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cette musée n'Existe pas"))
                .toDto();
    }

    @Override
    public MuseeDto create(MuseeCreateDto museeDto) {
        Musee musee = museeDto.toModel();
        List<Horaire> horaires=museeDto.getIdHoraires().stream().map(idHoraire->horaireService.getById(idHoraire).toModel()).toList();
        musee.setHoraires(horaires);
        return museeRepository.save(musee).toDto();
    }

    @Override
    public MuseeDto update(Long id, MuseeCreateDto museeDto) {
        Musee musee = MyUtil.convert(museeDto, getById(id)).toModel();
        musee.setId(id);
        musee = museeRepository.save(musee);
        return musee.toDto();
    }

    @Override
    public String delete(Long id) {
        try {
            museeRepository.deleteById(id);
        } catch (Exception e) {
            throw new DeleteException("Erreur lors de la suppression de la musée");
        }
        return "Musée supprimer avec succès";
    }
}
