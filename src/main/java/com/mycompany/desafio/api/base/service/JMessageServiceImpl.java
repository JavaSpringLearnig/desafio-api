package com.mycompany.desafio.api.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class JMessageServiceImpl implements IMessageService {

    @Autowired
    private MessageSource messageSource;

    @Override
    public String getMessage(String id, Object... args) {
        return this.messageSource.getMessage(id, args, LocaleContextHolder.getLocale());
    }
}
