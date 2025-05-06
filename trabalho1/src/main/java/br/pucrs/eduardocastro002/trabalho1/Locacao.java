package br.pucrs.eduardocastro002.trabalho1;

import java.time.LocalDate;
import java.time.Period;

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

    public Automovel getVeiculo() {
        return automovel;
    }

    public double calculaValorLocacao(double valorDiaria) {
        Period tempoDeLocacao = Period.between(dataLocacao, dataDevolucao);
        int dias = tempoDeLocacao.getDays();
        valorTotal = dias * valorDiaria;
        
        if (dias > 7){
            double desconto = valorTotal * 0.95;
            return desconto;
        } else {
            return valorTotal;
        }
    }
}
