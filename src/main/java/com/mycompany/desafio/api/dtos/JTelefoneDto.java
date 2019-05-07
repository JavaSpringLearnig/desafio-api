package com.mycompany.desafio.api.dtos;

import com.mycompany.desafio.api.base.dto.IAbstractDTO;
import com.mycompany.desafio.api.entities.JTelefone;
import javax.validation.constraints.NotNull;

public class JTelefoneDto implements IAbstractDTO<Long, JTelefone> {

    private static final long serialVersionUID = 1L;
    private Long id;

    @NotNull(message = " O tipo endereco e obrigatorio")
    private Integer codigoTipoTelefone;

    @NotNull(message = " O ddi e obrigatorio.")
    private String ddi;

    @NotNull(message = " O ddd e obrigatorio.")
    private String ddd;

    @NotNull(message = " O numero telefone e obrigatorio.")
    private String numeroTelefone;

    @NotNull(message = " Pessoa e obrigatorio.")
    private JPessoaKeyDto pessoa;

    public JTelefoneDto() {
    }

    public JTelefoneDto(Long id, Integer codigoTipoTelefone, String ddi, String ddd, String numeroTelefone, JPessoaKeyDto pessoa) {
        this.id = id;
        this.codigoTipoTelefone = codigoTipoTelefone;
        this.ddi = ddi;
        this.ddd = ddd;
        this.numeroTelefone = numeroTelefone;
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodigoTipoTelefone() {
        return codigoTipoTelefone;
    }

    public void setCodigoTipoTelefone(Integer codigoTipoTelefone) {
        this.codigoTipoTelefone = codigoTipoTelefone;
    }

    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        this.ddi = ddi;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public JPessoaKeyDto getPessoa() {
        return pessoa;
    }

    public void setPessoa(JPessoaKeyDto pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "JTelefoneDto{" + "id=" + id + ", codigoTipoTelefone=" + codigoTipoTelefone + ", ddi=" + ddi + 
                ", ddd=" + ddd + ", numeroTelefone=" + numeroTelefone + ", pessoa=" + pessoa + '}';
    }
}
