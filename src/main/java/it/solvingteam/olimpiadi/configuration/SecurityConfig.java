package it.solvingteam.olimpiadi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import it.solvingteam.olimpiadi.service.UtenteService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UtenteService utenteDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
//                    .antMatchers("/auth/signup")                    .permitAll()
                    .anyRequest()                    .authenticated()
                .and()
                .formLogin()
                    .loginPage("/auth/signin")
                    .loginProcessingUrl("/auth/signin")
                    .failureUrl("/auth/signin?loginError")
                    .defaultSuccessUrl("/")
                .permitAll();
   
        http
        .logout(logout -> logout
          .addLogoutHandler(new SecurityContextLogoutHandler()).logoutSuccessUrl("/"));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(utenteDetailsService)
                .passwordEncoder(passwordEncoder());
    }


}
