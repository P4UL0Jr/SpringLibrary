package br.com.aprendizagem.demospringlibrary;

import br.com.aprendizagem.demospringlibrary.model.DadosLivro;
import br.com.aprendizagem.demospringlibrary.service.ConsumoAPI;
import br.com.aprendizagem.demospringlibrary.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemospringlibraryApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemospringlibraryApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception{
		var consumoAPI = new ConsumoAPI();
		var json = consumoAPI.obterDados("https://gutendex.com/books/?search=dom+casmurro");
		var conversor = new ConverteDados();
		DadosLivro dadosLivro = conversor.obterDados(json, DadosLivro.class);
		System.out.println(dadosLivro);
	}

}
