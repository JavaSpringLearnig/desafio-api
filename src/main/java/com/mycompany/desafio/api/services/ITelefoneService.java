package com.mycompany.desafio.api.services;

import com.mycompany.desafio.api.base.service.IAbstractCrudService;
import com.mycompany.desafio.api.dtos.JTelefoneDto;
import com.mycompany.desafio.api.entities.JTelefone;

public interface ITelefoneService extends IAbstractCrudService<Long, JTelefone, JTelefoneDto> {
    
}
