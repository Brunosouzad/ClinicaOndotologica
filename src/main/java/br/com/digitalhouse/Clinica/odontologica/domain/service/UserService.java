package br.com.digitalhouse.Clinica.odontologica.domain.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();
}
