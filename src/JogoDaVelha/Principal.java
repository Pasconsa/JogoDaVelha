/* Etapas Jogo xadrez
    1 criar tabuleiro Inicializar tabuleiro
    2 tabuleiro atualizado
    3 metodo jogo
                1 vai pedir a vez do jogador x ou 0 ; 2 pedir a posição e amarzenar;
                3 atualizar campo 4 verifica se o jogo acabou  , 5 inverter as ordens do jogador
                6 vai fazer tudo isso enquanto fim for falso
    4 Verificar psicao do tabuleiro
    5 verificar se alguem ganhou LINHA E DIAGONAL
 */


package JogoDaVelha;

import java.util.Scanner;

public class Principal {

    Scanner sc = new Scanner(System.in);
    String[][] tabuleiro = new String[3][3];
    boolean jogadorX = true;  //se X é verdadeiro então Y é falso
    boolean fim = false;  //o jogo não acabou
    int linha = 0;
    int coluna = 0;


    public static void main(String[] args) {
        System.out.println("------Jogo da velha--------------");
        new Principal();
    }

    public Principal() {
        inicializarTabuleiro();
        atualizarTabuleiro();
        jogo();
    }

    public void jogo() {                //faça algo enquanto o fim é falso
        do {
            System.out.println("E a vez do jogador: " + (jogadorX ? "X" : "O")); //? ternario jogador x é verdadeiro sim X não 0.
            proxPos();
            //etapa 4
            tabuleiro[linha - 1][coluna - 1] = (jogadorX ? "X" : "O");
            atualizarTabuleiro();
            verificarVencedor();

            jogadorX = !jogadorX;

        } while (!fim);
    }

    public void verificarVencedor() {  // 5 verificar se alguem ganhou
            if ((tabuleiro[0][0] == "X" && tabuleiro[1][0] == "X" && tabuleiro[2][0] == "X") ||
                (tabuleiro[0][1] == "X" && tabuleiro[1][1] == "X" && tabuleiro[2][1] == "X") ||
                (tabuleiro[0][2] == "X" && tabuleiro[1][2] == "X" && tabuleiro[2][2] == "X") ||
                (tabuleiro[0][0] == "X" && tabuleiro[0][1] == "X" && tabuleiro[0][2] == "X") ||
                (tabuleiro[1][0] == "X" && tabuleiro[1][1] == "X" && tabuleiro[1][2] == "X") ||
                (tabuleiro[2][0] == "X" && tabuleiro[2][1] == "X" && tabuleiro[2][2] == "X") ||
                (tabuleiro[0][0] == "X" && tabuleiro[1][1] == "X" && tabuleiro[2][2] == "X") ||   //verificar diagonal
                (tabuleiro[2][0] == "X" && tabuleiro[1][1] == "X" && tabuleiro[1][2] == "X")) {   //verificar diagonal
            fim = true;
        }

            if ((tabuleiro[0][0] == "O" && tabuleiro[1][0] == "O" && tabuleiro[2][0] == "O") ||
                (tabuleiro[0][1] == "O" && tabuleiro[1][1] == "O" && tabuleiro[2][1] == "O") ||
                (tabuleiro[0][2] == "O" && tabuleiro[1][2] == "O" && tabuleiro[2][2] == "O") ||
                (tabuleiro[0][0] == "O" && tabuleiro[0][1] == "O" && tabuleiro[0][2] == "O") ||
                (tabuleiro[1][0] == "O" && tabuleiro[1][1] == "O" && tabuleiro[1][2] == "O") ||
                (tabuleiro[2][0] == "O" && tabuleiro[2][1] == "O" && tabuleiro[2][2] == "O") ||
                (tabuleiro[0][0] == "O" && tabuleiro[1][1] == "O" && tabuleiro[2][2] == "O") ||   //verificar diagonal
                (tabuleiro[2][0] == "O" && tabuleiro[1][1] == "O" && tabuleiro[1][2] == "O")) {   //verificar diagonal
            fim = true;
        }

    }

    public void inicializarTabuleiro() {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {  //cada elemento dentro de cada linha.
                tabuleiro[i][j] = "_";
            }
        }
    }

    public void atualizarTabuleiro() {
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


    public void proxPos() {
        int l, c;        //linha e coluna
        boolean verificacaoL = false;
        boolean verificacaoC = false;

        do {
            System.out.println("Digite a linha do jogador: " + (jogadorX ? "X" : "O"));
            l = sc.nextInt();
            if (l < 4 && l > 0) {
                linha = l;
                verificacaoL = true;  //se digitou valor de 1 a 3 pode escolher a coluna
            }
        } while (!verificacaoL);


        do {
            System.out.println("Digite a coluna do jogador: " + (jogadorX ? "X" : "O"));
            c = sc.nextInt();
            if (c < 4 && c > 0) {
                coluna = c;
                verificacaoC = true;  //se digitou valor de 1 a 3 pode escolher a coluna
            }
        } while (!verificacaoC);
    }
}

