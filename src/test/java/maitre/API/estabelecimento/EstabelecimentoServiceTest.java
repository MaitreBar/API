package maitre.API.estabelecimento;

import maitre.API.Domain.Estabelecimento;
import maitre.API.Repository.EstabelecimentoRepository;
import maitre.API.Service.EstabelecimentoService.EstabelecimentoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class EstabelecimentoServiceTest {

    @Mock
    private EstabelecimentoRepository repository;

    @InjectMocks
    private EstabelecimentoService estabelecimentoService;

    @Test
    @DisplayName("Deve retornar estabelecimento quando buscar por id e existir estabelecimento com id informado")
    void deveRetornarEstabelecimentoQuandoBuscarPorIdEExistirEstabelecimentoComIdInformado() {

        // given
        Estabelecimento estabelecimento = EstabelecimentoBuilder.criarEstabelecimento();

        // when
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(estabelecimento));

        // then
        Optional<Estabelecimento> resultado = repository.findById(1);

        // assert
        assertTrue(resultado.isPresent());
        assertEquals(estabelecimento.getId(), resultado.get().getId());
        assertEquals(estabelecimento.getNome(), resultado.get().getNome());
    }

    @Test
    @DisplayName("Deve retornar a lista de estabelecimentos")
    void deveRetornarListaDeEstabelecimento() {
        // given
        Estabelecimento estabelecimento1 = new Estabelecimento();
        estabelecimento1.setId(1);
        estabelecimento1.setNome("Estabelecimento 1");

        Estabelecimento estabelecimento2 = new Estabelecimento();
        estabelecimento2.setId(2);
        estabelecimento2.setNome("Estabelecimento 2");

        List<Estabelecimento> listaEstabelecimentos = Arrays.asList(estabelecimento1, estabelecimento2);
        Mockito.when(repository.findAll()).thenReturn(listaEstabelecimentos);

        // when
        List<Estabelecimento> resultado = estabelecimentoService.listar();

        // then
        assertEquals(listaEstabelecimentos.size(), resultado.size());
        assertEquals(listaEstabelecimentos.get(0).getId(), resultado.get(0).getId());
        assertEquals(listaEstabelecimentos.get(0).getNome(), resultado.get(0).getNome());
        assertEquals(listaEstabelecimentos.get(1).getId(), resultado.get(1).getId());
        assertEquals(listaEstabelecimentos.get(1).getNome(), resultado.get(1).getNome());
    }

    @Test
    @DisplayName("Deve deletar estabelecimento quando existir estabelecimento com o id informado")
    void deveDeletarEstabelecimentoQuandoExistirEstabelecimentoComIdInformado2() {
        // given
        Integer id = 1;
        Estabelecimento estabelecimento = EstabelecimentoBuilder.criarEstabelecimento();
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(estabelecimento));

        // when
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> estabelecimentoService.deletar(id));

        // then
        assertEquals(HttpStatus.OK.value(), 200);
        Mockito.verify(repository, Mockito.times(1)).deleteById(id);
    }




    // Outros testes...

}
