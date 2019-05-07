package com.mycompany.desafio.api.base.exception;

import com.mycompany.desafio.api.base.messages.EDefaultMessages;
import java.io.Serializable;

/**
 * Classe responsavel por considerar excecoes relacioadas a regra de negaciacao
 */
public class ServiceException extends Exception implements Serializable {

    private static final long serialVersionUID = -963234046829903256L;

    private final transient Object[] messagesArgs;

    /**
     * Construtor da Classe
     *
     * @param message Message que queremos enviar
     * @param messagesArgs Argumentos das mensagem (Parametros)
     */
    public ServiceException(final EDefaultMessages message, final Object... messagesArgs) {
        super(message.toString());
        this.messagesArgs = messagesArgs;
    }

    /**
     * Construtor da Classe
     *
     * @param message Message que queremos enviar
     * @param messagesArgs Argumentos das mensagem (ParÃ¢metros)
     */
    public ServiceException(final String message, final Object... messagesArgs) {
        super(message);
        this.messagesArgs = messagesArgs;
    }

    /**
     * Retorna o campo messagesArgs
     *
     * @return campo messagesArgs
     */
    public final Object[] getMessagesArgs() {
        return this.messagesArgs;
    }
}
