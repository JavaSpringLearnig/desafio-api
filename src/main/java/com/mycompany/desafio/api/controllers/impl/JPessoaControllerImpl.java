package com.mycompany.desafio.api.controllers.impl;

import com.mycompany.desafio.api.base.controller.JAbstractCrudControllerImpl;
import com.mycompany.desafio.api.controllers.IPessoaController;
import com.mycompany.desafio.api.dtos.JPessoasDto;
import com.mycompany.desafio.api.entities.JPessoa;
import com.mycompany.desafio.api.enums.ETipoEndereco;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value="v1/pessoas", produces = "application/json;charset=UTF-8")
@Api(value="desafio-api")
public class JPessoaControllerImpl extends JAbstractCrudControllerImpl<Long, JPessoa, JPessoasDto> implements IPessoaController {
    
    @GetMapping(path = "/tipos-endereco")
    @ApiOperation(value = "Retorna lista de tipo de endereços")
	public ResponseEntity<?> listarTipoCampo() {
		return ResponseEntity.ok().body(ETipoEndereco.values());
	}
}
