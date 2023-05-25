package maitre.API.Repository;

import maitre.API.Entidades.Assento;
import maitre.API.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssentoRepository extends JpaRepository<Assento, Integer> {

    Assento findAssentoById(Integer id);
}
