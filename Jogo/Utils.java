import java.util.Scanner;
import java.util.Random;

public class Utils {
    public static boolean verificarVencedor(char[] tabuleiro, char s) {
        if ((tabuleiro[0] == s && tabuleiro[1] == s && tabuleiro[2] == s) ||
            (tabuleiro[3] == s && tabuleiro[4] == s && tabuleiro[5] == s) ||
            (tabuleiro[6] == s && tabuleiro[7] == s && tabuleiro[8] == s) ||
            (tabuleiro[0] == s && tabuleiro[3] == s && tabuleiro[6] == s) ||
            (tabuleiro[1] == s && tabuleiro[4] == s && tabuleiro[7] == s) ||
            (tabuleiro[2] == s && tabuleiro[5] == s && tabuleiro[8] == s) ||
            (tabuleiro[0] == s && tabuleiro[4] == s && tabuleiro[8] == s) ||
            (tabuleiro[2] == s && tabuleiro[4] == s && tabuleiro[6] == s)) {
            return true;
        }
        return false;
    }

    public static int jogadaHumano(char[] tabuleiro, char simbolo) {
        int posicao;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Jogador 1, escolha uma posição de (1-9): ");
            posicao = sc.nextInt() - 1;
            if (posicao >= 0 && posicao < 9 && tabuleiro[posicao] == ' ') {
                tabuleiro[posicao] = simbolo;
                return 1;
            } else {
                System.out.println("Posição inválida. Tente novamente.");
            }
        }
    }

    public static int jogadaComputador(char[] tabuleiro, char simbolo) {
        int posicao;
        Random rnd = new Random();

        do {
            posicao = rnd.nextInt(9);
        } while (tabuleiro[posicao] != ' ');
        tabuleiro[posicao] = simbolo;
        System.out.println("Jogador 2 (computador) jogou na posição " + (posicao + 1));
        return 1;
    }
}