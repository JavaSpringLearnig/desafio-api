package com.mycompany.desafio.api.base.controller;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.desafio.api.base.dto.IAbstractDTO;
import com.mycompany.desafio.api.base.dto.JDTOUtils;
import com.mycompany.desafio.api.base.entity.IEntityClass;
import com.mycompany.desafio.api.base.exception.ServiceException;
import com.mycompany.desafio.api.base.messages.EDefaultMessages;
import com.mycompany.desafio.api.base.service.IAbstractReadOnlyService;
import com.mycompany.desafio.api.base.service.IMessageService;
import com.mycompany.desafio.api.base.util.ETipoOrdenacao;
import com.mycompany.desafio.api.base.util.JPageableCustom;
import com.mycompany.desafio.api.dtos.JPageDTO;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Controller responsavel por fazer a linkagem de um DTO para um tipo especifico
 *
 * @param <PK> Chave Primaria
 * @param <T> Tipo da Entidade
 * @param <DTO> DTO da Entidade que queremos trabalhar
 */
@RestController
public abstract class JAbstractReadOnlyControllerImpl<PK extends Serializable, T extends IEntityClass<PK>, DTO extends IAbstractDTO<PK, T>> implements IAbstractReadOnlyController<PK, T, DTO> {

    private final Class<T> entityClass;

    private final Class<DTO> dtoClass;

    @Autowired
    private IAbstractReadOnlyService<PK, T> service;

    @Autowired
    private IMessageService messageService;

    /**
     * Construtor da Classe
     *
     * @param entityClass
     * @param dtoClass
     */
    @SuppressWarnings("unchecked")
    public JAbstractReadOnlyControllerImpl() {
        super();
        Type[] types = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
        this.entityClass = (Class<T>) types[1];
        this.dtoClass = (Class<DTO>) types[2];
    }

    @Override
    @GetMapping
    public Page<DTO> filter(JPageDTO page, final DTO example, @RequestParam(value = "search", required = false) String search) throws ServiceException {
        T entityExample = null;
        if (example != null) {
            entityExample = JDTOUtils.convertToEntity(example, this.entityClass);
        }
        Sort sort = null;
        if (page.getPageOrderBy() != null) {
            if (page.getPageDirection() == ETipoOrdenacao.DESC) {
                sort = new Sort(new Sort.Order(Direction.DESC, page.getPageOrderBy()));
            } else {
                sort = new Sort(new Sort.Order(Direction.ASC, page.getPageOrderBy()));
            }
        }
        JPageableCustom pageable = new JPageableCustom(page.getPageNumber() - 1, page.getPageSize(), sort);
        final Page<T> filter = this.service.filter(entityExample, pageable, search);
        final Page<DTO> pageRetorno = filter.map(e -> JDTOUtils.convertToDTO(e, this.dtoClass));
        return pageRetorno;
    }

    @Override
    @GetMapping(value = "/{id:.+}")
    public DTO get(@NotNull @PathVariable("id") final PK id) throws Exception {
        final Optional<T> t = this.service.get(id);
        if (!t.isPresent()) {
            throw new EmptyResultDataAccessException(messageService.getMessage(EDefaultMessages.ID_NOT_FIND.toString(), id.toString()), 1);
        }
        return JDTOUtils.convertToDTO(t.get(), this.dtoClass);
    }
}
