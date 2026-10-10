package Questao02;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final int QTD_NUMEROS = 6;
    private static final int MIN = 1;
    private static final int MAX = 60;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[QTD_NUMEROS];
        int total = 0;

        while (total < QTD_NUMEROS) {
            System.out.printf("Digite o %dº número (%d a %d): ", total + 1, MIN, MAX);
            int numero;
            try {
                numero = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.next(); // descarta o valor inválido
                continue;
            }

            if (numero < MIN || numero > MAX) {
                System.out.println("Número fora do intervalo permitido.");
            } else if (contem(numeros, total, numero)) {
                System.out.println("Número já informado. Escolha outro.");
            } else {
                numeros[total++] = numero;
            }
        }

        Arrays.sort(numeros);
        System.out.println("Números em ordem crescente: " + Arrays.toString(numeros));
        scanner.close();
    }

    private static boolean contem(int[] array, int tamanho, int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (array[i] == valor) {
                return true;
            }
        }
        return false;
    }
}