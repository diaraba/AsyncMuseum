package com.async.asyncMuseum.model;

import com.async.asyncMuseum.Enum.TypeExposition;
import com.async.asyncMuseum.dto.ExpositionDto;
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
@Table(name = "exposition")
public class Exposition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private String date_debut;
    private String date_fin;
    @ManyToOne
    private Musee musee;
    @OneToOne(mappedBy = "exposition")
    private Reservation reservation;
    private Long tarif;
    private TypeExposition typeExposition;
    @ManyToMany
    @JoinTable(
            name = "exposition_objet_musee",
            joinColumns = @JoinColumn(name = "id_exposition"),
            inverseJoinColumns = @JoinColumn(name = "id_objet")
    )
    private List<ObjetMusee> objetsMusee = new ArrayList<>();
    public ExpositionDto toDto(){
        return MyUtil.convert(this,new ExpositionDto());
    }
}
