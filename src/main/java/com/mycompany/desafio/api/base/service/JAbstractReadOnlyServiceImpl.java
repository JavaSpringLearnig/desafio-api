package com.mycompany.desafio.api.base.service;

import com.mycompany.desafio.api.base.conf.AppConstants;
import com.mycompany.desafio.api.base.entity.IEntityClass;
import com.mycompany.desafio.api.base.exception.ServiceException;
import com.mycompany.desafio.api.base.rsql.CustomExampleSpecification;
import com.mycompany.desafio.api.base.rsql.CustomRsqlVisitor;
import java.io.Serializable;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Classe responsavel por delimitar a implementacao da camada de Servico em
 * forma de leitura
 *
 * @param <PK> - Tipo da PK
 * @param <T> - Tipo que queremos lidar
 */
public class JAbstractReadOnlyServiceImpl<PK extends Serializable, T extends IEntityClass<PK>> implements IAbstractReadOnlyService<PK, T> {

    @Autowired
    private JpaRepository<T, PK> repository;

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public Page<T> filter(final T example, final Pageable request, final String search) throws ServiceException {
        Pageable finalRequest = request;
        if (request == null) {
            finalRequest = new PageRequest(0, AppConstants.DEFAULT_LIMIT);
        }

        Example<T> entityExample = null;
        if (example != null) {
            entityExample = Example.of(example, ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING).withIgnoreCase());
        }

        if (StringUtils.isNotBlank(search)) {
            if (this.repository instanceof JpaSpecificationExecutor) {
                String regex = "\\s++$";
                String searchNoSpaces = search.replaceAll(regex, "");
                if (searchNoSpaces.charAt(searchNoSpaces.length() - 1) == '*') {
                    StringBuilder temp = new StringBuilder(searchNoSpaces);
                    temp.deleteCharAt(searchNoSpaces.length() - 1);
                    searchNoSpaces = temp.toString().replaceAll(regex, "") + "*";
                }
                Node rootNode = new RSQLParser().parse(searchNoSpaces);

                Specification<T> spec = rootNode.accept(new CustomRsqlVisitor<T>(entityExample != null ? new CustomExampleSpecification<T>(entityExample) : null));
                return ((JpaSpecificationExecutor<T>) this.repository).findAll(spec, request);
            } else {
                throw new ServiceException("Erro ao reliazar a consulta.", ArrayUtils.toPrimitive("A classe \"" + this.repository.getClass().getSimpleName() + "\" deve implementar \"JpaSpecificationExecutor\" para poder utilizar o a funcionalidade \"search\"."));
            }
        }

        if (entityExample != null) {
            return this.repository.findAll(entityExample, finalRequest);
        }
        return this.repository.findAll(finalRequest);
    }

    @Override
    public Optional<T> get(@NotNull final PK id) {
        final T t = this.repository.findOne(id);
        if (t != null) {
            return Optional.of(t);
        }
        return Optional.empty();
    }

    @Override
    public T detach(T t) throws ServiceException {
        this.em.detach(t);
        return t;
    }
}
