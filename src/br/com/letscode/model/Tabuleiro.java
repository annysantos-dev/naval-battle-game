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

    public static int[][] getTabuleiroJogador() {
        return tabuleiroJogador;
    }

    public static int[][] getTabuleiroCpu() {
        return tabuleiroCpu;
    }
}
