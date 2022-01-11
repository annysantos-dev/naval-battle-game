package br.com.letscode.controller;

import br.com.letscode.model.Tabuleiro;
import br.com.letscode.view.TabuleiroView;

import java.util.Random;

public class TabuleiroController implements TabuleiroView {

    Tabuleiro tabuleiro;

    public TabuleiroController() {
        this.tabuleiro = new Tabuleiro();
    }

    @Override
    public int[][] novoTabuleiroComNavios(boolean computador) {
        int novoTabuleiro[][] = new int[tabuleiro.getTamanhoX()][tabuleiro.getTamanhoY()];
        int quantidadeRestanteDeNavios = 10;
        int x = 0, y = 0;

        if (tabuleiro.getPosicionarManualmente() == 2 || computador) {
            Random rand = new Random();
            do {
                x = 0;
                y = 0;
                for (int[] linha : novoTabuleiro) {
                    for (int coluna : linha) {
                        if (rand.nextInt(100) <= 10) {
                            if (coluna == 0) {
                                novoTabuleiro[x][y] = 1;
                                quantidadeRestanteDeNavios--;
                                break;
                            }

                            if (quantidadeRestanteDeNavios <= 0) {
                                break;
                            }
                        }
                        y++;
                    }
                    y = 0;
                    x++;
                    if (quantidadeRestanteDeNavios <= 0) {
                        break;
                    }
                }
            } while (quantidadeRestanteDeNavios > 0);
        }

        return novoTabuleiro;
    }

    @Override
    public void exibirTabuleiro(String nomeJogador, int[][] tab, boolean computador) {
        System.out.println("---------------------------------------------");
        if(!computador){
            System.out.println("                   " + nomeJogador + "                 ");
        } else{
            System.out.println("                 " + nomeJogador + "               ");
        }
        System.out.println("---------------------------------------------");
        int numeroDaLinha = 0;
        String linhaDoTabuleiro = "|   | ";
        for (int i = 0; i < tabuleiro.getTamanhoX(); i++) {
            linhaDoTabuleiro += (numeroDaLinha++) + " | ";
        }
        System.out.println(linhaDoTabuleiro);
        System.out.println("---------------------------------------------");

        char letraDaColuna = 65;
        String letrasDoTabuleiro = "";
        for (int[] linha : tab) {
            letrasDoTabuleiro = "| " + (letraDaColuna++) + " | ";
            for (int coluna : linha) {
                switch (coluna) {
                    case 0: // Vazio
                        letrasDoTabuleiro += "  | ";
                        break;
                    case 1: // Navio
                        letrasDoTabuleiro += "N | ";
                        break;
                    case 2: // Tiro na água
                        letrasDoTabuleiro += "- | ";
                        break;
                    case 3: // Tiro certeiro
                        letrasDoTabuleiro += "* | ";
                        break;
                    case 4: // Tiro certeiro com navio posicionado
                        letrasDoTabuleiro += "X | ";
                        break;
                    case 5: // Tiro na água com navio posicionado
                        letrasDoTabuleiro += "n | ";
                        break;
                }
            }
            System.out.println(letrasDoTabuleiro);
            System.out.println("---------------------------------------------");
        }
    }
    @Override
    public void exibirTabuleiroDosDoisJogadores() {
        exibirTabuleiro("JOGADOR", tabuleiro.getTabuleiroJogador(), false);
        exibirTabuleiro("COMPUTADOR", tabuleiro.getTabuleiroCpu(), true);
    }
}
