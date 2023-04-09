package maitre.API.repositorio;

import maitre.API.entidade.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
