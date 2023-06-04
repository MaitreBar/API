package maitre.API.Repository;

import maitre.API.Domain.Entidades.Assento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssentoRepository extends JpaRepository<Assento, Integer> {
    @Query("select e.assentos from Estabelecimento e where e.id = :id")
    List<Assento> findAssentoByEstabelecimentoId(Integer id);
}
