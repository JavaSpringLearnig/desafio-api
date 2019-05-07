package com.mycompany.desafio.api.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ETipoEndereco {

    RUA(1, "Rua"),
    AVENIDA(2, "Avenida"),
    CONDOMINIO(3, "Condomínio"),
    RODOVIA(4, "Rodovia");

    private int codigo;
    private String descricao;

    private ETipoEndereco(int cod, String descricao) {
        this.codigo = cod;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static ETipoEndereco toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (ETipoEndereco x : ETipoEndereco.values()) {
            if (cod.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Código Inválido: " + cod);
    }
}
