package com.mycompany.desafio.api.base.service;

import com.mycompany.desafio.api.base.dto.IAbstractDTO;
import com.mycompany.desafio.api.base.entity.JAbstractEntityClass;
import com.mycompany.desafio.api.base.exception.ServiceException;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Classe responsavel por ter um servico de um tipo especifico
 *
 * @param <PK> Tipo da Chave Primaria
 * @param <ENTITY> Tipo referente ao banco de Dados
 * @param <F> Filtro
 */
public interface IAbstractCrudService<PK extends Serializable, ENTITY extends JAbstractEntityClass<PK>, DTO extends IAbstractDTO<PK, ENTITY>> extends IAbstractReadOnlyService<PK, ENTITY> {

    /**
     * Salva um objeto
     *
     * @param t T para salvarmos
     * @return Retorna o T salvo
     */
    ENTITY save(@Valid @NotNull final JEventService<PK, ENTITY, DTO> event) throws ServiceException;

    /**
     * Realiza o Update em um T
     *
     * @param t T que queremos trabalhar
     * @return T atualizado
     */
    ENTITY update(@Valid @NotNull JEventService<PK, ENTITY, DTO> event) throws ServiceException;

    /**
     * Exclui um objeto
     *
     * @param id Id que queremos trabalhar
     * @throws ServiceException
     */
    void delete(@NotNull final JEventService<PK, ENTITY, DTO> event) throws ServiceException;

    /**
     * Remove o objeto da sessÃ£o.
     *
     * @param t T
     * @return T atualizado
     */
    @Override
    ENTITY detach(@Valid @NotNull ENTITY t) throws ServiceException;
}
