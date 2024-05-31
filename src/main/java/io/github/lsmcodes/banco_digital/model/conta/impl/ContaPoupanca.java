package io.github.lsmcodes.banco_digital.model.conta.impl;

import io.github.lsmcodes.banco_digital.model.cliente.Cliente;

public class ContaPoupanca extends ContaImpl {

        public ContaPoupanca(Cliente cliente) {
                super(cliente);
        }

        @Override
        public void exibirExtrato() {
                System.out.println("EXTRATO CONTA POUPANÇA");
                super.exibirInformacoes();
        }

}