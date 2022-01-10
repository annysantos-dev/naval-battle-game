package br.com.letscode.view;

public interface TabuleiroView {

    int[][] novoTabuleiroComNavios(boolean computador);

    void exibirTabuleiro(String nomeJogador, int[][] tabuleiro, boolean computador);

    void exibirTabuleiroDosDoisJogadores ();
}
