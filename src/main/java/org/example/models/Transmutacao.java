package org.example.models;

public class Transmutacao {
    private int id;
    private int preco;
    private int encantamento;
    private int grau;

    public Transmutacao() {
    }

    public Transmutacao(int id, int preco, int encantamento, int grau) {
        this.id = id;
        this.preco = preco;
        this.encantamento = encantamento;
        this.grau = grau;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getEncantamento() {
        return encantamento;
    }

    public void setEncantamento(int encantamento) {
        this.encantamento = encantamento;
    }

    public int getGrau() {
        return grau;
    }

    public void setGrau(int grau) {
        this.grau = grau;
    }
}
