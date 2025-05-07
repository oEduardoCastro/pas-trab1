package br.pucrs.eduardocastro002.trabalho1;

import java.util.List;
import java.util.Optional;

public class Atendente {
    protected String nome;
    protected String login;
    protected String senha;

    public Atendente(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Optional<Cliente> consultarCliente(List<Cliente> clientes, String codigo) {
        return clientes.stream()
                .filter(c -> c.getCodigoInterno().equals(codigo))
                .findFirst();
    }

    public Optional<Automovel> consultarAutomovel(Frota frota, String id) {
        return frota.buscarPorId(id);
    }

    public boolean cadastrarLocacao(List<Locacao> locacoes, Locacao novaLocacao) {
        return locacoes.add(novaLocacao);
    }

    public boolean finalizarLocacao(List<Locacao> locacoes, String codigoInterno) {
        Optional<Locacao> loc = locacoes.stream()
                .filter(l -> l.getCodigoInterno().equals(codigoInterno))
                .findFirst();

        if (loc.isPresent()) {
            loc.get().getAutomovel().setDisponivel(true);
            return true;
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
}
