package com.mycompany.desafio.api.services.impl;

import com.mycompany.desafio.api.base.service.JAbstractCrudServiceImpl;
import com.mycompany.desafio.api.dtos.JTelefoneDto;
import com.mycompany.desafio.api.entities.JTelefone;
import com.mycompany.desafio.api.services.ITelefoneService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class JTelefoneServiceImpl extends JAbstractCrudServiceImpl<Long, JTelefone, JTelefoneDto> implements ITelefoneService {

}
