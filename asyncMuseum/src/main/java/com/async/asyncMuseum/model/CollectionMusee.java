package com.async.asyncMuseum.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "collection_musee")
public class CollectionMusee {
    @Id
    private Long id;
    private String nom;
    private String description;
    @ManyToOne
    private Musee musee;
    @OneToMany(mappedBy = "collectionMusee")
    private List<ObjetMusee> objets;
}
