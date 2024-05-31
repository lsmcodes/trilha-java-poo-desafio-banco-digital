package io.github.lsmcodes.banco_digital.model.banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import io.github.lsmcodes.banco_digital.model.cliente.Cliente;
import io.github.lsmcodes.banco_digital.model.conta.Conta;
import io.github.lsmcodes.banco_digital.model.conta.impl.ContaCorrente;
import io.github.lsmcodes.banco_digital.model.conta.impl.ContaPoupanca;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Banco {

        private String nome;
        private List<Conta> contas;

        private static Scanner scanner = new Scanner(System.in);

        public Banco() {
                this.contas = new ArrayList<>();
        }

        public Conta encontrarConta() {
                System.out.println("Número da conta:");
                int numero = Integer.parseInt(scanner.nextLine());

                Conta conta = null;

                for (Conta contaAtual : contas) {
                        if (contaAtual.getNumero() == numero) {
                                conta = contaAtual;
                        }
                }

                return conta;
        }

        public static void main(String[] args) {

                Banco banco = new Banco();

                Scanner scanner = new Scanner(System.in);
                Cliente cliente = null;
                Conta conta = null;

                boolean mostrarMenu = true;

                while (mostrarMenu) {
                        System.out.println("\nMenu:\n"
                                        + "1 - Fazer cadastro\n"
                                        + "2 - Criar conta\n"
                                        + "3 - Fazer saque\n"
                                        + "4 - Fazer depósito\n"
                                        + "5 - Fazer transferência\n"
                                        + "6 - Exibir extrato\n"
                                        + "7 - Listar contas\n"
                                        + "Para sair, apenas digite qualquer outro número");

                        String opcao = scanner.nextLine();

                        switch (opcao) {
                                case "1":
                                        System.out.println("Nome do banco:");
                                        String nomeDoBanco = scanner.nextLine();
                                        banco.setNome(nomeDoBanco);

                                        System.out.println("Digite seu nome:");
                                        String nome = scanner.nextLine();

                                        cliente = new Cliente();
                                        cliente.setNome(nome);

                                        System.out.println("Cadastro completo.");
                                        break;
                                case "2":
                                        System.out.println("1 - Conta corrente\n"
                                                        + "2 - Conta poupança");
                                        String tipoDeConta = scanner.nextLine();

                                        if (tipoDeConta.equals("1")) {
                                                conta = new ContaCorrente(cliente);
                                        } else {
                                                conta = new ContaPoupanca(cliente);
                                        }
                                        System.out.println("Conta gerada.");
                                        banco.getContas().add(conta);
                                        break;
                                case "3":
                                        Conta contaParaSaque = banco.encontrarConta();

                                        if (contaParaSaque != null) {
                                                System.out.println("Valor de saque:");
                                                double valorDeSaque = Double.parseDouble(scanner.nextLine());

                                                contaParaSaque.sacar(valorDeSaque);
                                                System.out.println("Saque realizado com sucesso.");
                                        } else {
                                                System.out.println("Não há uma conta com esse número.");
                                        }
                                        break;
                                case "4":
                                        Conta contaParaDeposito = banco.encontrarConta();

                                        if (contaParaDeposito != null) {
                                                System.out.println("Valor de depósito:");
                                                double valorDeDeposito = Double.parseDouble(scanner.nextLine());

                                                contaParaDeposito.depositar(valorDeDeposito);
                                                System.out.println("Depósito realizado com sucesso.");
                                        } else {
                                                System.out.println("Não há uma conta com esse número.");
                                        }
                                        break;
                                case "5":
                                        System.out.println("Conta de origem");
                                        Conta contaDeOrigem = banco.encontrarConta();

                                        System.out.println("Conta de destino");
                                        Conta contaDeDestino = banco.encontrarConta();

                                        if (contaDeOrigem != null && contaDeDestino != null) {
                                                System.out.println("Valor de transferência:");
                                                double valorDeTransferencia = Double.parseDouble(scanner.nextLine());

                                                contaDeOrigem.transferir(valorDeTransferencia, contaDeDestino);
                                                System.out.println("Transferência realizada com sucesso.");
                                        } else {
                                                System.out.println("Não há uma conta com esse número.");
                                        }
                                        break;
                                case "6":
                                        Conta contaParaExibirExtrato = banco.encontrarConta();

                                        if (contaParaExibirExtrato != null) {
                                                System.out.println(banco.getNome().toUpperCase());
                                                contaParaExibirExtrato.exibirExtrato();
                                        } else {
                                                System.out.println("Não há uma conta com esse número.");
                                        }
                                        break;
                                case "7":
                                        for (Conta contaAtual : banco.contas) {
                                                System.out.println("Número: " + contaAtual.getNumero() + ", titular: "
                                                                + contaAtual.getCliente().getNome());
                                        }
                                        break;
                                default:
                                        mostrarMenu = false;
                                        break;
                        }

                }

                scanner.close();
        }

}