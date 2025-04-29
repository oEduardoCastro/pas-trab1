package br.pucrs.eduardocastro002.trabalho1;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class AcmerentController {

    @GetMapping("/")
    public String getMensagemInicial() {
    return "Aplicacao Spring-Boot funcionando!";
    }

}