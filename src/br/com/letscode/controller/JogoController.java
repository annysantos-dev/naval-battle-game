package br.com.letscode.controller;

import br.com.letscode.model.Tabuleiro;
import br.com.letscode.view.Jogo;

import java.util.Scanner;

public class JogoController implements Jogo {
    TabuleiroController tabuleiro = new TabuleiroController();
    Scanner leitor = new Scanner(System.in);
    @Override
    public void telaInicial() {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("|  #######  #######  #######  #######  #        #     #  #######  |");
        System.out.println("|  #    #   #     #     #     #     #  #        #     #  #     #  |");
        System.out.println("|  ######   #######     #     #######  #        #######  #######  |");
        System.out.println("|  #    #   #     #     #     #     #  #        #     #  #     #  |");
        System.out.println("|  #######  #     #     #     #     #  #######  #     #  #     #  |");
        System.out.println("|                                                                 |");
        System.out.println("|           #     #  #######  #     #  #######  #                 |");
        System.out.println("|           ##    #  #     #  #     #  #     #  #                 |");
        System.out.println("|           #  #  #  #######   #   #   #######  #                 |");
        System.out.println("|           #    ##  #     #    # #    #     #  #                 |");
        System.out.println("|           #     #  #     #     #     #     #  #######           |");
        System.out.println("-------------------------------------------------------------------");

        perguntarParaIniciarJogo();

    }

    @Override
    public void perguntarParaIniciarJogo() {
        System.out.println("Deseja iniciar o jogo? (S/N)");
        String verificacao = leitor.nextLine().toUpperCase();

        switch (verificacao) {
            case "S":
                iniciarJogo();
                break;
            case "N":
                System.exit(1);
                break;
            default:
                perguntarParaIniciarJogo();
        }

    }

    @Override
    public void iniciarJogo() {
        posicionarNaviosManualOuAutomatico();

        boolean continuarJogo = true;
        do {
            tabuleiro.exibirTabuleiro("JOGADOR", tabuleiro.tabuleiroJogador, false);
            if (jogada()) {
            }
        } while (continuarJogo);

        input.close();

    }

    @Override
    public boolean jogada() {
        System.out.println("Digite a posição do seu tiro. Letra seguida do número: Ex. A2");
        String tiroDoJogador = leitor.next();

        String verificacao = "^[A-Za-z]{1}[0-9]{1}$";
        if (tiroDoJogador.matches(verificacao)) {
            int[] posicoes = retornarPosicoes(tiroDoJogador);
            if (validarPosicoes(posicoes)) {
                if (tabuleiro.tabuleiroCpu[posicoes[0]][posicoes[1]] == 1) {
                    if (tabuleiro.tabuleiroJogador[posicoes[0]][posicoes[1]] == 1) {
                        tabuleiro.tabuleiroJogador[posicoes[0]][posicoes[1]] = 4;
                    } else {
                        tabuleiro.tabuleiroJogador[posicoes[0]][posicoes[1]] = 3;
                    }
                } else {
                    if (tabuleiro.tabuleiroJogador[posicoes[0]][posicoes[1]] == 1) {
                        tabuleiro.tabuleiroJogador[posicoes[0]][posicoes[1]] = 5;
                    } else {
                        tabuleiro.tabuleiroJogador[posicoes[0]][posicoes[1]] = 2;
                    }
                }
            } else {
                return false;
            }
        } else {
            System.out.println("Posição inválida");
            return false;
        }

        jogadaCPU();
        return true;
    }

    @Override
    public int[] retornarPosicoes(String tiroDoJogador) {
        return new int[0];
    }

    @Override
    public void posicionarNaviosManualOuAutomatico() {

    }

    @Override
    public boolean posicionarNavio(int indice) {
        return false;
    }

    @Override
    public boolean validarPosicoes(int[] posicoes) {
        return false;
    }

    @Override
    public boolean jogadaCPU() {
        return false;
    }
}
