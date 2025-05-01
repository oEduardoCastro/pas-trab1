package br.pucrs.eduardocastro002.trabalho1;

import java.util.*;
import org.springframework.http.*;
import org.springframework.stereotype.Component;

@Component
public class Frota {
    
    private List<Automovel> automovel;
    
    public Frota() {
        automovel = new ArrayList<>();
    
        automovel.add(new Automovel("AAA0000", "Astra", "Chevrolet", "Vermelho", 2020, 100.0, true));
        automovel.add(new Automovel("BBB1111", "Tracker", "Chevrolet", "Cinza", 2021, 150.0, true));
        automovel.add(new Automovel("CCC2222", "Corolla", "Toyota", "Prata", 2022, 200.0, true));       
        automovel.add(new Automovel("DDD3333", "Sentra", "Nissan", "Preto", 2024, 250.0, false));
        automovel.add(new Automovel("EEE4444", "T-Cross", "Volkswagen", "Preto", 2023, 150.0, true));
        automovel.add(new Automovel("FFF5555", "208", "Peugeot", "Vermelho", 2022, 130.0, true));
        automovel.add(new Automovel("GGG6666", "Renegade", "Jeep", "Preto", 2021, 100.0, false));
        automovel.add(new Automovel("HHH7777", "Yaris", "Toyota", "Branco", 2020, 120.0, true));
        automovel.add(new Automovel("III8888", "Onix", "Chevrolet", "Prata",  2023, 150.0, true));
        automovel.add(new Automovel("JJJ9999", "Creta", "Hyundai", "Azul", 2024, 200.0, false));
    }
    public List<Automovel> getAutomoveis() {
        return automovel;
    }

}
