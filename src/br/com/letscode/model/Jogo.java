package br.com.letscode.model;

import java.util.Scanner;

public class Jogo {

    private int morteCPU;
    private int morteJogador;
    private int finalizaJogo;
    private boolean finalizaJogoCompleto;

    public Jogo(int morteCPU, int morteJogador, int finalizaJogo, boolean finalizaJogoCompleto) {
        this.morteCPU = morteCPU;
        this.morteJogador = morteJogador;
        this.finalizaJogo = finalizaJogo;
        this.finalizaJogoCompleto = finalizaJogoCompleto;
    }

    public int getMorteCPU() {
        return morteCPU;
    }

    public int getMorteJogador() {
        return morteJogador;
    }

    public int getFinalizaJogo() {
        return finalizaJogo;
    }

    public boolean isFinalizaJogoCompleto() {
        return finalizaJogoCompleto;
    }

    public void setMorteCPU(int morteCPU) {
        morteCPU = morteCPU;
    }

    public void setMorteJogador(int morteJogador) {
        this.morteJogador = morteJogador;
    }

    public void setFinalizaJogo(int finalizaJogo) {
        this.finalizaJogo = finalizaJogo;
    }

    public void setFinalizaJogoCompleto(boolean finalizaJogoCompleto) {
        this.finalizaJogoCompleto = finalizaJogoCompleto;
    }
}
