package maitre.API.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import maitre.API.entidade.Usuario;
import maitre.API.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "API Maitre", description = "Grupo 2")

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> listaUsuarios(){
        List<Usuario> users = userRepository.findAll();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(
            @RequestBody @Valid Usuario newUsuario
    ){
        Usuario usuario = userRepository.save(newUsuario);
        return ResponseEntity.status(201).body(usuario);
    };
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Não ha usuarios cadastrados",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(responseCode = "200", description = "Usuarios encontrados")
    })

    @PutMapping("/{idUser}")
    public ResponseEntity<Usuario> atualizaUser(
            @PathVariable Long idUser,
            @RequestBody @Valid Usuario usuario
    ){
        usuario.setIdUser(idUser);
        if (this.userRepository.existsById(Long.valueOf(idUser))){
            Usuario usuarioAtualizado = this.userRepository.save(usuario);
            return ResponseEntity.status(200).body(usuarioAtualizado);
        }

        return null;
    }

    @PostMapping("/{email}/{senha}")
    public ResponseEntity<String> login(
            @PathVariable String nome,
            @PathVariable String senha
    ) {
        List<Usuario> usuario = userRepository.findAll();
        for (Usuario u : usuario){
            if (u.getNome().equals(nome) && u.getSenha().equals(senha)){
                System.out.printf("O usuario %s Logado com sucesso" , u);
                return ResponseEntity.status(200).build();
            }
        }
        return ResponseEntity.status(404).build();
    }

}
