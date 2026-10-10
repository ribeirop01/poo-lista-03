package Questao01;

public class Turma {
    private Aluno[] alunos;
    private int quantidadeAlunos = 0;

    public Turma(int capacidade) {
        this.alunos = new Aluno[capacidade];
    }

    public boolean adicionarAluno(Aluno aluno) {
        if (aluno == null || quantidadeAlunos >= alunos.length) {
            return false;
        }
        alunos[quantidadeAlunos++] = aluno;
        return true;
    }

    public void listarAprovados() {
        System.out.println("=== Aprovados ===");
        for (int i = 0; i < quantidadeAlunos; i++) {
            if (alunos[i].isAprovado()) {
                System.out.println(alunos[i]);
            }
        }
    }

    public void listarReprovados() {
        System.out.println("=== Reprovados ===");
        for (int i = 0; i < quantidadeAlunos; i++) {
            if (!alunos[i].isAprovado()) {
                System.out.println(alunos[i]);
            }
        }
    }
}
