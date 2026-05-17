package main;

import model.*;
import enums.*;
import interfaces.IDados;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        List<Cliente> listaClientes = new ArrayList<>();
        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        int quantity = 0;
        while (quantity <= 0) {
            System.out.print("Quantos clientes deseja cadastrar? ");
            if (leitor.hasNextInt()) {
                quantity = leitor.nextInt();
                leitor.nextLine();
                if (quantity <= 0) System.out.println(">> Digite um número maior que zero.");
            } else {
                System.out.println(">> Erro: Digite um número inteiro.");
                leitor.nextLine();
            }
        }

        for (int i = 0; i < quantity; i++) {
            System.out.println("\n--- Cadastro do " + (i + 1) + "º Cliente ---");

            int tipo = 0;
            while (tipo != 1 && tipo != 2) {
                System.out.print("Tipo de Cliente (1 - Física, 2 - Jurídica): ");
                if (leitor.hasNextInt()) {
                    tipo = leitor.nextInt();
                    leitor.nextLine();
                    if (tipo != 1 && tipo != 2) {
                        System.out.println(">> Opção inválida! Digite apenas 1 ou 2.");
                    }
                } else {
                    System.out.println(">> Erro: Digite um número inteiro (1 ou 2).");
                    leitor.nextLine();
                }
            }

            String nome = "";
            while (true) {
                System.out.print("Nome do Cliente: ");
                nome = leitor.nextLine();
                if (nome.matches("[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÔÕÖÚÇÑ ]+")) {
                    break;
                } else {
                    System.out.println(">> Erro: O nome do cliente deve conter apenas letras e espaços.");
                }
            }

            Cliente cliente;

            if (tipo == 1) {
                String cpfBruto = "";
                while (true) {
                    System.out.print("CPF: ");
                    cpfBruto = leitor.nextLine().replaceAll("\\D", "");
                    if (cpfBruto.matches("\\d{11}")) {
                        break;
                    } else {
                        System.out.println(">> Erro: O CPF deve conter exatamente 11 números.");
                    }
                }
                String cpfFormatado = cpfBruto.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");

                LocalDate dataNascimento = null;
                while (dataNascimento == null) {
                    System.out.print("Data de Nascimento (DD/MM/AAAA): ");
                    String dataInput = leitor.nextLine();
                    try {
                        dataNascimento = LocalDate.parse(dataInput, formatadorData);
                    } catch (DateTimeParseException e) {
                        System.out.println(">> Erro: Formato de data inválido. Use o padrão DD/MM/AAAA (Ex: 05/01/2000).");
                    }
                }

                cliente = new PessoaFisica(nome, cpfFormatado, dataNascimento);
            } else {
                String cnpjBruto = "";
                while (true) {
                    //Na SES já estamos integrando no BD o modelo alphanumérico, por isso eu já deixei aqui tbm rs
                    System.out.print("CNPJ: ");
                    cnpjBruto = leitor.nextLine().replaceAll("[^a-zA-Z0-9]", "");
                    if (cnpjBruto.matches("[a-zA-Z0-9]{14}")) {
                        break;
                    } else {
                        System.out.println(">> Erro: O CNPJ deve conter exatamente 14 caracteres alfanuméricos.");
                    }
                }
                String cnpjFormatado = cnpjBruto.toUpperCase().replaceAll("([a-zA-Z0-9]{2})([a-zA-Z0-9]{3})([a-zA-Z0-9]{3})([a-zA-Z0-9]{4})([a-zA-Z0-9]{2})", "$1.$2.$3/$4-$5");

                String ie = "";
                while (true) {
                    System.out.print("Inscrição Estadual: ");
                    ie = leitor.nextLine().replaceAll("\\D", "");
                    if (ie.length() >= 8) {
                        break;
                    } else {
                        System.out.println(">> Erro: A Inscrição Estadual deve conter no mínimo 8 números.");
                    }
                }
                cliente = new PessoaJuridica(nome, cnpjFormatado, ie);
            }

            String celularBruto = "";
            while (true) {
                System.out.print("Celular: ");
                celularBruto = leitor.nextLine();
                if (celularBruto.matches("\\d{10,11}")) {
                    break;
                } else {
                    System.out.println(">> Erro: O celular deve conter apenas números e ter exatamente 10 ou 11 dígitos.");
                }
            }

            String celularFormatado = celularBruto;
            if (celularBruto.length() == 11) {
                celularFormatado = celularBruto.replaceAll("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3");
            } else {
                celularFormatado = celularBruto.replaceAll("(\\d{2})(\\d{4})(\\d{4})", "($1) $2-$3");
            }
            cliente.setCelular(celularFormatado);

            String email = "";
            String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            while (true) {
                System.out.print("Email: ");
                email = leitor.nextLine();
                if (email.matches(regexEmail)) {
                    break;
                } else {
                    System.out.println(">> Erro: Formato de e-mail inválido! Use o formato padrão (nome@provedor.com).");
                }
            }
            cliente.setEmail(email);

            System.out.println("\n-- Cadastrando Veículo para este Cliente --");
            System.out.print("Placa: ");
            String placa = leitor.nextLine();

            System.out.print("Observações do Veículo: ");
            String obsVeiculo = leitor.nextLine();

            String nomeMarca = "";
            while (true) {
                System.out.print("Marca: ");
                nomeMarca = leitor.nextLine();
                if (nomeMarca.matches("[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÔÕÖÚÇÑ ]+")) {
                    break;
                } else {
                    System.out.println(">> Erro: A marca deve conter apenas letras e espaços.");
                }
            }
            Marca marca = new Marca(nomeMarca);

            String descModelo = "";
            while (true) {
                System.out.print("Descrição do Modelo: ");
                descModelo = leitor.nextLine();
                if (descModelo.matches("[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÔÕÖÚÇÑ ]+")) {
                    break;
                } else {
                    System.out.println(">> Erro: O modelo deve conter apenas letras e espaços.");
                }
            }

            String corNome = "";
            while (true) {
                System.out.print("Cor: ");
                corNome = leitor.nextLine();
                if (corNome.matches("[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÔÕÖÚÇÑ ]+")) {
                    break;
                } else {
                    System.out.println(">> Erro: A cor deve conter apenas letras e espaços.");
                }
            }
            Cor cor = new Cor(corNome);

            int potencia = 0;
            while (potencia <= 0) {
                System.out.print("Potência do Motor (cv): ");
                if (leitor.hasNextInt()) {
                    potencia = leitor.nextInt();
                    leitor.nextLine();
                    if (potencia <= 0) System.out.println(">> A potência deve ser maior que zero.");
                } else {
                    System.out.println(">> Erro: Digite um número para a potência.");
                    leitor.nextLine();
                }
            }

            Categoria categoria = selecionarCategoria(leitor);
            Combustivel combustivel = selecionarCombustivel(leitor);

            Modelo modelo = new Modelo(descModelo, marca, categoria, potencia, combustivel);
            Veiculo veiculo = new Veiculo(placa, modelo);
            veiculo.setCor(cor);
            veiculo.setObservacoes(obsVeiculo);

            cliente.add(veiculo);
            cliente.getPontuacao().adicionar(100);
            listaClientes.add(cliente);
        }

        System.out.println("\n=================================");
        System.out.println("Relatório IDados");
        System.out.println("=================================");
        LocalDate hoje = LocalDate.now();
        for (Cliente c : listaClientes) {
            String observacaoUnica = "Ao se cadastrar, você ganhou 100 pontos.";

            if (c instanceof PessoaFisica pf) {
                LocalDate dataNasc = pf.getDataNascimento();
                if (dataNasc != null &&
                        dataNasc.getDayOfMonth() == hoje.getDayOfMonth() &&
                        dataNasc.getMonthValue() == hoje.getMonthValue()) {
                    observacaoUnica += "\nParabéns pelo seu aniversário!!! Na próxima lavação você terá 10% de desconto.";
                }
            }

            imprimirInterfaceComObservacao(c, observacaoUnica);

            for (Veiculo v : c.getVeiculos()) {
                imprimirInterface(v);
            }
            System.out.println("=================================");
        }

        System.out.println("   RELATÓRIO SOBRECARREGADO (Cliente)");
        System.out.println("=================================");
        for (Cliente c : listaClientes) {
            imprimirCliente(c);
            System.out.println("---------------------------------");
        }

        leitor.close();
    }

    public static void imprimirInterface(IDados item) {
        System.out.println(item.getDados());
    }

    public static void imprimirInterfaceComObservacao(IDados item, String obs) {
        System.out.println(item.getDados(obs));
    }

    public static void imprimirCliente(Cliente cliente) {
        if (cliente instanceof PessoaFisica pf) {
            System.out.println("Cliente Física: " + pf.getNome() + " | CPF: " + pf.getCpf());
        } else if (cliente instanceof PessoaJuridica pj) {
            System.out.println("Cliente Jurídica: " + pj.getNome() + " | CNPJ: " + pj.getCnpj());
        }

        System.out.println("Celular: " + cliente.getCelular());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("Quantidade de Pontos: " + cliente.getPontuacao().saldo());
        System.out.println("Lista de Veículos:");
        for (Veiculo v : cliente.getVeiculos()) {
            System.out.println("  - Placa: " + v.getPlaca() + " | Modelo: " + v.getModelo().getDescricao());
        }
    }

    private static Categoria selecionarCategoria(Scanner leitor) {
        int opcao = 0;
        while (opcao < 1 || opcao > 5) {
            System.out.println("Selecione a Categoria (1-PEQUENO, 2-MEDIO, 3-GRANDE, 4-MOTO, 5-PADRAO):");
            if (leitor.hasNextInt()) {
                opcao = leitor.nextInt();
                leitor.nextLine();
                if (opcao < 1 || opcao > 5) System.out.println(">> Opção inválida!");
            } else {
                System.out.println(">> Erro: Digite um número.");
                leitor.nextLine();
            }
        }
        return switch (opcao) {
            case 1 -> Categoria.PEQUENO;
            case 2 -> Categoria.MEDIO;
            case 3 -> Categoria.GRANDE;
            case 4 -> Categoria.MOTO;
            default -> Categoria.PADRAO;
        };
    }

    private static Combustivel selecionarCombustivel(Scanner leitor) {
        int opcao = 0;
        while (opcao < 1 || opcao > 5) {
            System.out.println("Selecione o Combustível (1-GASOLINA, 2-ETANOL, 3-FLEX, 4-DIESEL, 5-GNV):");
            if (leitor.hasNextInt()) {
                opcao = leitor.nextInt();
                leitor.nextLine();
                if (opcao < 1 || opcao > 5) System.out.println(">> Opção inválida!");
            } else {
                System.out.println(">> Erro: Digite um número.");
                leitor.nextLine();
            }
        }
        return switch (opcao) {
            case 1 -> Combustivel.GASOLINA;
            case 2 -> Combustivel.ETANOL;
            case 3 -> Combustivel.FLEX;
            case 4 -> Combustivel.DIESEL;
            default -> Combustivel.GNV;
        };
    }
}