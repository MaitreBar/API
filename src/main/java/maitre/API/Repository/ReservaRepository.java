package maitre.API.Repository;

import maitre.API.Domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    @Query("select r from Usuario u join Reserva r on u.idUsuario = r.usuario.idUsuario")
    List<Reserva> findReservaByUsuarioId(Integer id);
    @Query("select r from Estabelecimento e join Reserva r on e.idEstabelecimento = r.estabelecimento.idEstabelecimento")
    List<Reserva> findReservaByEstabelecimentoId(Integer id);
}
