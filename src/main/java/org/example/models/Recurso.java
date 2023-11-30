package org.example.models;

public abstract class Recurso {
    private int id;
    private int quantidade;
    private int preco;
    private int encantamento;
    private int grau;

    public Recurso() {
    }

    public Recurso(int id, int quantidade, int preco, int encantamento, int grau) {
        this.id = id;
        this.quantidade = quantidade;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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
