package br.com.aprendizagem.demospringlibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aprendizagem.demospringlibrary.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}