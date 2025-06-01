import java.util.Random;
import java.util.Scanner;

public class joguinho {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int vitoriasJogador1 = 0;
        int vitoriasComputador = 0;
        int empates = 0;
        char jogarNovamente;

        do {
            char[] tabuleiro = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
            int jogadorAtual = random.nextInt(2);
            if (jogadorAtual == 0) {
                System.out.println("Jogador 1 começa!");
            } else {
                System.out.println("Computador começa!");
            }

            Tabuleiro.mostrar(tabuleiro);

            System.out.print("Jogador 1, escolha seu símbolo (X/O): ");
            char simbolo1 = scanner.next().toUpperCase().charAt(0);
            char simbolo2;
            if (simbolo1 == 'X') {
                simbolo2 = 'O';
                } else {
                simbolo2 = 'X';
            }

            boolean jogoAtivo = true;
            int jogadas = 0;

            while (jogoAtivo && jogadas < 9) {
                if (jogadorAtual == 0) {
                    jogadas += Utils.jogadaHumano(tabuleiro, scanner, simbolo1);
                    Tabuleiro.mostrar(tabuleiro);
                    if (Utils.verificarVencedor(tabuleiro, simbolo1)) {
                        System.out.println("Jogador 1 venceu!");
                        vitoriasJogador1++;
                        break;
                    }
                } else {
                    jogadas += Utils.jogadaComputador(tabuleiro, random, simbolo2);
                    Tabuleiro.mostrar(tabuleiro);
                    if (Utils.verificarVencedor(tabuleiro, simbolo2)) {
                        System.out.println("Jogador 2 (computador) venceu!");
                        vitoriasComputador++;
                        break;
                    }
                }

                if (jogadas == 9) break;
                jogadorAtual = 1 - jogadorAtual;
            }

            if (!Utils.verificarVencedor(tabuleiro, simbolo1) && !Utils.verificarVencedor(tabuleiro, simbolo2)) {
                System.out.println("Empate!");
                empates++;
            }

            System.out.print("Deseja jogar novamente? (S/N): ");
            jogarNovamente = scanner.next().toUpperCase().charAt(0);

        } while (jogarNovamente == 'S');

        System.out.println("\nPlacar Final:");
        System.out.println("Vitórias do Jogador 1: " + vitoriasJogador1);
        System.out.println("Vitórias Computador: " + vitoriasComputador);
        System.out.println("Empates: " + empates);
        System.out.println("Parabéns, amassou!");

        scanner.close();
    }
}
