package maitre.API.Repository;

import maitre.API.Entidades.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Integer> {

    Estabelecimento findEstabelecimentoById(Integer id);
    Estabelecimento findEstabelecimentoByCep(String cep);
    Estabelecimento findEstabelecimentoByTipoBebida(String tipoBebida);
    Estabelecimento findEstabelecimentoByTipoMusica(String tipoMusica);
    Estabelecimento findEstabelecimentoByTipoComida(String tipoComida);

}
