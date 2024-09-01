package com.cntmgr.contactmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import jakarta.servlet.Filter;

@EnableWebSecurity
@Configuration
public class MyConfig{
    @Bean
    public UserDetailsService getUserDetailsService(){
        return new UserDetailServiceImplementation() ;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(this.getUserDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(this.passwordEncoder());
        return daoAuthenticationProvider;
    }


    @Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
        return http
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/user/**").hasRole("USER")
                                .requestMatchers("/**").permitAll()
                )
                // .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // // .oauth2ResourceServer(spec -> spec.jwt(Customizer.withDefaults()))
                .httpBasic(Customizer.withDefaults())
                .formLogin(login -> 
                login.loginPage("/signin")
                .loginProcessingUrl("/dologin")
                .defaultSuccessUrl("/user/index"))
                // .failureUrl("/failedlogin"))
                .csrf(csrf -> csrf.disable())
                .build();
		
	}

}
