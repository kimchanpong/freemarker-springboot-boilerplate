package com.ckdpharm.homepage.common.config;

import net.rakugakibox.util.YamlResourceBundle;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class AppConfig {
    @Bean
    MessageSource messageSource() {
        YamlMessageSource ms = new YamlMessageSource();
        ms.setBasenames(
                "config/message/i18n/messages",
                "config/message/i18n/validation"
        );
        ms.setAlwaysUseMessageFormat(true);
        ms.setUseCodeAsDefaultMessage(true);
        ms.setFallbackToSystemLocale(true);
        return ms;
    }

    @Bean
    MessageSourceAccessor message() {
        return new MessageSourceAccessor(messageSource());
    }
}

class YamlMessageSource extends ResourceBundleMessageSource {
    @Override
    protected ResourceBundle doGetBundle(String basename, Locale locale) throws MissingResourceException {
        return ResourceBundle.getBundle(basename, locale, YamlResourceBundle.Control.INSTANCE);
    }
}