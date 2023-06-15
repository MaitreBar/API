package maitre.API.FIla;

import maitre.API.Controller.ReservaController;
import maitre.API.Domain.Usuario;
import maitre.API.Repository.UsuarioRepository;
import maitre.API.Service.ReservaService.ReservaService;
import maitre.API.Service.UsuarioService.UsuarioService;
import maitre.API.Service.UsuarioService.dto.FilaUsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fila")
@CrossOrigin("http://localhost:3000/")
public class FilaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private UsuarioService usuarioService;



    FilaObj<Usuario> fila = new FilaObj(10);

    @PostMapping("/{id}")
    public ResponseEntity<String> adicionaAFila(@PathVariable Integer id){
        Usuario usuario = usuarioService.buscaPorId(id);
//        FilaUsuarioDto filaUsuarioDto = usuarioService.buscaPorId()

        try {
            fila.insert(usuario);
        } catch (IllegalStateException erro) {
            return ResponseEntity.badRequest().body(erro.getMessage());
        }
        usuarioService.listaUsuarios();
//        reservaService.atualizaReserva(1,);

        return ResponseEntity.ok("Usuário adicionado à fila");
    }

    @GetMapping("/remover-usuario")
    public ResponseEntity<Usuario> removerUsuario() {
        if (fila.isEmpty()) {
            return ResponseEntity.ok(null);
        }

        Usuario usuarioRemovido = fila.poll();
        return ResponseEntity.ok(usuarioRemovido);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getFila() {
        List<Usuario> listaFila = fila.toList();
        return ResponseEntity.ok(listaFila);
    }

    @GetMapping("/posicao/{id}")
    public ResponseEntity<Integer> obterPosicaoNaFila(@PathVariable Integer id) {
        List<Usuario> listaFila = fila.toList();

        for (int i = 0; i < listaFila.size(); i++) {
            if (listaFila.get(i).getId().equals(id)) {
                return ResponseEntity.ok(i);
            }
        }

        return ResponseEntity.notFound().build();
    }
}
