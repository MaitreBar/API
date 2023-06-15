package maitre.API.Repository;

import maitre.API.Domain.Estabelecimento;
import maitre.API.Domain.Reserva;
import maitre.API.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    @Query("select r from Usuario u join Reserva r on :id = r.usuario.idUsuario")
    List<Reserva> findReservaByUsuarioId(Integer id);

    @Query("select e from Estabelecimento e join Reserva r on e.idEstabelecimento = r.estabelecimento.idEstabelecimento where r.usuario.idUsuario = :id")
    List<Estabelecimento> findEstabelecimentoWithReservaByUsuarioId(Integer id);

    @Query("select r from Estabelecimento e join Reserva r on :id = r.estabelecimento.idEstabelecimento")
    List<Reserva> findReservaByEstabelecimentoId(Integer id);

    @Query("select u from Usuario u join Reserva r on u.idUsuario = r.usuario.idUsuario where r.estabelecimento.idEstabelecimento = :id")
    List<Usuario> findUsuarioWithReservaByEstabelecimentoId(Integer id);
}
