package br.pucrs.eduardocastro002.trabalho1;

import java.time.LocalDate;

public class NovaLocacao {
    private String numero;
    private LocalDate dataInicial;
    private int dias;
    private String codigoCliente;
    private String idAutomovel;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getIdAutomovel() {
        return idAutomovel;
    }

    public void setIdAutomovel(String idAutomovel) {
        this.idAutomovel = idAutomovel;
    }
}
