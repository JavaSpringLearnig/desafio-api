package com.mycompany.desafio.api.repositories;

import com.mycompany.desafio.api.entities.JTelefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ITelefoneRepository extends JpaRepository<JTelefone, Long> , JpaSpecificationExecutor<JTelefone> {
    
}
