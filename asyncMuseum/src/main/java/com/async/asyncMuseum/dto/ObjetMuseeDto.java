package com.async.asyncMuseum.dto;

import com.async.asyncMuseum.model.CollectionMusee;
import com.async.asyncMuseum.model.Musee;
import com.async.asyncMuseum.model.ObjetMusee;
import com.async.asyncMuseum.util.MyUtil;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ObjetMuseeDto {
    private Long id;
    private String nom;
    private String description;
    private String typeObjet;
    private String provenance;
    private String date_decouverte;
    private Long idCollectionMusee;
    public ObjetMusee toModel(){
        return MyUtil.convert(this,new ObjetMusee());
    }
}
