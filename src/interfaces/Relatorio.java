package interfaces;

import model.Cliente;

public class Relatorio {
    public String imprimir(Cliente cliente) {
        return cliente.getDados();
    }
}