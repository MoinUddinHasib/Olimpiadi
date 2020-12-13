package it.solvingteam.olimpiadi.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import it.solvingteam.olimpiadi.Util;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
/*
//    @Autowired
//    UserService userDetailsService;

//    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/auth/signup")                    .permitAll()
                    .anyRequest()                    .authenticated()
                .and()
                .formLogin()
                    .loginPage("/auth/signin")
                    .loginProcessingUrl("/auth/signin")
                    .failureUrl("/auth/signin?loginError")
                    .defaultSuccessUrl("/")
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	Util.stampa(this.toString());
//        auth
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder());
    }
*/

}
