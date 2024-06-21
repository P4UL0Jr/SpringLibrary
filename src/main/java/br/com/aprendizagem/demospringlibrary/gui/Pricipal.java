package br.com.aprendizagem.demospringlibrary.gui;

import java.util.Scanner;

import br.com.aprendizagem.demospringlibrary.model.DadosLivro;
import br.com.aprendizagem.demospringlibrary.service.ConsumoAPI;
import br.com.aprendizagem.demospringlibrary.service.ConverteDados;

public class Pricipal {
    private Scanner input = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://gutendex.com/books/?search=";


    public void menu() {

        String menu = """
                1 - Buscar livro
                2 - Listar livros registrados
                3 - Listar autores registrados
                4 - Listar autores por ano
                5 - Listar livros por idioma
                
                0 - sair
                """;

        System.out.println(menu);

        try{
            int opcao = input.nextInt();
            input.nextLine();
            switch (opcao){
                case 1:
                buscarLivroWeb();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Escolha inválida");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void buscarLivroWeb(){
        DadosLivro dados = getDados();
        System.out.println(dados);
    }

    private DadosLivro getDados() {
        System.out.println("Qual o livro que você procura?");
        String nomeLivro = input.nextLine();
        String json =consumoAPI.obterDados(ENDERECO+nomeLivro.replace(" ", "+").trim());
        System.out.println(json);
        DadosLivro dadosLivro = conversor.obterDados(json, DadosLivro.class);
        return dadosLivro;
    }



}
