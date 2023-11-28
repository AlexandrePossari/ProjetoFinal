package org.example.models;

public class Recurso_has_Transmutacao {
    private Transmutacao transmutacao;
    private Recurso recurso;
    private int lucro;

    public Transmutacao getTransmutacao() {
        return transmutacao;
    }

    public void setTransmutacao(Transmutacao transmutacao) {
        this.transmutacao = transmutacao;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public int getLucro() {
        return lucro;
    }

    public void setLucro(int lucro) {
        this.lucro = lucro;
    }
}
