package br.com.lucasnunes.hotel.resources;

import br.com.lucasnunes.hotel.model.Hospede;
import br.com.lucasnunes.hotel.services.HospedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;

@RestController
public class HospedeResource {

    @Autowired
    HospedeService hospedeService;

    @GetMapping("/hospedes/all")
    public ArrayList<Hospede> buscaTodosOsHospedes(){
        return hospedeService.buscarTodosOsHospedes();
    }

    @GetMapping("/hospedes/id/{id}")
    public Hospede buscaHospedePeloId(@PathVariable Integer id){
        return hospedeService.buscarHospedePeloId(id);
    }

    @PostMapping("/hospedes")
    public Integer inserirHospde(@RequestBody Hospede hospede){
        if(hospedeService.inserirHospede(hospede)){
            return hospede.getId();
        }
        return -1;
    }

    @DeleteMapping("/hospedes/{id}")
    public boolean deletaHospedePeloId(@PathVariable Integer id){
        if (hospedeService.deletarHospedePeloId(id)) {
            return true;
        }
        return false;
    }

    @PutMapping("/hospedes/{id}")
    public boolean atualizarHospedePeloId(@PathVariable Integer id, @RequestBody Hospede hospede){
        if (hospedeService.atualizaHospedePeloId(id, hospede)) {
            return true;
        }
        return false;
    }

    @GetMapping("/hospedes/off")
    public ArrayList<Hospede> buscarHospedeQueJaRealizaramCheckIn(){
        LocalDateTime dataAtual = LocalDateTime.now();
        return hospedeService.buscarHospedeQueJaRealizaramCheckIn(dataAtual);
    }

    @GetMapping("/hospedes/on")
    public ArrayList<Hospede> buscarHospedeQueNaoRealizaramCheckIn(){
        LocalDateTime dataAtual = LocalDateTime.now();
        return hospedeService.buscarHospedeQueNaoRealizaramCheckIn(dataAtual);
    }
}