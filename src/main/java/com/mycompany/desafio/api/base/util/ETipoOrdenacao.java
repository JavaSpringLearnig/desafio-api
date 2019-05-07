package com.mycompany.desafio.api.base.util;

public enum ETipoOrdenacao {

    ASC("ASC"),
    DESC("DESC");

    private final String directionCode;

    private ETipoOrdenacao(String direction) {
        this.directionCode = direction;
    }

    public String getDirectionCode() {
        return this.directionCode;
    }
}
