package br.com.aprendizagem.demospringlibrary.interfaces;

public interface IConverteDados {
    public abstract <T> T obterDados(String json, Class<T> classe);
}
