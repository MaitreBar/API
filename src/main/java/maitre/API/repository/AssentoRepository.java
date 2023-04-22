package maitre.API.repository;

import maitre.API.Entidades.Assento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssentoRepository extends JpaRepository<Assento, Integer> {

    Assento findAssentoById(Integer id);
}
