package br.com.lucasnunes.hotel.resources;

import br.com.lucasnunes.hotel.model.CheckIn;
import br.com.lucasnunes.hotel.services.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CheckInResorce {

    @Autowired
    CheckInService checkInService;

    @GetMapping("/check_in/all")
    public ArrayList<CheckIn> buscaTodosOsCheckIn(){
        return checkInService.buscarTodosOsCheckIn();
    }

    @GetMapping("/check_in/id/{id}")
    public CheckIn buscaCheckInPeloId(@PathVariable Integer id){
        return checkInService.buscarCheckInPeloId(id);
    }

    @PostMapping("/check_in")
    public Integer inserirCheckIn(@RequestBody CheckIn checkIn){
        if(checkInService.inserirCheckIn(checkIn)){
            return checkIn.getId();
        }
        return -1;
    }

    @DeleteMapping("/check_in/{id}")
    public boolean deletaCheckInPeloId(@PathVariable Integer id){
        if (checkInService.deletarCheckInPeloId(id)) {
            return true;
        }
        return false;
    }

    @PutMapping("/check_in/{id}")
    public boolean atualizarCheckInPeloId(@PathVariable Integer id, @RequestBody CheckIn checkIn){
        if (checkInService.atualizaCheckInPeloId(id, checkIn)) {
            return true;
        }
        return false;
    }

    @GetMapping("/check_in/nome")
    public ArrayList<CheckIn> buscarCheckInPorNomeHospede(@RequestParam String nome){
        return checkInService.buscarCheckInPorNomeHospede(nome);
    }

    @GetMapping("/check_in/documento")
    public ArrayList<CheckIn> buscarCheckInPorDocumentoHospede(@RequestParam Integer documento){
        return checkInService.buscarCheckInPorDocumentoHospede(documento);
    }

    @GetMapping("/check_in/telefone")
    public ArrayList<CheckIn> buscarCheckInPorTelefoneHospede(@RequestParam Integer telefone){
        return checkInService.buscarCheckInPorTelefoneHospede(telefone);
    }
}
