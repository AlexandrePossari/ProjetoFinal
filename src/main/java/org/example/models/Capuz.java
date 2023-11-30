package org.example.models;

public class Capuz {
    private int id;
    private int preco;
    private int receita;
    private int encantamento;
    private int grau;

    public Capuz(int id, int preco, int encantamento, int grau) {
        this.id = id;
        this.preco = preco;
        this.encantamento = encantamento;
        this.grau = grau;
    }

    public Capuz() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getReceita() {
        return receita;
    }

    public void setReceita(int receita) {
        this.receita = receita;
    }
}
