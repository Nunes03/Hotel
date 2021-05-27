package br.com.lucasnunes.hotel.resources;

import br.com.lucasnunes.hotel.model.Hospede;
import br.com.lucasnunes.hotel.services.HospedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class HospedeResource {

    @Autowired
    HospedeService hospedeService;

    @GetMapping("/hospedes")
    public ArrayList<Hospede> buscaTodosOsHospedes(){
        return hospedeService.buscarTodosOsHospedes();
    }

    @GetMapping("/hospedes/{id}")
    public Hospede buscaHospedePeloId(@PathVariable Integer id){
        return hospedeService.buscarHospedePeloId(id);
    }

    @PostMapping("/hospedes")
    public boolean inserirHospde(@RequestBody Hospede hospede){
        if(hospedeService.inserirHospede(hospede)){
            return true;
        }
        return false;
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
}