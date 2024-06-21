package br.com.aprendizagem.demospringlibrary.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAutor(
    @JsonAlias("name") String Nome,
    @JsonAlias("birth_year") Integer AnoDeNascimento,
    @JsonAlias("death_year") Integer AnoDeFalecimento
) {
}
