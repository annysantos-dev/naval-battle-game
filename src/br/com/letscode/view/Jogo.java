package br.com.letscode.view;

public interface Jogo {

    void telaInicial();

    void perguntarParaIniciarJogo();

    void iniciarJogo();

    boolean jogada();

    int[] retornarPosicoes(String tiroDoJogador);

    void posicionarNaviosManualOuAutomatico();

    boolean posicionarNavio(int indice);

    boolean validarPosicoes(int[] posicoes);

    boolean jogadaCPU();
}
