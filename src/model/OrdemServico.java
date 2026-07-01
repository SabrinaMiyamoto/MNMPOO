package model;

import enums.Status;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdemServico {
    private long numero;
    private double total;
    private Date agenda;
    private double desconto;
    private Status status;
    private Veiculo veiculo;
    private List<ItemOS> itensOS = new ArrayList<>();

    public OrdemServico() {
    }

    public OrdemServico(long numero, double desconto, Status status, Date agenda, Veiculo veiculo) {
        this.numero = numero;
        this.desconto = desconto;
        this.status = status;
        this.agenda = agenda;
        this.veiculo = veiculo;
    }

    public void add(ItemOS itemOS) {
        this.itensOS.add(itemOS);
        itemOS.setOrdemServico(this);
    }

    public void remove(ItemOS itemOS) {
        this.itensOS.remove(itemOS);
        itemOS.setOrdemServico(null);
    }

    public double calcularServico() throws ExceptionLavacao {
        if (this.itensOS.isEmpty()) {
            throw new ExceptionLavacao("não há serviços na lista para serem calculados");
        }

        double soma = 0;
        for (ItemOS item : itensOS) {
            soma += item.getValorServico();
        }

        if (this.desconto > 0) {
            soma = soma - (soma * (this.desconto / 100.0));
        }

        this.total = soma;
        return this.total;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getAgenda() {
        return agenda;
    }

    public void setAgenda(Date agenda) {
        this.agenda = agenda;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public List<ItemOS> getItensOS() {
        return itensOS;
    }

    public void setItensOS(List<ItemOS> itensOS) {
        this.itensOS = itensOS;
    }
}