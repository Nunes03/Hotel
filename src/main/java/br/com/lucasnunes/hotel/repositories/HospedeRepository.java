package br.com.lucasnunes.hotel.repositories;

import br.com.lucasnunes.hotel.model.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Integer> {

    @Query(value = "select hospede from Hospede hospede JOIN\n" +
            "CheckIn checkIn on hospede.id = checkIn.hospede.id\n" +
            "where ?1 > checkIn.dataSaida")
    public List<Hospede> buscarHospedeQueJaRealizaramCheckIn(LocalDateTime dataAtual);

    @Query(value = "select hospede from Hospede hospede JOIN\n" +
            "CheckIn checkIn on hospede.id = checkIn.hospede.id\n" +
            "where ?1 < checkIn.dataSaida")
    public List<Hospede> buscarHospedeQueNaoRealizaramCheckIn(LocalDateTime dataAtual);
}
