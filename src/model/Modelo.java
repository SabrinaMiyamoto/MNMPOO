package model;

import enums.Categoria;
import enums.Combustivel;

import java.util.Calendar;

public class Modelo {
    private int id;
    private String descricao;
    private Marca marca;
    private Categoria categoria;
    private Motor motor;

    public Modelo() {}

    public Modelo(String descricao, Marca marca, Categoria categoria, int potenciaMotor, Combustivel combustivel) {
        this.descricao = descricao;
        this.marca = marca;
        this.categoria = categoria;
        this.motor = new Motor(potenciaMotor, combustivel);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }
}