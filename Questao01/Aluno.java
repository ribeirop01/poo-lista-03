package Questao01;

public class Aluno {
    private static final int MAX_NOTAS = 4;
    private static final double MEDIA_APROVACAO = 7.0;

    private String nome;
    private String matricula;
    private double[] notas = new double[MAX_NOTAS];
    private int quantidadeNotas = 0;

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    // Cadastra uma nota (0 a 10). Retorna false se for inválida ou se já houver 4 notas.
    public boolean cadastrarNota(double nota) {
        if (quantidadeNotas >= MAX_NOTAS || nota < 0 || nota > 10) {
            return false;
        }
        notas[quantidadeNotas++] = nota;
        return true;
    }

    public double calcularMedia() {
        if (quantidadeNotas == 0) {
            return 0.0;
        }
        double soma = 0;
        for (int i = 0; i < quantidadeNotas; i++) {
            soma += notas[i];
        }
        return soma / quantidadeNotas;
    }

    public boolean isAprovado() {
        return calcularMedia() >= MEDIA_APROVACAO;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return String.format("%s (mat. %s) - média: %.2f", nome, matricula, calcularMedia());
    }
}