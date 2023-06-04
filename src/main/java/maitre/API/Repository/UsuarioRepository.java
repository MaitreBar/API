package maitre.API.Repository;

import maitre.API.Domain.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findUsuarioById(Integer id);

    Optional<Usuario> findUsuarioByEmail(String email);
}
