package com.mycompany.desafio.api.entities;

import com.mycompany.desafio.api.base.entity.JAbstractEntityClass;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = JTelefone.TABLE_NAME)
public class JTelefone extends JAbstractEntityClass<Long> {

    private static final long serialVersionUID = 1L;

    static final String TABLE_NAME = "telefone";

    public static final int MAXLENGTH_FIELD_10 = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefone", unique = true, nullable = false)
    private Long id;

    @NotNull(message = " O tipo endereco e obrigatorio")
    @Column(name = "codigo_tipo_telefone")
    private Integer codigoTipoTelefone;

    @NotNull(message = " O ddi e obrigatorio.")
    @Column(name = "ddi", length = MAXLENGTH_FIELD_10)
    private String ddi;

    @NotNull(message = " O ddd e obrigatorio.")
    @Column(name = "ddd", length = MAXLENGTH_FIELD_10)
    private String ddd;

    @NotNull(message = " O numero telefone e obrigatorio.")
    @Column(name = "numero_telefone", length = MAXLENGTH_FIELD_10)
    private String numeroTelefone;

    @NotNull(message = " Pessoa obrigatorio.")
    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(name = "pessoa_fkey"))
    private JPessoa pessoa;

    public JTelefone() {
    }

    public JTelefone(Long id, Integer codigoTipoTelefone, String ddi, String ddd, String numeroTelefone, JPessoa pessoa) {
        super();
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

    public JPessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(JPessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "JTelefone{" + "id=" + id + ", codigoTipoTelefone=" + codigoTipoTelefone
                + ", ddi=" + ddi + ", ddd=" + ddd + ", numeroTelefone=" + numeroTelefone
                + ", pessoa=" + pessoa + '}';
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
        JTelefone other = (JTelefone) obj;
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
