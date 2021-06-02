package br.com.lucasnunes.hotel.repositories;

import br.com.lucasnunes.hotel.model.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
public interface CheckInRepository extends JpaRepository<CheckIn, Integer> {

    @Query(value = "select * from check_in" +
            " inner join hospede on hospede.id = check_in.hospede_id" +
            " where hospede.nome like %?%1", nativeQuery = true)
    public List<CheckIn> findByNome(String nome);

    @Query(value = "select * from check_in" +
            " inner join hospede on hospede.id = check_in.hospede_id" +
            " where hospede.documento = ?1", nativeQuery = true)
    public List<CheckIn> findByDocumento(Integer documento);

    @Query(value = "select * from check_in" +
            " inner join hospede on hospede.id = check_in.hospede_id" +
            " where hospede.telefone = ?1", nativeQuery = true)
    public List<CheckIn> findByTelefone(Integer telefone);
}
