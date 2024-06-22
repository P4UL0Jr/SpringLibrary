package br.com.aprendizagem.demospringlibrary.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aprendizagem.demospringlibrary.model.Autor;
import br.com.aprendizagem.demospringlibrary.repository.AutorRepository;
import br.com.aprendizagem.demospringlibrary.repository.LivroRepository;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LivroRepository livroRepository;

    public List<Autor> listarAutoresETitulos() {
        return autorRepository.findAll();
    }

    public List<Autor> listarAutoresPorAno(int ano) {
        List<Autor> autoresPorAno = new ArrayList<>();

        for (Autor autor : autorRepository.findAll()) {
            if (autor.getAnoDeNascimento() <= ano && (autor.getAnoDeFalecimento() == null || autor.getAnoDeFalecimento() >= ano)) {
                autoresPorAno.add(autor);
            }
        }

        return autoresPorAno;
    }
}