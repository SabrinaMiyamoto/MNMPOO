package model;

public class Pontuacao {
    private int quantidade;

    public int adicionar(int qtd) {
        this.quantidade += qtd;
        return this.quantidade;
    }

    public int subtrair(int qtd) {
        if (this.quantidade >= qtd) {
            this.quantidade -= qtd;
        } else {
            this.quantidade = 0;
        }
        return this.quantidade;
    }

    public int saldo() {
        return this.quantidade;
    }
}