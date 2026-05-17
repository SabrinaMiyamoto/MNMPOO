package model;

public class PessoaJuridica extends Cliente {
    private String cnpj;
    private String inscricaoEstadual;

    public PessoaJuridica() {
        super();
    }

    public PessoaJuridica(String nome, String cnpj, String inscricaoEstadual) {
        super(nome);
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    @Override
    public String getDados() {
        return super.getDados() +
                "\nCNPJ: " + cnpj +
                "\nInscrição Estadual: " + inscricaoEstadual;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }
}