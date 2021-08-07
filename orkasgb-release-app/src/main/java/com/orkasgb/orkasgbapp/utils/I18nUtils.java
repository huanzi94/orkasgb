package com.orkasgb.orkasgbapp.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class I18nUtils {

    public static MessageSource messageSource;

    public static String getMessage(String key) {
        return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }

    @Autowired
    public void localeResolver(MessageSource messageSource) {
        I18nUtils.messageSource = messageSource;
    }
}
