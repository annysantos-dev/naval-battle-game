package br.com.letscode;

public class Main {
    public static void main(String[] args) {

       Jogo jogo = new Jogo();
       jogo.telaInicial();
       Tabuleiro tab = new Tabuleiro();
       tab.exibirTabuleiroDosDoisJogadores();

    }
}
