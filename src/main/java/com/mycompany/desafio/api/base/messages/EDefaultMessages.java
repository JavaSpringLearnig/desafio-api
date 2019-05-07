package com.mycompany.desafio.api.base.messages;

/**
 * Enum responsavel por armazenar as mensagens padroes do sistema
 */
public enum EDefaultMessages {

    ID_NOT_FIND("id_not_found"),
            
    UNIQUE_EXCEPTION("unique_exception");

    private String keyValue;

    /**
     * Construtor da Classe
     *
     * @param name Nome da Chave
     */
    private EDefaultMessages(final String name) {
        this.keyValue = name;
    }

    @Override
    public String toString() {
        return this.keyValue;
    }
}
