package JogoDaVelha;

import java.util.Scanner;
import java.util.Random;

public class Utils {
    public static boolean verificarVencedor(char[] t, char s) {
        return (t[0] == s && t[1] == s && t[2] == s) ||
               (t[3] == s && t[4] == s && t[5] == s) ||
               (t[6] == s && t[7] == s && t[8] == s) ||
               (t[0] == s && t[3] == s && t[6] == s) ||
               (t[1] == s && t[4] == s && t[7] == s) ||
               (t[2] == s && t[5] == s && t[8] == s) ||
               (t[0] == s && t[4] == s && t[8] == s) ||
               (t[2] == s && t[4] == s && t[6] == s);
    }

    public static int jogadaHumano(char[] tabuleiro, Scanner scanner, char simbolo) {
        int posicao;
        while (true) {
            System.out.print("Jogador 1, escolha uma posição (1-9): ");
            posicao = scanner.nextInt() - 1;
            if (posicao >= 0 && posicao < 9 && tabuleiro[posicao] == ' ') {
                tabuleiro[posicao] = simbolo;
                return 1;
            } else {
                System.out.println("Posição inválida. Tente novamente.");
            }
        }
    }

    public static int jogadaComputador(char[] tabuleiro, Random random, char simbolo) {
        int posicao;
        do {
            posicao = random.nextInt(9);
        } while (tabuleiro[posicao] != ' ');
        tabuleiro[posicao] = simbolo;
        System.out.println("Jogador 2 (computador) jogou na posição " + (posicao + 1));
        return 1;
    }
}