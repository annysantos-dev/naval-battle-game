package br.com.letscode.model;

public class Tabuleiro {
    private static int tamanhoX = 10, tamanhoY = 10;
    public static  int posicionarManualmente = 2;
    public static  int tabuleiroJogador[][] = new int[tamanhoX][tamanhoY], tabuleiroCpu[][]  = new int[tamanhoX][tamanhoY];


    public static int getTamanhoX() {
        return tamanhoX;
    }

    public static int getTamanhoY() {
        return tamanhoY;
    }

    public static int getPosicionarManualmente() {
        return posicionarManualmente;
    }

    public int getTabuleiroJogador(int p1, int p2) {
        return tabuleiroJogador[p1][p2];
    }

    public static void setPosicionarManualmente(int posicionarManualmente) {
        Tabuleiro.posicionarManualmente = posicionarManualmente;
    }

    public  int[][] getTabuleiroCpu() {

        return tabuleiroCpu;
    }

    public  void setTabuleiroJogador(int[][] tabuleiroJogador) {
        Tabuleiro.tabuleiroJogador = tabuleiroJogador;
    }
}
