package br.com.reddisData.Estudos;

import br.com.reddisData.Estudos.carro.Carro;
import br.com.reddisData.Estudos.carro.CarroRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EstudosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstudosApplication.class, args);
	}

}
