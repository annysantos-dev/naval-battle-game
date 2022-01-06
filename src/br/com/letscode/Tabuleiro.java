package br.com.letscode;

import java.util.Random;

public class Tabuleiro {
    private int tamanhoX = 10, tamanhoY = 10;
    public int posicionarManualmente = 2;
    public int tabuleiroJogador[][] = new int[tamanhoX][tamanhoY], tabuleiroCpu[][]  = new int[tamanhoX][tamanhoY];

    public int getTamanhoX() {
        return tamanhoX;
    }

    public int getTamanhoY() {
        return tamanhoY;
    }

    public int[][] retornarNovoTabuleiroComNavios(boolean computador) {
        int novoTabuleiro[][] = new int[tamanhoX][tamanhoY];
        int quantidadeRestanteDeNavios = 10;
        int x = 0, y = 0;

        if (posicionarManualmente == 2 || computador) {
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

    public void exibirTabuleiro(String nomeJogador, int[][] tabuleiro, boolean computador) {
        System.out.println("---------------------------------------------");
        if(!computador){
            System.out.println("                   " + nomeJogador + "                 ");
        } else{
            System.out.println("                 " + nomeJogador + "               ");
        }
        System.out.println("---------------------------------------------");
        int numeroDaLinha = 0;
        String linhaDoTabuleiro = "|   | ";
        for (int i = 0; i < tamanhoX; i++) {
            linhaDoTabuleiro += (numeroDaLinha++) + " | ";
        }
        System.out.println(linhaDoTabuleiro);
        System.out.println("---------------------------------------------");

        char letraDaColuna = 65;
        String letrasDoTabuleiro = "";
        for (int[] linha : tabuleiro) {
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

    public void exibirTabuleiroDosDoisJogadores () {
        exibirTabuleiro("JOGADOR", tabuleiroJogador, false);
        exibirTabuleiro("COMPUTADOR", tabuleiroCpu, true);
    }
}
