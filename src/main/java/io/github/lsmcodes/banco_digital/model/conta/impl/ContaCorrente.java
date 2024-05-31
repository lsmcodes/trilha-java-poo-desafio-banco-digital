package io.github.lsmcodes.banco_digital.model.conta.impl;

import io.github.lsmcodes.banco_digital.model.cliente.Cliente;

public class ContaCorrente extends ContaImpl {

        public ContaCorrente(Cliente cliente) {
                super(cliente);
        }

        @Override
        public void exibirExtrato() {
                System.out.println("EXTRATO CONTA CORRENTE");
                super.exibirInformacoes();
        }

}