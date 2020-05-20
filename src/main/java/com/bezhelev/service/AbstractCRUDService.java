package com.bezhelev.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
public abstract class AbstractCRUDService<E, ID> implements CRUDInterface<E, ID> {

    private JpaRepository<E, ID> jpaRepository;

    protected JpaRepository getJpaRepository() {
        return jpaRepository;
    }

    @Override
    public E getEntity(ID id) {
        log.info(String.format("AbstractCRUDService.getEntity(), params: id = %s", id));
        E entity = null;
        if (Objects.nonNull(id)) {
            entity = jpaRepository.getOne(id);
        }
        return entity;
    }

    @Override
    public E updateEntity(ID id, E entity) {
        log.info(String.format("AbstractCRUDService.updateEntity(), params: entity = %s", entity));
        if (Objects.nonNull(entity)) {
            Optional<E> oldEntityOptional = getJpaRepository().findById(id);
            if (oldEntityOptional.isPresent()) {
                E oldEntity = oldEntityOptional.get();
                updateFields(oldEntity, entity);
                getJpaRepository().save(oldEntity);
            }
        }
        return entity;
    }

    @Override
    public E saveEntity(E entity) {
        log.info(String.format("AbstractCRUDService.saveEntity(), params: entity = %s", entity));
        if (Objects.nonNull(entity)) {
            entity = jpaRepository.save(entity);
        }
        return entity;
    }

    @Override
    public void deleteEntity(E entity) {
        log.info(String.format("AbstractCRUDService.deleteEntity(), params: id = %s", entity));
        if (Objects.nonNull(entity)) {
            jpaRepository.delete(entity);
        }
    }

    protected abstract void updateFields(E oldEntity, E newEntity);
}
