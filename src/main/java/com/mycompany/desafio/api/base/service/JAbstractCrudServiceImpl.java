package com.mycompany.desafio.api.base.service;

import java.io.Serializable;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.desafio.api.base.dto.IAbstractDTO;
import com.mycompany.desafio.api.base.entity.JAbstractEntityClass;
import com.mycompany.desafio.api.base.exception.ServiceException;

/**
 * Classe responsavel por delimitar a implementacao da camada de Servico em
 * forma de CRUD
 *
 * @param <PK> - Tipo da PK
 * @param <ENTITY> - Tipo que queremos lidar
 */
public class JAbstractCrudServiceImpl<PK extends Serializable, ENTITY extends JAbstractEntityClass<PK>, DTO extends IAbstractDTO<PK, ENTITY>>
        extends JAbstractReadOnlyServiceImpl<PK, ENTITY> implements IAbstractCrudService<PK, ENTITY, DTO> {

    @Autowired
    private JpaRepository<ENTITY, PK> repository;

    private static final String ERRO_AO_SALVAR = "Erro ao salvar o registro!";

    protected void beforeSave(JEventService<PK, ENTITY, DTO> event) throws ServiceException {
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public ENTITY save(@Valid @NotNull final JEventService<PK, ENTITY, DTO> event) throws ServiceException {
        beforeSave(event);

        ENTITY save = null;
        save = this.repository.save(event.getEntity());

        if (save != null) {
            afterSaved(save);
        } else {
            throw new ServiceException(JAbstractCrudServiceImpl.ERRO_AO_SALVAR, null);
        }

        return save;
    }

    protected void afterSaved(ENTITY t) throws ServiceException {
    }

    protected void beforeUpdate(JEventService<PK, ENTITY, DTO> event) throws ServiceException {
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public ENTITY update(@Valid @NotNull final JEventService<PK, ENTITY, DTO> event) throws ServiceException {
        beforeUpdate(event);

        Optional<ENTITY> optional = this.get(event.getPk());
        ENTITY tOld = null;
        if (optional.isPresent()) {
            tOld = this.detach(optional.get());
        }

        ENTITY save = null;
        save = this.repository.save(event.getEntity());

        if (save != null) {
            afterUpdated(save, tOld);
        } else {
            throw new ServiceException(JAbstractCrudServiceImpl.ERRO_AO_SALVAR, null);
        }
        return save;
    }

    protected void afterUpdated(ENTITY tNew, ENTITY tOld) throws ServiceException {
    }

    @Override
    public void delete(@NotNull final JEventService<PK, ENTITY, DTO> event) throws ServiceException {

        Optional<ENTITY> optional = this.get(event.getPk());
        if (optional.isPresent()) {
            this.repository.delete(optional.get());
        } else {
            throw new ServiceException(JAbstractCrudServiceImpl.ERRO_AO_SALVAR, null);
        }
    }
}
