package br.com.aprendizagem.demospringlibrary.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro ( @JsonAlias("title") String Titulo,
                            @JsonAlias("authors") List<DadosAutor> Autores,
                            @JsonAlias("languages") List<String> Idioma,
                            @JsonAlias("download_count") Integer NumeroDeDownloads){
}
