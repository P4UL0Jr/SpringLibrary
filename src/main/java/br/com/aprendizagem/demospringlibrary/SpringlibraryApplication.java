package br.com.aprendizagem.demospringlibrary;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.aprendizagem.demospringlibrary.model.DadosLivro;
import br.com.aprendizagem.demospringlibrary.model.Resultados;
import br.com.aprendizagem.demospringlibrary.service.ConsumoAPI;
import br.com.aprendizagem.demospringlibrary.service.ConverteDados;

@SpringBootApplication
public class SpringlibraryApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringlibraryApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception{
		//Pricipal menu = new Pricipal();
		//menu.menu();
		var consumoAPI = new ConsumoAPI();
		var json = consumoAPI.obterDados("https://gutendex.com/books/?search=dom+casmurro");
		System.out.println("\n --------------- \n"+json+"\n--------------------\n");
		ConverteDados converteDados = new ConverteDados();
		Resultados resultados = converteDados.obterDados(json, Resultados.class);
		
		List<DadosLivro> livro = resultados.livros();
		System.out.println(livro);

		//System.out.println(resultados);
	}

}
