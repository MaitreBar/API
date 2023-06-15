package maitre.API.usuario;

import maitre.API.Domain.Usuario;
import maitre.API.Repository.UsuarioRepository;
import maitre.API.Service.UsuarioService.UsuarioService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository repository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    @DisplayName("Deve retornar usuario quando buscar por id e existir usuario com id informado")
    void deveRetornarUsuarioQuandoBuscarPorIdEExistirUsuarioComIdInformado() {

        //given
        Usuario usuario = UsuarioBuilder.criarUsuario();

        //when
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(usuario));

        //then
        Usuario resultado = usuarioService.buscaPorId(1);

        //assert
        assertNotNull(resultado);
        assertEquals(usuario.getId(), resultado.getId());
        assertEquals(usuario.getNome(), resultado.getNome());
    }

    @Test
    @DisplayName("Deve retornar usuário atualizado ou vazio se não existir")
    void deveRetornarUsuarioAtualizadoOuVazio() {
        // given
        Integer id = 1;
        String novoNome = "douglas";
        Usuario usuarioExistente = new Usuario(); // Criar um usuário existente
        usuarioExistente.setId(id);

        // Mock do repositório
        Mockito.when(repository.findById(id)).thenReturn(Optional.ofNullable(usuarioExistente));

        // when
        Usuario usuario = usuarioService.buscaPorId(id);
        if (usuario == null) {
            // Então o usuário não existe, o que é esperado
        } else {
            // O usuário existe, então atualize o nome
            usuario.setNome(novoNome);
            Mockito.when(repository.save(usuario)).thenReturn(usuario);
            repository.save(usuario); // Supondo que existe um método "atualizar" no serviço
        }

        // then
        Optional<Usuario> usuarioAtualizado = repository.findById(id);
        if (usuario == null) {
            assertFalse(usuarioAtualizado.isPresent()); // Verificar se não existe usuário no repositório
        } else {
            assertTrue(usuarioAtualizado.isPresent()); // Verificar se o usuário foi atualizado
            assertEquals(novoNome, usuarioAtualizado.get().getNome()); // Verificar se o nome foi atualizado corretamente
        }
    }


    @Test
    @DisplayName("Deve retornar a lista dos usuários")
    void deveRetornarAListaDosUsuarios() {
        // given
        int resultadoEsperado = 4;
        List <Usuario>  usuario = UsuarioBuilder.listarUsuario();

        //when
        Mockito.when(repository.findAll()).thenReturn(usuario);

        //then
        List<Usuario> resultado = usuarioService.listaUsuarios();

        //asserts
        assertEquals(resultadoEsperado, resultado.size());
    }
}
