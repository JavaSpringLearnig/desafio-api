package com.mycompany.desafio.api.dtos;

import com.mycompany.desafio.api.base.dto.IAbstractDTO;
import com.mycompany.desafio.api.entities.JPessoa;

public class JPessoaKeyDto implements IAbstractDTO<Long, JPessoa> {

    private static final long serialVersionUID = 1L;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
