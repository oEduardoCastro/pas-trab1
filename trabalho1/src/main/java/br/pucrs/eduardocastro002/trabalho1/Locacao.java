package br.pucrs.eduardocastro002.trabalho1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Locacao {

    private LocalDate dataLocacao;
    private LocalDate dataDevolucao;
    private String codigoInterno;
    private Cliente cliente;
    private Automovel automovel;

    public Locacao(LocalDate dataLocacao, LocalDate dataDevolucao, String codigoInterno, Cliente cliente, Automovel automovel) {
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.codigoInterno = codigoInterno;
        this.cliente = cliente;
        this.automovel = automovel;
    }

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public double calculaValorLocacao() {
        long dias = ChronoUnit.DAYS.between(dataLocacao, dataDevolucao);
        if (dias <= 0) {
            dias = 1; // Garantir ao menos 1 diária
        }

        double valorTotal = dias * automovel.getValorDiaria();

        if (dias > 7) {
            valorTotal *= 0.95; // 5% de desconto
        }

        return valorTotal;
    }
}
