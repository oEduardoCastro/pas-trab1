package br.pucrs.eduardocastro002.trabalho1;

import java.util.*;
import org.springframework.http.*;
import org.springframework.stereotype.Component;

public class Automovel {
    
    private String placa;
    private String modelo;
    private String marca;
    private String cor;
    private int ano;
    private double valorDiaria;
    private boolean disponivel;

    public Automovel(String placa, String modelo, String marca, String cor, int ano, double valorDiaria, boolean disponivel) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.ano= ano;
        this.valorDiaria = valorDiaria;
        this.disponivel = disponivel;
    }

    public String getPlaca() {
        return placa;
    }
    public int getAno() {
        return ano;
    }   
    public double getValorDiaria() {
        return valorDiaria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}


