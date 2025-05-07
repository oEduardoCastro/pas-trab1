package br.pucrs.eduardocastro002.trabalho1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Locacao {

    private LocalDate dataLocacao;
    private LocalDate dataDevolucao;
    private String codigoLocacao;
    private Cliente cliente;
    private Automovel automovel;
    private double valorTotal;

    public Locacao(LocalDate dataLocacao, LocalDate dataDevolucao, String codigoLocacao, Cliente cliente, Automovel automovel) {
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.codigoLocacao = codigoLocacao;
        this.cliente = cliente;
        this.automovel = automovel;
        this.valorTotal = calcularValorTotal();
    }

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public String getCodigoLocacao() {
        return codigoLocacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Automovel getAutomovel() {
        return automovel;
    }
    public double getValorTotal() {
        return valorTotal;
    }

    public double calcularValorTotal() {
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
