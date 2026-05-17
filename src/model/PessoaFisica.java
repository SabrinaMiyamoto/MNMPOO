package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PessoaFisica extends Cliente {
    private String cpf;
    private LocalDate dataNascimento;

    public PessoaFisica() {
        super();
    }

    public PessoaFisica(String nome, String cpf, LocalDate dataNascimento) {
        super(nome);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String getDados() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return super.getDados() +
                "\nCPF: " + cpf +
                "\nData de nascimento: " + dataNascimento.format(formatter);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}