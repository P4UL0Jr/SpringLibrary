package br.com.aprendizagem.demospringlibrary;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.aprendizagem.demospringlibrary.model.Autor;
import br.com.aprendizagem.demospringlibrary.model.Livro;
import br.com.aprendizagem.demospringlibrary.service.AutorService;
import br.com.aprendizagem.demospringlibrary.service.LivroService;

@SpringBootApplication
public class SpringlibraryApplication implements CommandLineRunner {

    @Autowired
    private LivroService livroService;

    @Autowired
    private AutorService autorService;

    public static void main(String[] args) {
        SpringApplication.run(SpringlibraryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Buscar livro da API e salvar no banco de dados");
            System.out.println("2 - Listar livros registrados");
            System.out.println("3 - Listar autores registrados e seus livros");
            System.out.println("4 - Listar autores por ano");
            System.out.println("5 - Listar livros por idioma");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opcao) {
                case 1:
                    System.out.print("Digite a URL da API: ");
                    String urlApi = scanner.nextLine();
                    livroService.buscarESalvarLivro(urlApi);
                    System.out.println("Livros buscados e salvos com sucesso!");
                    break;
                case 2:
                    List<Livro> livros = livroService.listarLivros();
                    livros.forEach(System.out::println);
                    break;
                case 3:
                    List<Autor> autores = autorService.listarAutoresETitulos();
                    autores.forEach(autor -> {
                        System.out.println("Autor: " + autor.getNome());
                        System.out.println("Livros:");
                        System.out.println("  - " + autor.getLivro().getTitulo());
                    });
                    break;
                case 4:
                    System.out.print("Digite o ano: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    List<Autor> autoresPorAno = autorService.listarAutoresPorAno(ano);
                    autoresPorAno.forEach(autor -> System.out.println("Autor: " + autor.getNome()));
                    break;
                case 5:
                    System.out.print("Digite o idioma: ");
                    String idioma = scanner.nextLine();
                    List<Livro> livrosPorIdioma = livroService.listarLivrosPorIdioma(idioma);
                    livrosPorIdioma.forEach(livro -> System.out.println("Livro: " + livro.getTitulo()));
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
	}
}
/*
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.aprendizagem.demospringlibrary.model.DadosLivro;
import br.com.aprendizagem.demospringlibrary.model.Livro;
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
		Livro primeiroLivro = new Livro(livro.get(0));
		System.out.println("\nlivro ------- "+livro);
		System.out.println("\nprimeiro livro ---------------------"+primeiroLivro);

		//System.out.println(resultados);
	}

}
*/