package com.mycompany.desafio.api.base.controller;

import com.mycompany.desafio.api.base.dto.IAbstractDTO;
import com.mycompany.desafio.api.base.entity.JAbstractEntityClass;
import com.mycompany.desafio.api.base.exception.ServiceException;
import java.io.Serializable;

/**
 * Interface que define os metodos padroes de um controlador de CRUD
 *
 * @param <PK> Chave Primaria
 * @param <T> Entidade de Origem
 * @param <DTO> DTO que representa a entidade em questaoquestÃ£o
 */
public interface IAbstractCrudController<PK extends Serializable, T extends JAbstractEntityClass<PK>, DTO extends IAbstractDTO<PK, T>> extends IAbstractReadOnlyController<PK, T, DTO> {

    /**
     * Salva um objeto
     *
     * @param t T para salvarmos
     * @return Retorna o T salvo
     */
    DTO save(DTO dto) throws ServiceException;

    /**
     * Realiza o Update em um T
     *
     * @param t T que queremos trabalhar
     * @return T atualizado
     */
    DTO update(DTO dto) throws ServiceException;

    /**
     * Retorna uma instancia com o ID passado por parametro e remove o mesmo
     *
     * @param id Id que queremos trabalhar
     * @return T com os valores encontrados
     */
    void delete(PK id) throws ServiceException;
}
