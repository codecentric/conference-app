package org.cc.thot.config;

import java.util.Locale;

import org.cc.thot.web.validate.impl.Time24HoursValidator;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class ApplicationWebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
	super.addViewControllers(registry);
	registry.addViewController("/").setViewName("redirect:/home");
    }
    
    @Bean
    public ObjectMapper objectMapper() {
	return new ObjectMapper();
    }
    
    @Bean
    public Time24HoursValidator time24HoursValidator() {
	return new Time24HoursValidator();
    } 
    
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }
    
    
}