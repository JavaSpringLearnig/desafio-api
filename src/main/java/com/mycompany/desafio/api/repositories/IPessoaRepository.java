package com.mycompany.desafio.api.repositories;

import com.mycompany.desafio.api.entities.JPessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IPessoaRepository extends JpaRepository<JPessoa, Long> , JpaSpecificationExecutor<JPessoa> {
    
}
