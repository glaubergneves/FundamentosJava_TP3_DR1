package domain;

import auxiliar.Constante;
import exception.AvaliacaoInvalidoException;
import java.lang.StringBuilder;

public class Aluno extends Pessoa {
    private float avaliacao1;
    private float avaliacao2;

    public float getAvaliacao1() {
        return avaliacao1;
    }

    public void setAvaliacao1(float avaliacao1) throws AvaliacaoInvalidoException {
        if (avaliacao1 < Constante.NOTAMINIMA) {
            throw new AvaliacaoInvalidoException("A nota da avaliação deve ser maior que 0.");
        }
        if (avaliacao1 > Constante.NOTAMAXIMA) {
            throw new AvaliacaoInvalidoException("A nota da avaliação deve ser menor que 10.");
        }
        this.avaliacao1 = avaliacao1;
    }

    public float getAvaliacao2() {
        return avaliacao2;
    }

    public void setAvaliacao2(float avaliacao2) throws AvaliacaoInvalidoException {
        if (avaliacao2 < Constante.NOTAMINIMA) {
            throw new AvaliacaoInvalidoException("A nota da avaliação deve ser maior que 0.");
        }
        if (avaliacao2 > Constante.NOTAMAXIMA) {
            throw new AvaliacaoInvalidoException("A nota da avaliação deve ser menor que 10.");
        }
        this.avaliacao2 = avaliacao2;
    }

    private float calcularMedia() {
        return (this.avaliacao1 + this.avaliacao2) / 2;
    }

    @Override
    public String impressao() {
        StringBuilder sb = new StringBuilder();
        return sb.append("nome: " + nome + " | ")
                .append("idade: " + idade + " | ")
                .append(consultarSituacao())
                .append(" - |ALUNO|\n")
                .toString();
    }

    public String consultarSituacao() {
        StringBuilder sb = new StringBuilder();
        sb.append("Situação: ");
        if (calcularMedia() > 6) {
            sb.append("Aprovado!");
        } else {
            sb.append("Reprovado!");
        }
        return sb.toString();
    }
}
