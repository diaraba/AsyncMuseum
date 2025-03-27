package com.async.asyncMuseum.dto;

import com.async.asyncMuseum.model.CollectionMusee;
import com.async.asyncMuseum.util.MyUtil;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CollectionMuseeCreateDto {
    private String nom;
    private String description;
    private Long idMusee;

    public CollectionMusee toModel() {
        return MyUtil.convert(this, new CollectionMusee());
    }
}
