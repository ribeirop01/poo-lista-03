package Questao03;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quantos números de Fibonacci deseja exibir? ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Informe um valor maior que zero.");
        } else {
            System.out.println(Arrays.toString(gerarFibonacci(n)));
        }
        scanner.close();
    }

    public static long[] gerarFibonacci(int n) {
        long[] serie = new long[n];
        for (int i = 0; i < n; i++) {
            serie[i] = (i < 2) ? i : serie[i - 1] + serie[i - 2];
        }
        return serie;
    }
}