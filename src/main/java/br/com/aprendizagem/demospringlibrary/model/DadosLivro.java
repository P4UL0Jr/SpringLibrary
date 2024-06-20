package br.com.aprendizagem.demospringlibrary.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro (@JsonAlias("title") String Titulo,
                         @JsonAlias("authors")String Autor,
                         @JsonAlias("languages")String Idioma,
                         @JsonAlias("download_count") Integer NumeroDeDownloads){
}
