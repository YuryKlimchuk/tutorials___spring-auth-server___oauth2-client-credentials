package com.hydroyura.tutorials.springauthserver.catalog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;
import java.util.List;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain outhChain(HttpSecurity http) throws Exception {
        http.oauth2ResourceServer(o -> o
                .jwt(c -> c
                        //.jwtAuthenticationConverter(new CustomConverter())
                        .jwkSetUri("http://localhost:8080/oauth2/jwks"))
        );
        return http.build();
    }

    private class CustomConverter implements Converter<Jwt, JwtAuthenticationToken> {

        @Override
        public JwtAuthenticationToken convert(Jwt source) {

            int a = 1;

            Collection<String> scopes = List.class.cast(source.getClaim("scope")).stream().map(scope -> "SCOPE_" + scope).toList();



            JwtAuthenticationToken f = new JwtAuthenticationToken(source);

            return f;
        }
    }

}
