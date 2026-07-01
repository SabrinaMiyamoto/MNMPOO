package model;

import enums.Categoria;

public class Servico {
    private Long id;
    private String descricao;
    private double valor;
    private Categoria categoria;
    private static int pontos;

    public Servico() {
    }

    public Servico(Long id, String descricao, double valor, Categoria categoria) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public static int getPontos() {
        return pontos;
    }

    public static void setPontos(int pontos) {
        Servico.pontos = pontos;
    }
}