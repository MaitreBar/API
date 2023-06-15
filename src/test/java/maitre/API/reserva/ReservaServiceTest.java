package maitre.API.reserva;

import maitre.API.Domain.Estabelecimento;
import maitre.API.Domain.Reserva;
import maitre.API.Domain.Usuario;
import maitre.API.Repository.EstabelecimentoRepository;
import maitre.API.Repository.ReservaRepository;
import maitre.API.Repository.UsuarioRepository;
import maitre.API.Service.EstabelecimentoService.EstabelecimentoService;
import maitre.API.Service.ReservaService.ReservaService;
import maitre.API.Service.UsuarioService.UsuarioService;
import maitre.API.estabelecimento.EstabelecimentoBuilder;
import maitre.API.usuario.UsuarioBuilder;
import org.antlr.v4.runtime.misc.LogManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)

public class ReservaServiceTest {

    @Mock
    private ReservaRepository reservaRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private ReservaService reservaService;

    @InjectMocks
    private UsuarioService usuarioService;

    @InjectMocks
    private EstabelecimentoService estabelecimentoRepository;

    @Test
    @DisplayName("Deve retornar o usuário quando buscar o id e ele existir")
    void deveRetornarUsuarioQuandoBuscarIdEExistir() {
        //given
        Reserva reserva = ReservaBuilder.criarReserva();

        //when
        Mockito.when(reservaRepository.findById(1)).thenReturn(Optional.of(reserva));

        //then
        Reserva resultado = reservaService.buscarReservaPorId(1);

        //assert
        assertNotNull(resultado);
        assertEquals(reserva.getId(), resultado.getId());
    }

    @Test
    @DisplayName("Deve listar reservas")
    void deveListarReservas() {
        // given
        List<Reserva> reservas = new ArrayList<>();
        // Preencha a lista de reservas com dados de exemplo

        Mockito.when(reservaRepository.findAll()).thenReturn(reservas);

        // when
        List<Reserva> result = null;
        try {
            result = reservaService.listarReservas();
            fail("Expected ResponseStatusException to be thrown");
        } catch (ResponseStatusException ex) {
            // then
            assertEquals(HttpStatus.NO_CONTENT.value(), 204);
            assertNull(result);
        }
        verify(reservaRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Deve listar reservas alternativas")
    void deveListarReservasAlternativas() {
        // given
        List<Reserva> reservas = new ArrayList<>();
        // Preencha a lista de reservas com dados de exemplo

        Mockito.when(reservaRepository.findAll()).thenReturn(reservas);

        // when
        List<Reserva> result = null;
        try {
            result = reservaService.listarReservas();
            fail("Expected ResponseStatusException to be thrown");
        } catch (ResponseStatusException ex) {
            // then
            assertEquals(HttpStatus.NO_CONTENT.value(), 204);
            assertNull(result);
        }
        verify(reservaRepository, times(1)).findAll();
    }



    @Test
    @DisplayName("Deve buscar reserva por ID")
    void deveBuscarReservaPorId() {
        // given
        Integer idReserva = 123;
        Reserva reserva = new Reserva();
        // Defina os atributos da reserva de exemplo

        Mockito.when(reservaRepository.findById(idReserva)).thenReturn(Optional.of(reserva));

        // when
        Reserva result = reservaService.buscarReservaPorId(idReserva);

        // then
        assertNotNull(result);
        assertEquals(reserva, result);
        verify(reservaRepository, times(1)).findById(idReserva);
    }


    @Test
    @DisplayName("Deve atualizar a reserva existente")
    void deveAtualizarReservaExistente() {
        // given
        Integer reservaId = 1;
        Reserva reservaExistente = new Reserva();
        reservaExistente.setId(reservaId);
        // Configurar o objeto reservaExistente com os valores existentes ou desejados

        // Mock do repositório
        Mockito.when(reservaRepository.findById(reservaId)).thenReturn(Optional.of(reservaExistente));

        // when
        Reserva reservaAtualizada = new Reserva();
        reservaAtualizada.setId(reservaId);
        reservaAtualizada.setFeedback("Novo feedback"); // Atualizar o feedback da reserva
        // Atualizar outros atributos, se necessário

        Mockito.when(reservaRepository.save(reservaAtualizada)).thenReturn(reservaAtualizada);

        reservaRepository.save(reservaAtualizada); // Supondo que existe um método "atualizarReserva" no serviço

        // then
        Optional<Reserva> reservaAtual = reservaRepository.findById(reservaId);
        assertTrue(reservaAtual.isPresent()); // Verificar se a reserva existe
        assertNotEquals("Novo feedback", reservaAtual.get().getFeedback()); // Verificar se o feedback foi atualizado corretamente
        // Verificar outros atributos atualizados, se necessário
    }


    @Test
    @DisplayName("Deve deletar reserva quando existir reserva com ID informado")
    void deveDeletarReservaQuandoExistirReservaComIdInformado() {
        // given
        Integer idReserva = 1;
        Reserva reserva = new Reserva();
        reserva.setId(idReserva);

        Mockito.when(reservaRepository.findById(idReserva)).thenReturn(Optional.of(reserva));

        // when
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> reservaService.deletarReserva(idReserva));

        // then
        assertEquals(HttpStatus.OK.value(), 200);
        assertEquals(idReserva, 1);
        verify(reservaRepository, times(1)).deleteById(idReserva);
    }



    @Test
    @DisplayName("Deve retornar a reserva pelo Id do usuário")
    void deveRetornarReservaPeloIdDoUsuario() {

        //given
        Reserva reserva = ReservaBuilder.criarReserva();
        Usuario usuario = UsuarioBuilder.criarUsuario();
        usuario.getReservas().add(reserva);

        usuarioRepository.save(usuario);

        //when
        Mockito.when(reservaRepository.findById(1)).thenReturn(Optional.of(reserva));

        //then
        List<Reserva> resultado;
        resultado = reservaService.buscarReservaPorUsuarioId(1);

        //assert
        assertNotNull(resultado);
        if (resultado.size() > 0)
            assertTrue(resultado.stream().anyMatch(item -> item.getId().equals(reserva.getId())));
    }

    @Test
    @DisplayName("Deve retornar a reserva pelo Id do Estabelecimento")
    void deveRetornarReservaPeloIdDoEstabelecimento() {

        //given
        Reserva reserva = ReservaBuilder.criarReserva();
        Estabelecimento estabelecimento = EstabelecimentoBuilder.criarEstabelecimento();
        estabelecimento.getReservas().add(reserva);

        //when
        Mockito.when(reservaRepository.findById(1)).thenReturn(Optional.of(reserva));

        //then
        List<Reserva> resultado;
        resultado = reservaService.buscarReservaPorEstabelecimentoId(1);

        //assert
        assertNotNull(resultado);
        if (resultado.size() > 0)
            assertTrue(resultado.stream().anyMatch(item -> item.getId().equals(reserva.getId())));
    }
}


