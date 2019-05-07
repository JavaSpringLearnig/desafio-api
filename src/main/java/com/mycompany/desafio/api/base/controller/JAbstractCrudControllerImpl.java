package com.mycompany.desafio.api.base.controller;

import com.mycompany.desafio.api.base.dto.IAbstractDTO;
import com.mycompany.desafio.api.base.dto.JDTOUtils;
import com.mycompany.desafio.api.base.entity.JAbstractEntityClass;
import com.mycompany.desafio.api.base.exception.ServiceException;
import com.mycompany.desafio.api.base.messages.EDefaultMessages;
import com.mycompany.desafio.api.base.service.IAbstractCrudService;
import com.mycompany.desafio.api.base.service.IMessageService;
import com.mycompany.desafio.api.base.service.JEventService;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller responsavel por fazer a linkagem de um DTO para um tipo especifico
 *
 * @param <PK> Chave Primaria
 * @param <T> Tipo da Entidade
 * @param <DTO> DTO da Entidade que queremos trabalhar
 */
@RestController
public abstract class JAbstractCrudControllerImpl<PK extends Serializable, T extends JAbstractEntityClass<PK>, DTO extends IAbstractDTO<PK, T>> extends JAbstractReadOnlyControllerImpl<PK, T, DTO> implements IAbstractCrudController<PK, T, DTO> {

    private final Class<T> entityClass;

    private final Class<DTO> dtoClass;

    @Autowired
    private IAbstractCrudService<PK, T, DTO> service;

    @Autowired
    private IMessageService messageService;

    /**
     * Construtor da Classe
     *
     * @param entityClass
     * @param dtoClass
     */
    @SuppressWarnings("unchecked")
    public JAbstractCrudControllerImpl() {
        super();
        Type[] types = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
        this.entityClass = (Class<T>) types[1];
        this.dtoClass = (Class<DTO>) types[2];
    }

    @Override
    @PostMapping
    public DTO save(@RequestBody final DTO dto) throws ServiceException {
        final T t = JDTOUtils.convertToEntity(dto, this.entityClass);
        final T entitySaved = this.service.save(JEventService.from(t, dto));
        return JDTOUtils.convertToDTO(entitySaved, this.dtoClass);
    }

    @Override
    @PutMapping
    public DTO update(@RequestBody final DTO dto) throws ServiceException {
        final T t = JDTOUtils.convertToEntity(dto, this.entityClass);
        final T entitySaved = this.service.update(JEventService.from(t, dto));
        return JDTOUtils.convertToDTO(entitySaved, this.dtoClass);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void delete(@NotNull @PathVariable("id") final PK id) throws ServiceException {
        try {
            this.service.delete(JEventService.from(id));
        } catch (EmptyResultDataAccessException e) {
            throw new EmptyResultDataAccessException(messageService.getMessage(EDefaultMessages.ID_NOT_FIND.toString(), id.toString()), 1);

        }
    }
}
