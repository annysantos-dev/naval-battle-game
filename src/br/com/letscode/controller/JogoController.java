package br.com.letscode.controller;

import br.com.letscode.model.Jogo;
import br.com.letscode.model.Tabuleiro;
import br.com.letscode.view.JogoView;
import java.util.Random;
import java.util.Scanner;

public class JogoController implements JogoView {

    Jogo jogo;
    Tabuleiro tabuleiro;
    TabuleiroController t;
    Scanner leitor;

    public JogoController() {
        this.jogo = new Jogo(0,0,0, false);
        this.tabuleiro = new Tabuleiro();
        this.t = new TabuleiroController();
        this.leitor = new Scanner(System.in);
    }

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
            t.exibirTabuleiro("JOGADOR", tabuleiro.getTabuleiroJogador(), false);
            if (jogada()) {
            }
        } while (continuarJogo);

        leitor.close();

    }

    @Override
    public boolean jogada() {
        System.out.println("Digite a posição do seu tiro. Letra seguida do número: Ex. A2");
        String tiroDoJogador = leitor.next();

        String verificacao = "^[A-Za-z]{1}[0-9]{1}$";
        if (tiroDoJogador.matches(verificacao)) {
            int[] posicoes = retornarPosicoes(tiroDoJogador);
            if (validarPosicoes(posicoes)) {
                System.out.println(tabuleiro.getTabuleiroCpu(posicoes[0], posicoes[1]) + " " + tabuleiro.getTabuleiroJogador(posicoes[0], posicoes[1]));
                if (tabuleiro.getTabuleiroCpu(posicoes[0], posicoes[1]) == 1) {
                    if (tabuleiro.getTabuleiroJogador(posicoes[0], posicoes[1]) == 1) {
                        tabuleiro.setTabuleiroJogadorPosicao(posicoes[0],posicoes[1], 4);
                    } else {
                        tabuleiro.setTabuleiroJogadorPosicao(posicoes[0],posicoes[1], 3);
                    }
                } else {
                    if (tabuleiro.getTabuleiroJogador(posicoes[0], posicoes[1]) == 1) {
                        tabuleiro.setTabuleiroJogadorPosicao(posicoes[0],posicoes[1], 5);
                    } else {
                        tabuleiro.setTabuleiroJogadorPosicao(posicoes[0],posicoes[1], 2);
                    }
                }
            } else {
                return false;
            }
        } else {
            System.out.println("Posição inválida");
            return false;
        }


        return jogadaCPU();
    }

    @Override
    public int[] retornarPosicoes(String tiroDoJogador) {
        int[] returno = new int[2];
        returno[0] = tiroDoJogador.toUpperCase().charAt(0) - 65;
        returno[1] = Integer.parseInt(tiroDoJogador.substring(1));
        return returno;
    }

    @Override
    public void posicionarNaviosManualOuAutomatico() {
        this.leitor = new Scanner(System.in);

        System.out.println("Você deseja posicionar seus navios ou quer que sejam posicionados de forma automática?");
        System.out.println("1 - Posicionar Manualmente");
        System.out.println("2 - Posicionar Automaticamente");
        tabuleiro.setPosicionarManualmente(leitor.nextInt());

        switch (tabuleiro.getPosicionarManualmente()) {
            case 1:
                int quantidadeNavios = 0;
                do {
                    boolean posicionarNavio = posicionarNavio(quantidadeNavios + 1);
                    if(posicionarNavio) {
                        quantidadeNavios++;
                    }
                } while (quantidadeNavios < 10);
                tabuleiro.setTabuleiroCpu(t.novoTabuleiroComNavios(true));
                break;
            case 2:
                tabuleiro.setTabuleiroJogador(t.novoTabuleiroComNavios(false));
                tabuleiro.setTabuleiroCpu(t.novoTabuleiroComNavios(true));
                break;
            default:
                posicionarNaviosManualOuAutomatico();
        }
    }

    @Override
    public boolean posicionarNavio(int indice) {
        System.out.println("Digite onde deseja posicionar o " + indice + "° navio. Letra seguida do número: Ex. A2");
        String tiroDoJogador = leitor.next();

        String verificacao = "^[A-Za-z]{1}[0-9]{1}$";
        if (tiroDoJogador.matches(verificacao)) {
            int[] posicoes = retornarPosicoes(tiroDoJogador);
            if (validarPosicoes(posicoes)) {
                if (tabuleiro.getTabuleiroCpu(posicoes[0], posicoes[1]) == 0) {
                    tabuleiro.setTabuleiroJogadorPosicao(posicoes[0],posicoes[1], 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            System.out.println("Posição inválida");
            return false;
        }

        return true;
    }

    @Override
    public boolean validarPosicoes(int[] posicoes) {
        boolean retorno = true;

        if (posicoes[0] > this.tabuleiro.getTamanhoY()) {
            System.out.println("A letra não pode ser maior que " + (char) (this.tabuleiro.getTamanhoY() + 64));
            retorno = false;
        }

        if (posicoes[1] > this.tabuleiro.getTamanhoX()) {
            System.out.println("O número não pode ser maior que " + this.tabuleiro.getTamanhoX());
            retorno = false;
        }

        return retorno;
    }

    @Override
    public boolean jogadaCPU() {
        Random jogadaCpu = new Random();
        String letraJogador = "abcdefghij", numeroJogador = "0123456789";

        for (int i = 0; i < 1; i++) {

            String novaLetra = String.valueOf(letraJogador.charAt(jogadaCpu.nextInt(letraJogador.length()))).toUpperCase();
            String novoNumero = String.valueOf(numeroJogador.charAt(jogadaCpu.nextInt(numeroJogador.length()))).toUpperCase();
            String jogadaCompleta = novaLetra + novoNumero;
            String verificacaoCpu = "^[A-Za-z]{1}[0-9]{1}$";

            if (jogadaCompleta.matches(verificacaoCpu)) {
                int[] posicoes = retornarPosicoes(jogadaCompleta);
                if (validarPosicoes(posicoes)) {
                    if (tabuleiro.getTabuleiroJogador(posicoes[0], posicoes[1]) == 1) {
                        if (tabuleiro.getTabuleiroCpu(posicoes[0], posicoes[1]) == 1) {
                            tabuleiro.setTabuleiroCpuPosicao(posicoes[0], posicoes[1],4);
                            jogo.setMorteCPU(jogo.getMorteCPU() + 1);
                            if (jogo.getMorteCPU() == 10){
                                System.out.println("A CPU venceu...");
                                System.out.println("Os Dois Tabuleiros Surgindo em 3..2..1");
                                jogo.setFinalizaJogo(jogo.getFinalizaJogo() + 10);
                                if (jogo.getFinalizaJogo() == 10){
                                    jogo.setFinalizaJogoCompleto(true);
                                }
                            }
                        } else {
                            tabuleiro.setTabuleiroCpuPosicao(posicoes[0], posicoes[1],3);
                            jogo.setMorteCPU(jogo.getMorteCPU() + 1);
                            if (jogo.getMorteCPU()  == 10){
                                System.out.println("A CPU Venceu...");
                                System.out.println("Os Dois Tabuleiros Surgindo em 3..2..1");
                                jogo.setFinalizaJogo(jogo.getFinalizaJogo() + 10);
                                if (jogo.getFinalizaJogo() == 10){
                                    jogo.setFinalizaJogoCompleto(true);
                                }
                            }
                        }
                    } else {
                        if (tabuleiro.getTabuleiroCpu(posicoes[0], posicoes[1]) == 1) {
                            tabuleiro.setTabuleiroCpuPosicao(posicoes[0], posicoes[1],5);
                        } else {
                            tabuleiro.setTabuleiroCpuPosicao(posicoes[0], posicoes[1],2);
                        }
                    }
                } else {
                    return false;
                }
            } else {
                System.out.println("Posição inválida");
                return false;
            }

            t.exibirTabuleiroDosDoisJogadores();
            System.out.println("chegou" + jogo.isFinalizaJogoCompleto());
            if (jogo.isFinalizaJogoCompleto() == true){
                t.exibirTabuleiroDosDoisJogadores();
                System.exit(0);
            }

            return true;
        }
        return false;
    }
}
