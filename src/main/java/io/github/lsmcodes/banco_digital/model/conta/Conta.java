package io.github.lsmcodes.banco_digital.model.conta;

import io.github.lsmcodes.banco_digital.model.cliente.Cliente;

public interface Conta {

        Cliente getCliente();

        int getNumero();

        void sacar(double valor);

        void depositar(double valor);

        void transferir(double valor, Conta contaDestino);

        void exibirExtrato();

}