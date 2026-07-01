package interfaces;

import model.OrdemServico;
import model.ItemOS;
import java.text.SimpleDateFormat;

public class ImpressaoOS {
    public String imprimirOS(OrdemServico os) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();

        sb.append("Número: ").append(os.getNumero());
        sb.append("      dia: ").append(os.getAgenda() != null ? sdf.format(os.getAgenda()) : "");
        sb.append("      status: ").append(os.getStatus()).append("\n");

        if (os.getVeiculo() != null && os.getVeiculo().getCliente() != null) {
            sb.append("Cliente: ").append(os.getVeiculo().getCliente().getNome()).append("\n");
        }

        if (os.getVeiculo() != null) {
            sb.append("Veiculo: ").append(os.getVeiculo().getPlaca());
            if (os.getVeiculo().getModelo() != null) {
                sb.append("         Modelo: ").append(os.getVeiculo().getModelo().getDescricao());
            }
            sb.append("\n");
        }

        sb.append("=========================================================\n");
        sb.append("ITEM DESCRICAO                                     VALOR\n");
        sb.append("=========================================================\n");

        int cont = 1;
        double subtotal = 0;
        for (ItemOS item : os.getItensOS()) {
            sb.append(String.format("%-4d %-40s %10.2f\n",
                    cont++,
                    item.getServico().getDescricao(),
                    item.getValorServico()));
            subtotal += item.getValorServico();
        }

        sb.append("=========================================================\n");
        sb.append(String.format("SUBTOTAL                                       %10.2f\n", subtotal));
        sb.append(String.format("DESCONTO (%.0f%%)                               %10.2f\n",
                os.getDesconto(),
                (subtotal * (os.getDesconto() / 100.0))));
        sb.append("=========================================================\n");
        sb.append(String.format("TOTAL                                          %10.2f\n", os.getTotal()));

        return sb.toString();
    }
}