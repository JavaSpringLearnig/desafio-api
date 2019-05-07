package com.mycompany.desafio.api.base.entity;

import java.io.Serializable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Classe abstrata responsavel pela definicao basica das classes do sistema
 */
public abstract class JAbstractEntityClass<PK extends Serializable> implements IEntityClass<PK> {

    private static final long serialVersionUID = 1L;

    /**
     * Metodo responsavel por retornar o campo
     *
     * @return retorna o campo Id
     */
    public abstract PK getId();

    @PrePersist
    private void prePersist() {

    }

    @PreUpdate
    private void preUpdate() {

    }
}
