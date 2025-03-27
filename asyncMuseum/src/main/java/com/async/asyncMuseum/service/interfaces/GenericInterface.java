package com.async.asyncMuseum.service.interfaces;

import java.util.List;

public interface GenericInterface<R,P> {
    List<R> getAll();

    R getById(Long id);

    R create(P dto);

    R update(Long id, P dto);

    String delete(Long id);
}