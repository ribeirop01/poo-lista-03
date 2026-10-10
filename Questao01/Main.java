package Questao01;

public class Main {
    public static void main(String[] args) {
        Aluno a1 = new Aluno("Ana", "2024001");
        Aluno a2 = new Aluno("Bruno", "2024002");
        Aluno a3 = new Aluno("Carla", "2024003");

        double[] notasAna = {8.0, 7.5, 9.0, 6.5};
        double[] notasBruno = {5.0, 6.0, 4.5, 7.0};
        double[] notasCarla = {7.0, 7.0, 7.0, 7.0};

        for (double n : notasAna) a1.cadastrarNota(n);
        for (double n : notasBruno) a2.cadastrarNota(n);
        for (double n : notasCarla) a3.cadastrarNota(n);

        // Tentativa de cadastrar uma 5ª nota (deve ser recusada)
        System.out.println("5ª nota aceita? " + a1.cadastrarNota(10));

        Turma turma = new Turma(30);
        turma.adicionarAluno(a1);
        turma.adicionarAluno(a2);
        turma.adicionarAluno(a3);

        turma.listarAprovados();
        turma.listarReprovados();
    }
}