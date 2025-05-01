package br.pucrs.eduardocastro002.trabalho1;

import java.util.*;
import org.springframework.http.*;
import org.springframework.stereotype.Component;

@Component
public class Frota {
    
    private List<Automovel> automovel;
    
    public Frota() {
        automovel = new ArrayList<>();
    
        automovel.add(new Automovel("0001", "AAA0000", "Astra", "Chevrolet", "Vermelho", 2020, 100.0, true));
        automovel.add(new Automovel("0002", "BBB1111", "Tracker", "Chevrolet", "Cinza", 2021, 150.0, true));
        automovel.add(new Automovel("0003", "CCC2222", "Corolla", "Toyota", "Prata", 2022, 200.0, true));       
        automovel.add(new Automovel("0004", "DDD3333", "Sentra", "Nissan", "Preto", 2024, 250.0, true));
        automovel.add(new Automovel("0005", "EEE4444", "T-Cross", "Volkswagen", "Preto", 2023, 150.0, true));
        automovel.add(new Automovel("0006", "FFF5555", "208", "Peugeot", "Vermelho", 2022, 130.0, true));
        automovel.add(new Automovel("0007", "GGG6666", "Renegade", "Jeep", "Preto", 2021, 100.0, true));
        automovel.add(new Automovel("0008", "HHH7777", "Yaris", "Toyota", "Branco", 2020, 120.0, true));
        automovel.add(new Automovel("0009", "III8888", "Onix", "Chevrolet", "Prata",  2023, 150.0, true));
        automovel.add(new Automovel("0010", "JJJ9999", "Creta", "Hyundai", "Azul", 2024, 200.0, true));
    }
    public List<Automovel> getAutomoveis() {
        return automovel;
    }

}
