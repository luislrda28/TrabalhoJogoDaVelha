package JogoDaVelha;

public class Tabuleiro {
    public static void mostrar(char[] tabuleiro) {
        System.out.println("___________________");
        System.out.println("|     |     |     |");
        System.out.println("|  " + tabuleiro[0] + "  |  " + tabuleiro[1] + "  |  " + tabuleiro[2] + "  |");
        System.out.println("|-----+-----+-----|");
        System.out.println("|  " + tabuleiro[3] + "  |  " + tabuleiro[4] + "  |  " + tabuleiro[5] + "  |");
        System.out.println("|-----+-----+-----|");
        System.out.println("|  " + tabuleiro[6] + "  |  " + tabuleiro[7] + "  |  " + tabuleiro[8] + "  |");
        System.out.println("|_____|_____|_____|");
    }
}
