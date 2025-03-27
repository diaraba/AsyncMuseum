package com.async.asyncMuseum.dto;
    
import com.async.asyncMuseum.model.ObjetMusee;
import com.async.asyncMuseum.util.MyUtil;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ObjetMuseeCreateDto {
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
