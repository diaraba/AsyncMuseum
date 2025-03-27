package com.async.asyncMuseum.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "visiteur_id", referencedColumnName = "id")
    private Visiteur visiteur;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "exposition_id", referencedColumnName = "id")
    private Exposition exposition;
    private String date_reservation;
    private Integer nombreTickets;
}
