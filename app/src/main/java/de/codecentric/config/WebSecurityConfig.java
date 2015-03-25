package de.codecentric.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import de.codecentric.auth.SimpleSocialUsersDetailService;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        
        
        http
        .formLogin()
        .loginPage("/login")
        .loginProcessingUrl("/login/authenticate")
        .failureUrl("/login?param.error=bad_credentials")
        .permitAll()
        .and()
        .authorizeRequests()
        .antMatchers("/venueMap", "/currentSessions", "/img/**").permitAll()
        .antMatchers("/**").authenticated()
        .and()
        .rememberMe()
        .and()
        .apply(new SpringSocialConfigurer());
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	 auth.
         jdbcAuthentication()
         .dataSource(dataSource)
         .withDefaultSchema();
    }
    
    @Bean
    public SocialUserDetailsService socialUsersDetailService() {
        return new SimpleSocialUsersDetailService(userDetailsService());
    }
    
}
