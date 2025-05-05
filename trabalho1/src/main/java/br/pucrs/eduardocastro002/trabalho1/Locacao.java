package br.pucrs.eduardocastro002.trabalho1;

public class Locacao { 

    private String dataLocacao;
    private String dataDevolucao;
    private String codigoInterno;
    private String cpfCliente;
    private String codigoVeiculo;

    public Locacao(String dataLocacao, String dataDevolucao, String codigoInterno, String cpfCliente, String codigoVeiculo) {
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.codigoInterno = codigoInterno;
        this.cpfCliente = cpfCliente;
        this.codigoVeiculo = codigoVeiculo;
    }

    public String getDataLocacao() {
        return dataLocacao;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public String getCodigoVeiculo() {
        return codigoVeiculo;
    }
}
