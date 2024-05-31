package io.github.lsmcodes.banco_digital.model.acao;

import java.time.LocalDate;

public class Acao {

        private LocalDate data = LocalDate.now();
        private String acao;
        private double valor;

        public Acao(String acao, double valor) {
                this.acao = acao;
                this.valor = valor;
        }

        public LocalDate getData() {
                return data;
        }

        public String getAcao() {
                return acao;
        }

        public double getValor() {
                return valor;
        }

}