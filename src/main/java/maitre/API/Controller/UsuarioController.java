package maitre.API.Controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import maitre.API.Entidades.Usuario;
import maitre.API.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Usuario", description = "Endpoints Usuario")

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
    public ResponseEntity<Usuario> buscaPorId(@PathVariable Integer id){
        Optional<Usuario> optUsuario = usuarioRepository.findById(id);
        if (optUsuario.isPresent()){
            return ResponseEntity.status(200).body(optUsuario.get());
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody @Valid Usuario user){
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
    public ResponseEntity<Usuario> atualizaUser(@PathVariable Integer id, @RequestBody @Valid Usuario usuario){
        usuario.setId(id);
        if (this.usuarioRepository.existsById(id)){
            Usuario usuarioAtualizado = this.usuarioRepository.save(usuario);
            return ResponseEntity.status(200).body(usuarioAtualizado);
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/{email}/{senha}")
    public ResponseEntity<String> login(@PathVariable String email, @PathVariable String senha) {
        List<Usuario> usuario = usuarioRepository.findAll();
        for (Usuario u : usuario){
            if (u.getEmail().equals(email) && u.getSenha().equals(senha)){
                System.out.printf("O usuario %s Logado com sucesso" , u.getNome());
                return ResponseEntity.status(200).build();
            }
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> logOff(){
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        if (this.usuarioRepository.existsById(id)){
            this.usuarioRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

}
