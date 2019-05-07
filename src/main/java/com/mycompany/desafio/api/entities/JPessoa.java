package com.mycompany.desafio.api.entities;

import com.mycompany.desafio.api.base.entity.JAbstractEntityClass;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = JPessoa.TABLE_NAME)
public class JPessoa extends JAbstractEntityClass<Long> {

    private static final long serialVersionUID = 1L;

    static final String TABLE_NAME = "pessoa";

    public static final int MAXLENGTH_FIELD_255 = 255;
    public static final int MAXLENGTH_FIELD_50 = 50;
    public static final int MAXLENGTH_FIELD_20 = 20;
    public static final int MAXLENGTH_FIELD_10 = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa", unique = true, nullable = false)
    private Long id;

    @NotNull(message = " O nome e obrigatorio.")
    @Column(name = "nome", length = MAXLENGTH_FIELD_255)
    private String nome;

    @NotNull(message = " A idade e obrigatoria.")
    @Column(name = "idade")
    private Integer idade;

    @NotNull(message = " O tipo endereco e obrigatorio")
    @Column(name = "codigo_tipo_endereco")
    private Integer codigoTipoEndereco;

    @NotNull(message = " O nome endereco e obrigatorio.")
    @Column(name = "nome_endereco", length = MAXLENGTH_FIELD_50)
    private String nomeEndereco;

    @NotNull(message = " O CEP e obrigatorio.")
    @Column(name = "cep", length = MAXLENGTH_FIELD_10)
    private String cep;

    @NotNull(message = " O numero e obrigatorio.")
    @Column(name = "numero", length = MAXLENGTH_FIELD_20)
    private String numero;
    
    @OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<JTelefone> telefones;

    public JPessoa() {
    }

    public JPessoa(Long id, String nome, Integer idade, Integer codigoTipoEndereco, String nomeEndereco, String cep, String numero) {
        super();
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.codigoTipoEndereco = codigoTipoEndereco;
        this.nomeEndereco = nomeEndereco;
        this.cep = cep;
        this.numero = numero;
    }

    public JPessoa(Long id, String nome, Integer idade, Integer codigoTipoEndereco, String nomeEndereco, String cep, String numero, List<JTelefone> telefones) {
        super();
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

    public List<JTelefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<JTelefone> telefones) {
        this.telefones = telefones;
    }

    @Override
    public String toString() {
        return "JPessoa{" + "id=" + id + ", nome=" + nome + ", idade=" + idade + 
                ", codigoTipoEndereco=" + codigoTipoEndereco + ", nomeEndereco=" + nomeEndereco + 
                ", cep=" + cep + ", numero=" + numero + ", telefones=" + telefones + '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        JPessoa other = (JPessoa) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }
}
