package com.mycompany.desafio.api.base.controller;

import com.mycompany.desafio.api.base.dto.IAbstractDTO;
import com.mycompany.desafio.api.base.entity.IEntityClass;
import com.mycompany.desafio.api.base.exception.ServiceException;
import com.mycompany.desafio.api.dtos.JPageDTO;
import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Interface que define os metodos padrÃµes de um controlador de CRUD
 *
 * @param <PK> Chave Primaria
 * @param <T> Entidade de Origem
 * @param <DTO> DTO que representa a entidade em questao
 */
public interface IAbstractReadOnlyController<PK extends Serializable, T extends IEntityClass<PK>, DTO extends IAbstractDTO<PK, T>> {

    /**
     * Filtra as informacoes com base nas informacoes advindas do filter
     *
     * @param example Exemplo
     * @return Page encontrada
     * @throws ServiceException
     */
    Page<DTO> filter(JPageDTO page, DTO example, @RequestParam("search") String search) throws ServiceException;

    /**
     * Retorna uma instancia com o ID passado por parametro
     *
     * @param id Id que queremos trabalhar
     * @return T com os valores encontrados
     */
    DTO get(PK id) throws Exception;
}
