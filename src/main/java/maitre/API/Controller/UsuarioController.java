package maitre.API.Controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import maitre.API.Domain.Usuario;
import maitre.API.Service.UsuarioService.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Usuario", description = "Endpoints Usuario")

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("http://localhost:3000/")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listaUsuarios(){
        List<Usuario> usuarios = usuarioService.listaUsuarios();
        return ResponseEntity.status(200).body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscaPorId(@PathVariable Integer id){
        Usuario usuario = usuarioService.buscaPorId(id);
        return ResponseEntity.status(200).body(usuario);
    }


    @ApiResponses({
            @ApiResponse(responseCode = "401", description = "Email e/ou CPF e/ou RG já existentes em nossa base de dados"),
            @ApiResponse(responseCode = "400", description = "Email e/ou CPF e/ou RG já existentes em nossa base de dados"),
            @ApiResponse(responseCode = "201", description = "Usuários cadastrado"),
            @ApiResponse(responseCode = "418", description = "EU SOU UMA XÍCARA DE CHÁ")
    })
    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody @Valid Usuario user){
        Usuario usuario = usuarioService.cadastrarUsuario(user);
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
            Usuario usuarioAtualizado = usuarioService.atualizaUser(id, usuario);
            return ResponseEntity.status(200).body(usuarioAtualizado);
    }

    @GetMapping("/{email}/{senha}")
    public ResponseEntity<Usuario> login(@PathVariable String email, @PathVariable String senha) {
        Usuario usuario = usuarioService.login(email, senha);
        return ResponseEntity.status(200).body(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
            usuarioService.delete(id);
            return ResponseEntity.status(200).build();
    }

}
