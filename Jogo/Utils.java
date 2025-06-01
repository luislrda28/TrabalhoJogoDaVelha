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