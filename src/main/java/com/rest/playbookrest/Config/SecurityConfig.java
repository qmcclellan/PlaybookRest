package com.rest.playbookrest.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    @Qualifier("securityDataSource")
    private DataSource securityDataSource;

    @Autowired
    private CustomAuthentication authProvider;

    @Autowired
    private SuccessHandler SuccessHandler;

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(authProvider);
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((auth) -> {

                            try {
                                auth

                                        .requestMatchers("/Admin/**").hasRole("ADMIN")
                                        .requestMatchers("/Business/**").hasAnyRole("ADMIN","CUSTOMER","EMPLOYEE")
                                        .requestMatchers("/Employee/**").hasAnyRole("ADMIN","EMPLOYEE")
                                        .requestMatchers("/Customer/**").hasAnyRole("ADMIN", "CUSTOMER")
                                        .requestMatchers( "/User/**").hasAnyRole("ADMIN","CUSTOMER","EMPLOYEE")
                                        .requestMatchers("/**","/Welcome/**", "/Login/**").permitAll();
                            } catch (Exception e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }

                ).formLogin(form -> form
                        .loginPage("/Login/SignIn")
                        .loginProcessingUrl("/authenticateTheUser")
                        .successHandler(SuccessHandler)
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutSuccessUrl("/Login/LoginPage")
                        .permitAll())
                .exceptionHandling((exceptionHandling) -> exceptionHandling
                        .accessDeniedPage("/access-denied")
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {//needs to be static to avoid circular reference exception

        String idForEncode = "bcrypt";
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put(idForEncode, new BCryptPasswordEncoder());
        //encoders.put("noop", NoOpPasswordEncoder.getInstance());
        // encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        //encoders.put("scrypt", new SCryptPasswordEncoder());
        //encoders.put("sha256", new StandardPasswordEncoder());

        PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder(idForEncode, encoders);

        return passwordEncoder;
    }

}
