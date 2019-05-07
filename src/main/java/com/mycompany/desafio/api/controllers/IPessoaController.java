package com.mycompany.desafio.api.controllers;

import com.mycompany.desafio.api.base.controller.IAbstractCrudController;
import com.mycompany.desafio.api.dtos.JPessoasDto;
import com.mycompany.desafio.api.entities.JPessoa;

public interface IPessoaController extends IAbstractCrudController<Long, JPessoa, JPessoasDto> {
    
}
