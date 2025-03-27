package com.async.asyncMuseum.dto;

import com.async.asyncMuseum.Enum.TypeExposition;
import com.async.asyncMuseum.model.Exposition;
import com.async.asyncMuseum.model.ObjetMusee;
import com.async.asyncMuseum.util.MyUtil;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ExpositionCreateDto {
    private String nom;
    private String description;
    private String date_debut;
    private String date_fin;
    private Long idMusee;
    private Long tarif;
    private TypeExposition typeExposition;
    private List<ObjetMusee> objetsMusee = new ArrayList<>();
    public Exposition toModel(){
        return MyUtil.convert(this,new Exposition());
    }
}