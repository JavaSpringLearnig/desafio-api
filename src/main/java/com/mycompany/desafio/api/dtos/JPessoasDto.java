package com.mycompany.desafio.api.dtos;

import com.mycompany.desafio.api.base.dto.IAbstractDTO;
import com.mycompany.desafio.api.entities.JPessoa;
import java.util.List;
import javax.validation.constraints.NotNull;

public class JPessoasDto implements IAbstractDTO<Long, JPessoa> {

    private static final long serialVersionUID = 1L;
    private Long id;
    
    @NotNull(message = " O nome e obrigatorio.")
    private String nome;

    @NotNull(message = " A idade e obrigatoria.")
    private Integer idade;

    @NotNull(message = " O tipo endereco e obrigatorio")
    private Integer codigoTipoEndereco;

    @NotNull(message = " O nome endereco e obrigatorio.")
    private String nomeEndereco;

    @NotNull(message = " O CEP e obrigatorio.")
    private String cep;

    @NotNull(message = " O numero e obrigatorio.")
    private String numero;
   
    private List<JTelefoneDto> telefones;

    public JPessoasDto() {
        super();
    }

    public JPessoasDto(Long id, String nome, Integer idade, Integer codigoTipoEndereco, String nomeEndereco, String cep, String numero, List<JTelefoneDto> telefones) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.codigoTipoEndereco = codigoTipoEndereco;
        this.nomeEndereco = nomeEndereco;
        this.cep = cep;
        this.numero = numero;
        this.telefones = telefones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getCodigoTipoEndereco() {
        return codigoTipoEndereco;
    }

    public void setCodigoTipoEndereco(Integer codigoTipoEndereco) {
        this.codigoTipoEndereco = codigoTipoEndereco;
    }

    public String getNomeEndereco() {
        return nomeEndereco;
    }

    public void setNomeEndereco(String nomeEndereco) {
        this.nomeEndereco = nomeEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<JTelefoneDto> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<JTelefoneDto> telefones) {
        this.telefones = telefones;
    }

    @Override
    public String toString() {
        return "JPessoasDto{" + "id=" + id + ", nome=" + nome + ", idade=" + idade + 
                ", codigoTipoEndereco=" + codigoTipoEndereco + ", nomeEndereco=" + nomeEndereco + 
                ", cep=" + cep + ", numero=" + numero + ", telefones=" + telefones + '}';
    }
}
