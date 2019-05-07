package com.mycompany.desafio.api.services.impl;

import com.mycompany.desafio.api.base.service.JAbstractCrudServiceImpl;
import com.mycompany.desafio.api.dtos.JPessoasDto;
import com.mycompany.desafio.api.entities.JPessoa;
import com.mycompany.desafio.api.services.IPessoaService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class JPessoaServiceImpl extends JAbstractCrudServiceImpl<Long, JPessoa, JPessoasDto> implements IPessoaService {
    
}
