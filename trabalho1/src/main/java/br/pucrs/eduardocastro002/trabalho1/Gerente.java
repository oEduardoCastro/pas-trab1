package br.pucrs.eduardocastro002.trabalho1;

import java.util.List;
import java.util.Optional;

public class Gerente extends Atendente {

    public Gerente(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    public List<Automovel> consultarTodosAutomoveis(Frota frota) {
        return frota.getAutomoveis();
    }

    public List<Cliente> consultarTodosClientes(List<Cliente> clientes) {
        return clientes;
    }

    public List<Locacao> consultarTodasLocacoes(List<Locacao> locacoes) {
        return locacoes;
    }

    public boolean alterarStatusAutomovel(Frota frota, String id, boolean novoStatus) {
        Optional<Automovel> auto = frota.buscarPorId(id);
        if (auto.isPresent()) {
            auto.get().setDisponivel(novoStatus);
            return true;
        }
        return false;
    }
}
