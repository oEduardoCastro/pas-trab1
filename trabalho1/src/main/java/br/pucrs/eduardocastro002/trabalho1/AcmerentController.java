package br.pucrs.eduardocastro002.trabalho1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/acmerent")
public class AcmerentController {

    private final Frota frota;
    private final List<Cliente> clientes;
    private final List<Locacao> locacoes;

    private final Atendente atendente;
    private final Gerente gerente;

    @Autowired
    public AcmerentController(Frota frota) {
        this.frota = frota;
        this.locacoes = new ArrayList<>();

        // Criar clientes
        Cliente c1 = new Cliente("João Silva", "12345678900", "51999999999", "joao@email.com", "CL001");
        Cliente c2 = new Cliente("Maria Souza", "98765432100", "51888888888", "maria@email.com", "CL002");
        Cliente c3 = new Cliente("Carlos Lima", "45678912300", "51777777777", "carlos@email.com", "CL003");

        // Criar locações
        Locacao l1 = new Locacao(LocalDate.now().minusDays(10), LocalDate.now().minusDays(5), "LOC001", c1, frota.getAutomoveis().get(0));
        Locacao l2 = new Locacao(LocalDate.now().minusDays(8), LocalDate.now(), "LOC002", c2, frota.getAutomoveis().get(1));

        c1.adicionarLocacao(l1);
        c2.adicionarLocacao(l2);
        frota.getAutomoveis().get(0).setDisponivel(false);
        frota.getAutomoveis().get(1).setDisponivel(false);

        this.locacoes.add(l1);
        this.locacoes.add(l2);
        this.clientes = List.of(c1, c2, c3);

        this.atendente = new Atendente("Lucas", "lucas.atend", "123");
        this.gerente = new Gerente("Mariana", "mari.ger", "admin");
    }

    // ------------------- Endpoints do Atendente -------------------

    @GetMapping("/consultacliente")
    public ResponseEntity<Cliente> consultarCliente(@RequestParam String codigo) {
        Optional<Cliente> cliente = atendente.consultarCliente(clientes, codigo);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/validaautomovel")
    public boolean validaAutomovel(@RequestBody String id) {
        Optional<Automovel> auto = atendente.consultarAutomovel(frota, id);
        return auto.map(Automovel::isDisponivel).orElse(false);
    }

    @PostMapping("/atendimento/cadlocacao")
    public boolean cadastrarLocacao(@RequestBody NovaLocacao novaLocacao) {
        Optional<Automovel> autoOpt = atendente.consultarAutomovel(frota, novaLocacao.getIdAutomovel());
        if (autoOpt.isEmpty() || !autoOpt.get().isDisponivel()) return false;

        Optional<Cliente> clienteOpt = atendente.consultarCliente(clientes, novaLocacao.getCodigoCliente());
        if (clienteOpt.isEmpty()) return false;

        Locacao loc = new Locacao(
                novaLocacao.getDataInicial(),
                novaLocacao.getDataInicial().plusDays(novaLocacao.getDias()),
                novaLocacao.getNumero(),
                clienteOpt.get(),
                autoOpt.get()
        );

        autoOpt.get().setDisponivel(false);
        clienteOpt.get().adicionarLocacao(loc);
        locacoes.add(loc);
        return true;
    }

    @PostMapping("/atendimento/finalizalocacao")
    public boolean finalizarLocacao(@RequestBody String codigoLocacao) {
        return atendente.finalizarLocacao(locacoes, codigoLocacao);
    }

    // ------------------- Endpoints do Gerente -------------------

    @GetMapping("/listaautomoveis")
    public List<Automovel> listarAutomoveis() {
        return gerente.consultarTodosAutomoveis(frota);
    }

    @GetMapping("/listaclientes")
    public List<Cliente> listarClientes() {
        return gerente.consultarTodosClientes(clientes);
    }

    @GetMapping("/listalocacoes")
    public List<Locacao> listarLocacoes() {
        return gerente.consultarTodasLocacoes(locacoes);
    }

    @PostMapping("/atendimento/atualizaautomovel/{id}/estado/{status}")
    public ResponseEntity<Automovel> atualizarStatus(@PathVariable String id, @PathVariable boolean status) {
        boolean atualizado = gerente.alterarStatusAutomovel(frota, id, status);
        return atualizado
                ? ResponseEntity.ok(frota.buscarPorId(id).orElse(null))
                : ResponseEntity.notFound().build();
    }
}
