package br.pucrs.eduardocastro002.trabalho1;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/acmerent")
public class AcmerentController {
    private Frota frota;

    @Autowired
    public AcmerentController(Frota frota) {
        this.frota = frota;
    }

    @GetMapping("/listaautomoveis")
    public List<Automovel> getAutomoveis() {
        return frota.getAutomoveis();
    }

    @GetMapping("/listaclientes")
    public List<Cliente> listarClientes() {
        return clientes;
    }

    @GetMapping("/listalocacoes")
    public List<Locacao> listarLocacoes() {
        return locacoes;
    }

    @GetMapping("/consultacliente")
    public ResponseEntity<Cliente> consultarCliente(@RequestParam int codigo) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCodigo() == codigo) {
                return ResponseEntity.ok(clientes.get(i));
            }
        }
        return ResponseEntity.notFound().build();
    }

}