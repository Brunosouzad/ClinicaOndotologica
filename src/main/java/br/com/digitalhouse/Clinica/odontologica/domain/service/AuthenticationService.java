package br.com.digitalhouse.Clinica.odontologica.domain.service;

import br.com.digitalhouse.Clinica.odontologica.domain.entity.SignIn;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.SignUp;

public interface AuthenticationService {
    String signIn(SignIn request);

    String signUp(SignUp request);
}
