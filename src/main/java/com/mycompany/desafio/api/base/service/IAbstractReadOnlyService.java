package com.mycompany.desafio.api.base.service;

import com.mycompany.desafio.api.base.entity.IEntityClass;
import com.mycompany.desafio.api.base.exception.ServiceException;
import java.io.Serializable;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Classe responsavel por ter uum servioo de um tipo especifico
 *
 * @param <PK> Tipo da Chave Primaria
 * @param <T> Tipo referente ao banco de Dados
 * @param <F> Filtro
 */
public interface IAbstractReadOnlyService<PK extends Serializable, T extends IEntityClass<PK>> {

    /**
     * Metodo responsÃ¡vel por filtrar uma entidade com base em um exemplo
     * passado e um Page Request
     *
     * @param example Exemplo
     * @param request Page Request
     * @return Pagina dos objetos filtrados
     * @throws ServiceException
     */
    Page<T> filter(final T example, final Pageable request, final String search) throws ServiceException;

    /**
     * Retorna uma instancia com o ID passado por parÃ¢metro
     *
     * @param id Id que queremos trabalhar
     * @return T com os valores encontrados
     */
    Optional<T> get(@NotNull PK id);

    /**
     * Remove o objeto da sessÃ£o.
     *
     * @param t T
     * @return T atualizado
     */
    T detach(@Valid @NotNull T t) throws ServiceException;
}
