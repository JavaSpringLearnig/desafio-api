package com.mycompany.desafio.api.base.service;

import com.google.common.util.concurrent.AbstractService;
import com.mycompany.desafio.api.base.dto.IAbstractDTO;
import com.mycompany.desafio.api.base.entity.JAbstractEntityClass;
import java.io.Serializable;

/**
 * Classe que representa um evento para o {@link AbstractService}.
 *
 * @param <PK> - {@link Serializable}
 * @param <ENTITY> - {@link AbstractEntityClass}
 * @param <DTO> - {@link AbstractDTO}
 */
public class JEventService<PK extends Serializable, ENTITY extends JAbstractEntityClass<PK>, DTO extends IAbstractDTO<PK, ENTITY>> {

    private PK pk;
    private ENTITY entity;
    private DTO dto;

    private JEventService(PK pk, ENTITY entity, DTO dto) {
        super();
        this.pk = pk;
        this.entity = entity;
        this.dto = dto;
    }

    /**
     * Constroi um evento com base na entidade e no dto.
     *
     * @param entity - ENTITY
     * @param dto - DTO
     */
    public static <PK extends Serializable, ENTITY extends JAbstractEntityClass<PK>, DTO extends IAbstractDTO<PK, ENTITY>> JEventService<PK, ENTITY, DTO> from(ENTITY entity, DTO dto) {
        PK pk = entity.getId() != null ? entity.getId() : null;
        return new JEventService<>(pk, entity, dto);
    }

    /**
     * Constroi um evento com base na entidade e no dto.
     *
     * @param entity - ENTITY
     * @param dto - DTO
     */
    public static <PK extends Serializable, ENTITY extends JAbstractEntityClass<PK>, DTO extends IAbstractDTO<PK, ENTITY>> JEventService<PK, ENTITY, DTO> from(ENTITY entity) {
        PK pk = entity.getId() != null ? entity.getId() : null;
        return new JEventService<>(pk, entity, null);
    }

    /**
     * Constroi um evento com base na entidade e no dto.
     *
     * @param pk - PK
     */
    public static <PK extends Serializable, ENTITY extends JAbstractEntityClass<PK>, DTO extends IAbstractDTO<PK, ENTITY>> JEventService<PK, ENTITY, DTO> from(PK pk) {
        return new JEventService<>(pk, null, null);
    }

    /**
     * Returna o valor do campo pk.
     *
     * @return pk - PK
     */
    public PK getPk() {
        return pk;
    }

    /**
     * Returna o valor do campo entity.
     *
     * @return entity - ENTITY
     */
    public ENTITY getEntity() {
        return entity;
    }

    /**
     * Returna o valor do campo dto.
     *
     * @return dto - DTO
     */
    public DTO getDto() {
        return dto;
    }
}
