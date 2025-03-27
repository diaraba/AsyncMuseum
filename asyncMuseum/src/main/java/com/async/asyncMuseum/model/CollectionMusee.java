package com.async.asyncMuseum.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import com.async.asyncMuseum.dto.CollectionMuseeDto;
import com.async.asyncMuseum.util.MyUtil;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "collection_musee")
public class CollectionMusee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    @ManyToOne
    private Musee musee;
    @OneToMany(mappedBy = "collectionMusee")
    private List<ObjetMusee> objets;

    public CollectionMuseeDto toDto() {
        return MyUtil.convert(this, new CollectionMuseeDto());
    }
}
