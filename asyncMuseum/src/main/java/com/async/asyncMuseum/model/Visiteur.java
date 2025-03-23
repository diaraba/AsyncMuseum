package com.async.asyncMuseum.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "visiteur")
public class Visiteur {
    @Id
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    @OneToOne(mappedBy = "visiteur")
    private Reservation reservation;
}
