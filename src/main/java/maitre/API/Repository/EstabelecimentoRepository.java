package maitre.API.Repository;

import maitre.API.Domain.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Integer> {

    Estabelecimento findEstabelecimentoByIdEstabelecimento(Integer id);
    Estabelecimento findEstabelecimentoByCep(String cep);

}
