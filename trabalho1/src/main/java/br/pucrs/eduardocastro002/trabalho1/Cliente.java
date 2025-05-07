package br.pucrs.eduardocastro002.trabalho1;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String codigoInterno;
    private List<Locacao> locacoes = new ArrayList<>();

    public Cliente(String nome, String cpf, String telefone, String email, String codigo) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.codigoInterno = codigo;
        
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
    public String getCodigoInterno() {
        return codigoInterno;
    }
    public List<Locacao> adicionarLocacao(Locacao locacao) {
        return locacoes;
    }
}
