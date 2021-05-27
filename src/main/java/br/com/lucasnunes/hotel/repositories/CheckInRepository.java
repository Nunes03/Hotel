package br.com.lucasnunes.hotel.repositories;

import br.com.lucasnunes.hotel.model.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckInRepository extends JpaRepository<CheckIn, Integer> {
}
