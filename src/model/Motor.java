package model;

import enums.Combustivel;

public class Motor {
    private int potencia;
    private Combustivel tipoCombustivel;

    public Motor(int potencia, Combustivel tipoCombustivel) {
        this.potencia = potencia;
        this.tipoCombustivel = tipoCombustivel;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public Combustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(Combustivel tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }
}