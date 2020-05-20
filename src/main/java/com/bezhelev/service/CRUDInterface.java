package com.bezhelev.service;

public interface CRUDInterface<E, ID> {

    E getEntity(ID id);

    E saveEntity(E entity);

    E updateEntity(ID id, E entity);

    void deleteEntity(E entity);
}
