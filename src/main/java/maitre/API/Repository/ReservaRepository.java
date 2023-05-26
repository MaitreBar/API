package maitre.API.Repository;

import maitre.API.Entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    @Query("select u.reservas from Usuario u where u.id = :id")
    List<Reserva> findReservaByUsuarioId(Integer id);
    @Query("select e.reservas from Estabelecimento e where e.id = :id")
    List<Reserva> findReservaByEstabelecimentoId(Integer id);
}
