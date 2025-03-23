package com.async.asyncMuseum.dto;

import com.async.asyncMuseum.Enum.Jour;
import com.async.asyncMuseum.model.Horaire;
import com.async.asyncMuseum.util.MyUtil;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HoraireDto {
    private Long id;
    private Jour jour;
    private String ouverture;
    private String fermeture;
    private String status;
    public Horaire toDto(){
        return MyUtil.convert(this,new Horaire());
    }
}
