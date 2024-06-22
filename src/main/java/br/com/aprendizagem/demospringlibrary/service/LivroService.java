package br.com.aprendizagem.demospringlibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aprendizagem.demospringlibrary.model.DadosLivro;
import br.com.aprendizagem.demospringlibrary.model.Livro;
import br.com.aprendizagem.demospringlibrary.model.Resultados;
import br.com.aprendizagem.demospringlibrary.repository.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private ConsumoAPI consumoAPI;

    @Autowired
    private ConverteDados converteDados;

    public void buscarESalvarLivro(String urlApi) {
        String json = consumoAPI.obterDados(urlApi); // Supondo que você tenha um método para consumir a API
        Resultados resultados = converteDados.obterDados(json, Resultados.class);

        for (DadosLivro dadosLivro : resultados.livros()) {
            Livro livro = new Livro(dadosLivro);
            livroRepository.save(livro);
        }
    }

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public List<Livro> listarLivrosPorIdioma(String idioma) {
        return livroRepository.findByIdioma(idioma);
    }
}