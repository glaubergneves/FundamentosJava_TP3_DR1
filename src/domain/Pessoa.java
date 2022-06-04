package domain;

import exception.IdadeInvalidaException;

public abstract class Pessoa {
    protected String nome;
    protected int idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = formatarNome(nome);
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) throws IdadeInvalidaException {
        this.idade = idade;
    }

    public abstract String impressao();

    private String formatarNome(String nome) {
        if (nome.equals("")) {
            return nome;
        }
        String letra = nome.substring(0, 1).toUpperCase();
        String restoNome = nome.substring(1).toLowerCase();
        return letra + restoNome;
    }
}
