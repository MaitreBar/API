package maitre.API.Repository;

import maitre.API.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findUsuarioById(Integer id);
}