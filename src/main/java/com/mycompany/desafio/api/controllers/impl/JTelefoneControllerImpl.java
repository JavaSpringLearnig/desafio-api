package com.mycompany.desafio.api.controllers.impl;

import com.mycompany.desafio.api.base.controller.JAbstractCrudControllerImpl;
import com.mycompany.desafio.api.controllers.ITelefoneController;
import com.mycompany.desafio.api.dtos.JTelefoneDto;
import com.mycompany.desafio.api.entities.JTelefone;
import com.mycompany.desafio.api.enums.ETipoTelefone;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value="v1/telefones", produces = "application/json;charset=UTF-8")
@Api(value="desafio-api")
public class JTelefoneControllerImpl extends JAbstractCrudControllerImpl<Long, JTelefone, JTelefoneDto> implements ITelefoneController {
    
    @GetMapping(path = "/tipos")
    @ApiOperation(value = "Retorna lista de tipo de telefone")
	public ResponseEntity<?> listarTipoCampo() {
		return ResponseEntity.ok().body(ETipoTelefone.values());
	}
    
}
