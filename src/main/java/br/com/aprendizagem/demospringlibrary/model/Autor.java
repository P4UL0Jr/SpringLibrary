package br.com.aprendizagem.demospringlibrary.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "ano_nascimento")
    private Integer anoDeNascimento;

    @Column(name = "ano_falecimento")
    private Integer anoDeFalecimento;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    public Autor() {}

    public Autor(DadosAutor dadosAutor, Livro livro) {
        this.nome = dadosAutor.Nome();
        this.anoDeNascimento = dadosAutor.AnoDeNascimento();
        this.anoDeFalecimento = dadosAutor.AnoDeFalecimento();
        this.livro = livro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoDeNascimento() {
        return anoDeNascimento;
    }

    public void setAnoDeNascimento(Integer anoDeNascimento) {
        this.anoDeNascimento = anoDeNascimento;
    }

    public Integer getAnoDeFalecimento() {
        return anoDeFalecimento;
    }

    public void setAnoDeFalecimento(Integer anoDeFalecimento) {
        this.anoDeFalecimento = anoDeFalecimento;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    
}