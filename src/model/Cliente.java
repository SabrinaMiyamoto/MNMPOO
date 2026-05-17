package model;

import interfaces.IDados;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente implements IDados {
    protected int id;
    protected String nome;
    protected String celular;
    protected String email;
    protected LocalDate dataCadastro;

    protected Pontuacao pontuacao;
    protected List<Veiculo> veiculos = new ArrayList<>();

    public Cliente() {
        this.pontuacao = new Pontuacao();
        this.dataCadastro = LocalDate.now();
    }

    public Cliente(String nome) {
        this();
        this.nome = nome;
    }

    public void add(Veiculo veiculo) {
        if (!this.veiculos.contains(veiculo)) {
            this.veiculos.add(veiculo);
            veiculo.setCliente(this);
        }
    }

    public void remove(Veiculo veiculo) {
        if (this.veiculos.contains(veiculo)) {
            this.veiculos.remove(veiculo);
            veiculo.setCliente(null);
        }
    }

    @Override
    public String getDados() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Nome: " + nome +
                "\nCelular: " + celular +
                "\nE-mail : " + email +
                "\nData de cadastro: " + dataCadastro.format(formatter);
    }

    @Override
    public String getDados(String observacao) {
        return getDados() +
                "\nObservação: " + observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public Pontuacao getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Pontuacao pontuacao) {
        this.pontuacao = pontuacao;
    }
}