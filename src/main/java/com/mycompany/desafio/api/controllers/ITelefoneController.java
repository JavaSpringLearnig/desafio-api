package com.mycompany.desafio.api.controllers;

import com.mycompany.desafio.api.base.controller.IAbstractCrudController;
import com.mycompany.desafio.api.dtos.JTelefoneDto;
import com.mycompany.desafio.api.entities.JTelefone;

public interface ITelefoneController extends IAbstractCrudController<Long, JTelefone, JTelefoneDto> {
    
}
