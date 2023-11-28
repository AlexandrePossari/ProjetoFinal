package org.example.models;

public class Esconderijo {
    private String data;
    private Pedra pedra;
    private int preco;
    private int lucro;
    private int encantamento;
    private int grau;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Pedra getPedra() {
        return pedra;
    }

    public void setPedra(Pedra pedra) {
        this.pedra = pedra;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getLucro() {
        return lucro;
    }

    public void setLucro(int lucro) {
        this.lucro = lucro;
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
