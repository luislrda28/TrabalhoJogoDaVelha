package JogoDaVelha;

import java.util.Scanner;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        char[] tabuleiro = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int jogadorAtual = random.nextInt(2);
        System.out.println(jogadorAtual == 0 ? "Jogador 1 começa!" : "Computador começa!");

        Tabuleiro.mostrar(tabuleiro);

        System.out.print("Jogador 1, escolha seu símbolo (X/O): ");
        char simbolo1 = scanner.next().toUpperCase().charAt(0);
        char simbolo2 = (simbolo1 == 'X') ? 'O' : 'X';

        boolean jogoAtivo = true;
        int jogadas = 0;

        while (jogoAtivo && jogadas < 9) {
            if (jogadorAtual == 0) {
                jogadas += Utils.jogadaHumano(tabuleiro, scanner, simbolo1);
                Tabuleiro.mostrar(tabuleiro);
                if (Utils.verificarVencedor(tabuleiro, simbolo1)) {
                    System.out.println("Jogador 1 venceu!");
                    break;
                }
            } else {
                jogadas += Utils.jogadaComputador(tabuleiro, random, simbolo2);
                Tabuleiro.mostrar(tabuleiro);
                if (Utils.verificarVencedor(tabuleiro, simbolo2)) {
                    System.out.println("Jogador 2 (computador) venceu!");
                    break;
                }
            }

            if (jogadas == 9) break;
            jogadorAtual = 1 - jogadorAtual;
        }

        if (!Utils.verificarVencedor(tabuleiro, simbolo1) && !Utils.verificarVencedor(tabuleiro, simbolo2)) {
            System.out.println("Empate!");
        }
    }
}