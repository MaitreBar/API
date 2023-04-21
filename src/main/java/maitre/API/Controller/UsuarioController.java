package maitre.API.Controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import maitre.API.Entidades.Usuario;
import maitre.API.repository.EstabelecimentoRepository;
import maitre.API.repository.UsuarioRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> listaUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        if(usuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscaPorId(
            @PathVariable Integer id){
//        List<Usuario> usuarios = usuarioRepository.findAll();
        if (this.usuarioRepository.existsById(id)){
            return ResponseEntity.of(this.usuarioRepository.findById(id));
        }
        return ResponseEntity.status(404).build();
//        return ResponseEntity.of(this.usuarioRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(
            @RequestBody @Valid Usuario user
    ){
        Usuario usuario = usuarioRepository.save(user);
        return ResponseEntity.status(201).body(usuario);
    }

    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Não há usuários cadastrados",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(responseCode = "200", description = "Usuários encontrados")
    })

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizaUser(
            @PathVariable Integer id,
            @RequestBody @Valid Usuario usuario
    ){
        usuario.setId(id);
        if (this.usuarioRepository.existsById(id)){
            Usuario usuarioAtualizado = this.usuarioRepository.save(usuario);
            return ResponseEntity.status(200).body(usuarioAtualizado);
        }

        return ResponseEntity.status(404).build();
    }

    @PostMapping("/{email}/{senha}")
    public ResponseEntity<String> login(
            @PathVariable String email,
            @PathVariable String senha
    ) {
        List<Usuario> usuario = usuarioRepository.findAll();
        for (Usuario u : usuario){
            if (u.getEmail().equals(email) && u.getSenha().equals(senha)){
                System.out.printf("O usuario %s Logado com sucesso" , u);
                return ResponseEntity.status(200).build();
            }
        }
        return ResponseEntity.status(404).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer id
    ){
        if (this.usuarioRepository.existsById(id)){
            this.usuarioRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

}
