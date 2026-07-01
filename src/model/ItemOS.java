package model;

public class ItemOS {
    private double valorServico;
    private String observacoes;
    private Servico servico;
    private OrdemServico ordemServico;

    public ItemOS() {
    }

    public ItemOS(double valorServico, Servico servico, OrdemServico ordemServico) {
        this.valorServico = valorServico;
        this.servico = servico;
        this.ordemServico = ordemServico;
    }

    public ItemOS(double valorServico, String observacoes, Servico servico, OrdemServico ordemServico) {
        this.valorServico = valorServico;
        this.observacoes = observacoes;
        this.servico = servico;
        this.ordemServico = ordemServico;
    }

    public double getValorServico() {
        return valorServico;
    }

    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }
}