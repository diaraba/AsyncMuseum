package com.async.asyncMuseum.model;

import com.async.asyncMuseum.Enum.Jour;
import com.async.asyncMuseum.dto.HoraireDto;
import com.async.asyncMuseum.util.MyUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "horaire")
public class Horaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Jour jour;
    private String ouverture;
    private String fermeture;
    private String status;

    public HoraireDto toDto() {
        return MyUtil.convert(this, new HoraireDto());
    }
}
