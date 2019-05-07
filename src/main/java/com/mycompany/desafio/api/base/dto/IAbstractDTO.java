package com.mycompany.desafio.api.base.dto;

import com.mycompany.desafio.api.base.entity.IEntityClass;
import java.io.Serializable;

/**
 * Classe Abstrata responsavel por linkar um DTO para um Objeto
 *
 * @param <PK> Chave Primaria
 * @param <T> Tipo que o DTO faz Referencia
 */
public interface IAbstractDTO<PK extends Serializable, T extends IEntityClass<PK>> extends Serializable {
    
}
