package com.async.asyncMuseum.model;

import com.async.asyncMuseum.dto.ObjetMuseeDto;
import com.async.asyncMuseum.util.MyUtil;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "objet_musee")
public class ObjetMusee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private String typeObjet;
    private String provenance;
    private String date_decouverte;
    @ManyToOne
    private CollectionMusee collectionMusee;
    @ManyToMany(mappedBy = "objetsMusee")
    private List<Exposition> expositions = new ArrayList<>();
    public ObjetMuseeDto toDto(){
        return MyUtil.convert(this,new ObjetMuseeDto());
    }
}