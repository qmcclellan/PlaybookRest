package com.rest.playbookrest.Config;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import com.rest.playbookrest.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import javax.sql.DataSource;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class JWTSecurityConfig {

    @Autowired
    UsersService usersService;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {

        return http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/Authenticate").permitAll()
                        .requestMatchers(HttpMethod.OPTIONS,"/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.
                        sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(
                        (oauth2) -> oauth2.jwt(withDefaults()))
                .httpBasic(
                        withDefaults())
                .headers(headers -> headers.frameOptions(frameOptionsConfig-> frameOptionsConfig.disable()))
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            UserDetailsService userDetailsService) {
        var authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        return new ProviderManager(authenticationProvider);
    }

    @Bean
    public UserDetailsService userDetailsService() {

        return usersService;
    }

    @Bean
    public JwtDecoder jwtDecoder(RSAKey rsaKey) throws JOSEException {

        return NimbusJwtDecoder
                .withPublicKey(rsaKey.toRSAPublicKey())
                .build();
    }

    @Bean
    public RSAKey rsaKey(KeyPair keyPair) {

        return new RSAKey.Builder((RSAPublicKey) keyPair.getPublic())
                .privateKey(keyPair().getPrivate())
                .keyID(UUID.randomUUID().toString())
                .build();
    }

    @Bean
    public KeyPair keyPair() {
        try {
            var keyPair = KeyPairGenerator.getInstance("RSA");

            keyPair.initialize(2048);

            return keyPair.generateKeyPair();

        } catch (Exception ex) {

            throw new RuntimeException(ex);
        }
    }

    @Bean
    public JWKSource<SecurityContext> jwkSource(RSAKey rsaKey) {

        var jwkSet = new JWKSet(rsaKey);

        return (jwkSelector, context) -> jwkSelector.select(jwkSet);
    }

    @Bean
    public JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource) {

        return new NimbusJwtEncoder(jwkSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        String idForEncode = "bcrypt";
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put(idForEncode, new BCryptPasswordEncoder());

        return  new DelegatingPasswordEncoder(idForEncode, encoders);
    }

}

//"token": "eyJraWQiOiJjMmRhN2QxMS0zYmVhLTQxOWQtOTRiYy01YzAxMjFlOWVhYTgiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoiUXVlMTEwMSIsImV4cCI6MTcxMjAwMTMxNCwiaWF0IjoxNzExOTk1OTE0LCJzY29wZSI6IltSb2xle2lkPTEsIG5hbWU9J1JPTEVfQURNSU59XSJ9.rlQzm6uI_v79rBPj-9MRZq9maSd6nRapZ1ZxfJvoYd58lHNBkyLB_o-YYx5Wdn5NbI-jKwQyyxNbQso4EzZHB2ZHlDKtIrZeny3wnKnR8WoEuRS1D1e7Os1iiP3hG1-QWEMvOsFWxNyvLI1TbkD7XJXiluFZz23u60CgDIxzMiVjrhHk9tnqgmDsk2J_OJjBNiVfrMX6m46mVxjFS8rHO6WisgywgyG_AcRfc_JKzN6gqH4LZ2iTa4yfLkYIN14pGiXes4D_naJfUTvUsDyUydlhnPzkvPfP3k--u0ugikmJ-d1AJ-2OJcHm5mD3HKNJMh0gfRYBo3kuehwVoFexuA"
