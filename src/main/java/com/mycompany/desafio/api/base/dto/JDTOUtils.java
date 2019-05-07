package com.mycompany.desafio.api.base.dto;

import com.mycompany.desafio.api.base.entity.IEntityClass;
import java.io.Serializable;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

/**
 * Classe utilitaria para lidar com DTOs
 */
public class JDTOUtils {

    private JDTOUtils() {

    }

    /**
     * Converte para entidade
     *
     * @param example Exemplo
     * @return Objeto convertido para T
     */
    public static <PK extends Serializable, T extends IEntityClass<PK>, DTO extends IAbstractDTO<PK, T>> DTO convertToDTO(final T example, final Class<DTO> dtoClass) {
        final ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(example, dtoClass);
    }

    /**
     * Converte de entidade para DTO
     *
     * @param example Exemplo
     * @return Objeto convertido para DTO
     */
    public static <PK extends Serializable, T extends IEntityClass<PK>, DTO extends IAbstractDTO<PK, T>> T convertToEntity(final DTO example, final Class<T> entityClass) {
        final ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(example, entityClass);
    }
}
