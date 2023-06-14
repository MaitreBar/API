package maitre.API.Repository;

import maitre.API.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findUsuarioById(Integer id);

    Optional<Usuario> findUsuarioByEmail(String email);

    @Query("SELECT r FROM Reserva r JOIN Usuario u ON u.id = r.id ORDER BY r.horaReserva ASC")
    List<Usuario> findAllOrderByOrdemFila(Integer id);
}
