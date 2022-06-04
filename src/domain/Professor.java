package domain;

import exception.IdadeInvalidaException;
import auxiliar.Constante;

public class Professor extends Pessoa {
    @Override
    public void setIdade(int idade) throws IdadeInvalidaException {
        if (idade < Constante.MAIORIDADE) {
            throw new IdadeInvalidaException("O professor deve ser maior de idade.");
        }
        this.idade = idade;
    }

    @Override
    public String impressao() {
        StringBuilder sb = new StringBuilder();
        return sb.append("nome: " + nome + " | ")
                .append("idade: " + idade + " - ")
                .append("|PROFESSOR|\n")
                .toString();
    }
}
