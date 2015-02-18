package org.cc.thot;

import org.cc.thot.config.ApplicationWebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan({"org.cc.thot.web.controller", "org.cc.thot.dao.impl"})
@Import(ApplicationWebConfiguration.class)
public class ThotApplication extends SpringBootServletInitializer {
    
    public static void main(String[] args) {
	SpringApplication.run(ThotApplication.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	return application.sources(ThotApplication.class);
    }

}
