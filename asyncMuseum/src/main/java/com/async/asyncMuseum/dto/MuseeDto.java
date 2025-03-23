package com.async.asyncMuseum.dto;

import com.async.asyncMuseum.model.Exposition;
import com.async.asyncMuseum.model.Horaire;
import com.async.asyncMuseum.model.Musee;
import com.async.asyncMuseum.util.MyUtil;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MuseeDto {
    private String nom;
    private String description;
    private String adresse;
    private String telephone;
    private String email;
    private List<Horaire> horaires ;
    public Musee toModel(){
        return MyUtil.convert(this,new Musee());
    }
}
