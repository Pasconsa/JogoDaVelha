/* Etapas Jogo xadrez
    1 criar tabuleiro Inicializar tabuleiro
    2 tabuleiro atualizado
    3 metodo jogo
                1 vai pedir a vez do jogador x ou 0 ; 2 pedir a posição e amarzenar;
                3 atualizar campo 4 verifica se o jogo acabou  , 5 inverter as ordens do jogador
                6 vai fazer tudo isso enquanto fim for falso
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
        } while (!fim);
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
                linha = c;
                verificacaoC = true;  //se digitou valor de 1 a 3 pode escolher a coluna
            }
        } while (!verificacaoC);
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

    public void inicializarTabuleiro() {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {  //cada elemento dentro de cada linha.
                tabuleiro[i][j] = "_";
            }
        }
    }
}

