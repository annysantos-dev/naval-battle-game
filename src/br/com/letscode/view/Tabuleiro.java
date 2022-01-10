package br.com.letscode.view;

public interface Tabuleiro {

    int[][] novoTabuleiroComNavios(boolean computador);

    void exibirTabuleiro(String nomeJogador, int[][] tabuleiro, boolean computador);

    void exibirTabuleiroDosDoisJogadores ();
}
