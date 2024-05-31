package io.github.lsmcodes.banco_digital.model.conta.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import io.github.lsmcodes.banco_digital.model.cliente.Cliente;
import io.github.lsmcodes.banco_digital.model.conta.Conta;
import io.github.lsmcodes.banco_digital.model.transacao.Transacao;
import lombok.Getter;

@Getter
public abstract class ContaImpl implements Conta {

        private final static int AGENCIA_PADRAO = 1;
        private static int SEQUENCIAL = 1;
        private List<Transacao> historico = new ArrayList<>();

        protected Cliente cliente;
        protected int agencia;
        protected int numero;
        protected double saldo;

        public ContaImpl(Cliente cliente) {
                this.cliente = cliente;
                this.agencia = AGENCIA_PADRAO;
                this.numero = SEQUENCIAL++;
        }

        @Override
        public void sacar(double valor) {
                if (saldo >= valor) {
                        saldo -= valor;
                        adicionarTransacaoAoHistorico("SAQU", valor);
                } else {
                        System.out.println("Não há saldo suficiente para o saque.");
                }
        }

        @Override
        public void depositar(double valor) {
                saldo += valor;
                adicionarTransacaoAoHistorico("DEPO", valor);
        }

        @Override
        public void transferir(double valor, Conta contaDestino) {
                if (saldo >= valor) {
                        this.sacar(valor);
                        contaDestino.depositar(valor);
                        adicionarTransacaoAoHistorico("TRAN", valor);
                } else {
                        System.out.println("Não há saldo suficiente para a transferência.");
                }
        }

        public void adicionarTransacaoAoHistorico(String acao, double valor) {
                Transacao novaTransacao = new Transacao(acao, valor);
                historico.add(novaTransacao);
        }

        public void exibirInformacoes() {
                System.out.println(LocalDate.now() + " AG:" + agencia + " N° CONTA:" + numero);
                System.out.println(cliente.getNome().toUpperCase());

                System.out.println("DATA             HISTÓRICO    VALOR");

                for (Transacao transacao : historico) {
                        System.out.println(
                                        transacao.getData() + "       " + transacao.getAcao() + "         R$"
                                                        + transacao.getValor());
                }
                System.out.println("-------------------------------------------");
                System.out.println("SALDO:                        R$" + saldo);
        }

}