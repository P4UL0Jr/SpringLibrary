package br.com.aprendizagem.demospringlibrary.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public record Resultados(@JsonProperty("results")List<DadosLivro> livros) {
    
}
