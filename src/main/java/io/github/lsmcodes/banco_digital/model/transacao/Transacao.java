package io.github.lsmcodes.banco_digital.model.transacao;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class Transacao {

        private LocalDate data = LocalDate.now();
        private String acao;
        private double valor;

        public Transacao(String acao, double valor) {
                this.acao = acao;
                this.valor = valor;
        }

}