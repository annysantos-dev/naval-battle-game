package br.com.letscode.model;

import br.com.letscode.controller.JogoController;
import br.com.letscode.controller.TabuleiroController;

public class Main {
    public static void main(String[] args) {
       JogoController jogo = new JogoController();
       jogo.telaInicial();
       TabuleiroController tab = new TabuleiroController();
       tab.exibirTabuleiroDosDoisJogadores();

    }
}
