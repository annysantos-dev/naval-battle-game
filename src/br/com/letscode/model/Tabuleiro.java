package br.com.letscode.model;

public class Tabuleiro {
    private static int tamanhoX = 10, tamanhoY = 10;
    private int posicionarManualmente = 2;
    private int tabuleiroJogador[][] = new int[tamanhoX][tamanhoY], tabuleiroCpu[][] = new int[tamanhoX][tamanhoY];

    public static int getTamanhoX() {
        return tamanhoX;
    }

    public static int getTamanhoY() {
        return tamanhoY;
    }

    public int getPosicionarManualmente() {
        return posicionarManualmente;
    }

    public void setPosicionarManualmente(int posicionarManualmente) {
        this.posicionarManualmente = posicionarManualmente;
    }

    public int getTabuleiroJogador(int p1, int p2) {
        return this.tabuleiroJogador[p1][p2];
    }

    public int[][] getTabuleiroJogador() {
        return tabuleiroJogador;
    }

    public int getTabuleiroCpu(int p1, int p2) {
        return this.tabuleiroCpu[p1][p2];
    }

    public int[][] getTabuleiroCpu() {
        return tabuleiroCpu;
    }

    public void setTabuleiroJogadorPosicao(int p1, int p2, int num) {
        for(int i = 0; i < tamanhoY; i++){
            for(int j = 0; j < tamanhoX; j++){
                if(i == p1 && j == p2){
                    this.tabuleiroJogador[p1][p2] = num;
                }
            }
        }
    }

    public void setTabuleiroJogador(int[][] tabuleiroJogador) {
        this.tabuleiroJogador = tabuleiroJogador;
    }

    public void setTabuleiroCpuPosicao(int p1, int p2, int num) {
        for(int i = 0; i < tamanhoY; i++){
            for(int j = 0; j < tamanhoX; j++){
                if(i == p1 && j == p2){
                    this.tabuleiroCpu[p1][p2] = num;
                }
            }
        }
    }

    public void setTabuleiroCpu(int[][] tabuleiroCpu) {
        this.tabuleiroCpu = tabuleiroCpu;
    }
}
