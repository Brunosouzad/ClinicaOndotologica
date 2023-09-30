package br.com.digitalhouse.Clinica.odontologica;

import br.com.digitalhouse.Clinica.odontologica.app.api.dto.request.CreateContatoRequest;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.request.CreateEnderecoRequest;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.request.clinica.CreateClinicaRequest;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.Contato;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.Endereco;
import com.github.javafaker.Faker;

import java.util.Locale;

public class Fixture {

    private static final Faker FAKER = new Faker(new Locale("pt", "BR"));

    public static class ClinicaFake {
        public static CreateClinicaRequest anyClinica() {
            CreateClinicaRequest clinica = new CreateClinicaRequest();

            CreateEnderecoRequest endereco = new CreateEnderecoRequest();
            endereco.setLagadouro(FAKER.address().streetAddress());
            endereco.setBairro(FAKER.address().country());
            endereco.setCep(FAKER.address().zipCode());
            endereco.setCidade(FAKER.address().city());
            endereco.setEstado(FAKER.address().state());

            clinica.setEndereco(endereco);




            CreateContatoRequest contato = new CreateContatoRequest();
            contato.setEmail(FAKER.internet().emailAddress());
            contato.setTelefone(FAKER.phoneNumber().cellPhone());
            clinica.setContato(contato);
            clinica.setNome(FAKER.name().fullName());
            clinica.setCnpj(FAKER.options().option("10.208.585/0001-93"));
            clinica.setDescricao(FAKER.lorem().sentence());
            clinica.setRazaoSocial(FAKER.lorem().characters(5, 50));

            return clinica;
        }







    }

}
