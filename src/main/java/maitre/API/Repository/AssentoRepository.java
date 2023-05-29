package maitre.API.Repository;

import maitre.API.Domain.Entidades.Assento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssentoRepository extends JpaRepository<Assento, Integer> {
    }
