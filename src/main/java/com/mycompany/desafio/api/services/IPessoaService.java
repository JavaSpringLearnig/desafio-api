package com.mycompany.desafio.api.services;

import com.mycompany.desafio.api.base.service.IAbstractCrudService;
import com.mycompany.desafio.api.dtos.JPessoasDto;
import com.mycompany.desafio.api.entities.JPessoa;

public interface IPessoaService extends IAbstractCrudService<Long, JPessoa, JPessoasDto> {
    
}
