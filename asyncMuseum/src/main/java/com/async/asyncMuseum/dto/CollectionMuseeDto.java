package com.async.asyncMuseum.dto;

import com.async.asyncMuseum.model.CollectionMusee;
import com.async.asyncMuseum.model.Musee;
import com.async.asyncMuseum.util.MyUtil;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CollectionMuseeDto {
    private Long id;
    private String nom;
    private String description;
    private Musee musee;

    public CollectionMusee toModel() {
        return MyUtil.convert(this, new CollectionMusee());
    }
}
