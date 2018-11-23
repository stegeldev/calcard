package br.com.calcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import br.com.calcard.configuration.JpaConfiguration;


@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"br.com.calcard"})
public class PropostaDeCredito {

	public static void main(String[] args) {
		SpringApplication.run(PropostaDeCredito.class, args);
	}
}
