package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import domain.Aluno;
import domain.Pessoa;
import domain.Professor;
import exception.AvaliacaoInvalidoException;
import exception.IdadeInvalidaException;

public class Tp3 {
    private static List<Pessoa> lista;

    public static void imprimir() {
        for (Pessoa pessoa : lista) {
            System.out.print(pessoa.impressao());
        }
    }

    public static void main(String[] args) {
        lista = new ArrayList<Pessoa>();
        Scanner sc = new Scanner(System.in);
        String opcao;
        do {
            System.out.println("[1] Cadastrar aluno.");
            System.out.println("[2] Cadastrar professor.");
            System.out.println("[3] Consultar situação de um docente/discente.");
            System.out.println("[4] Exibir todas as pessoas cadastradas.");
            System.out.println("[5] Sair.");
            System.out.print("\nInforme a opcao desejada: ");
            opcao = sc.next();

            switch (opcao) {
                case "1":
                    try {
                        Aluno aluno = new Aluno();
                        System.out.print("Informe seu nome: ");
                        aluno.setNome(sc.next());
                        System.out.print("Informe a idade: ");
                        aluno.setIdade(sc.nextInt());
                        System.out.print("Informe a nota da AV1: ");
                        aluno.setAvaliacao1(sc.nextFloat());
                        System.out.print("Informe a nota da AV2: ");
                        aluno.setAvaliacao2(sc.nextFloat());
                        lista.add(aluno);
                        System.out.println(aluno.impressao());
                    } catch (AvaliacaoInvalidoException | IdadeInvalidaException e) {
                        System.out.println("[ERRO] " + e.getMessage());
                    }
                    break;
                case "2":
                    try {
                        Professor professor = new Professor();
                        System.out.print("Informe seu nome: ");
                        professor.setNome(sc.next());
                        System.out.print("Informe a idade: ");
                        professor.setIdade(sc.nextInt());
                        lista.add(professor);
                        System.out.println(professor.impressao());
                    } catch (IdadeInvalidaException e) {
                        System.out.println("[ERRO] " + e.getMessage());
                    }
                    break;
                case "3":
                    System.out.print("Informe codigo de um docente/discente: ");
                    int codigo = sc.nextInt();
                    try {
                        Pessoa pessoa = lista.get(codigo);
                        System.out.println(pessoa.impressao());
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("[ERRO] Codigo invalido!\n");
                    }
                    break;
                case "4":
                    imprimir();
                    break;
            }
        } while (!"5".equalsIgnoreCase(opcao));

        sc.close();
    }
}