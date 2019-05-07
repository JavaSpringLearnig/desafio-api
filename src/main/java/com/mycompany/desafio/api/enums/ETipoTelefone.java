package com.mycompany.desafio.api.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ETipoTelefone {

    CELULAR(1, "Celular"),
    FIXO(2, "Fixo"),
    RADIO(3, "Rádio");
    
    private int codigo;
    private String descricao;

    private ETipoTelefone(int cod, String descricao) {
        this.codigo = cod;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static ETipoTelefone toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (ETipoTelefone x : ETipoTelefone.values()) {
            if (cod.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Código Inválido: " + cod);
    }
}
