package model;

import interfaces.IDados;

public class Veiculo implements IDados {
    private int id;
    private String placa;
    private String observacoes;
    private Modelo modelo;
    private Cor cor;
    private Cliente cliente;

    public Veiculo() {}

    public Veiculo(String placa) {
        this.placa = placa;
    }

    public Veiculo(String placa, Modelo modelo) {
        this.placa = placa;
        this.modelo = modelo;
    }

    @Override
    public String getDados() {

        String dados =
                "Placa: " + placa;

        if (modelo != null) {

            dados += "\nModelo: " + modelo.getDescricao();

            if (modelo.getMarca() != null) {
                dados += "\nMarca: " + modelo.getMarca().getNome();
            }

            if (modelo.getCategoria() != null) {
                dados += "\nCategoria: " + modelo.getCategoria();
            }

            if (modelo.getMotor() != null) {
                dados += "\nPotência Motor: " + modelo.getMotor().getPotencia();
            }
        }

        // Professor, eu sei que no Mão na massa não pedi, mas como na minha tela tem a cor, modelo e observações, eu achei melhor deixar para na integração não ficar batendo cabeça rs
        if (cor != null) {
            dados += "\nCor: " + cor.getNome();
        }

        if (modelo != null && modelo.getMotor() != null) {
            dados += "\nCombustível: " + modelo.getMotor().getTipoCombustivel();
        }

        if (observacoes != null && !observacoes.isBlank()) {
            dados += "\nObservações: " + observacoes;
        }

        return dados;
    }
    @Override
    public String getDados(String observacao) {
        return getDados() + "\nObservação adicional: " + observacao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}