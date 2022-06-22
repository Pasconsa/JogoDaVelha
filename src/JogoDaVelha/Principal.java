package JogoDaVelha;

public class Principal {

    String[][] tabuleiro = new String[3][3];

    public static void main(String[] args) {
        System.out.println("------Jogo da velha--------------");
        new Principal();
    }

    public Principal() {
        inicializarTabuleiro();
        atualizarTabuleiro();
    }

    public void atualizarTabuleiro(){
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }

    public void inicializarTabuleiro() {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {  //cada elemento dentro de cada linha.
                tabuleiro[i][j] = "_";
            }
        }
    }
}

