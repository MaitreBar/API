package maitre.api.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import maitre.api.Entidades.Usuario;
import maitre.api.repository.EstabelecimentoRepository;
import maitre.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> listaUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        if(usuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(usuarios);
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
                    description = "Não ha filmes cadastrados",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(responseCode = "200", description = "Filmes encontrados")
    })

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizaUser(
            @PathVariable Long id,
            @RequestBody @Valid Usuario usuario
    ){
        usuario.setId(id);
        if (this.usuarioRepository.existsById(Long.valueOf(id))){
            Usuario usuarioAtualizado = this.usuarioRepository.save(usuario);
            return ResponseEntity.status(200).body(usuarioAtualizado);
        }

        return null;
    }

    @PostMapping("/{email}/{senha}")
    public ResponseEntity<String> login(
            @PathVariable String nome,
            @PathVariable String senha
    ) {
        List<Usuario> usuario = usuarioRepository.findAll();
        for (Usuario u : usuario){
            if (u.getNome().equals(nome) && u.getSenha().equals(senha)){
                System.out.printf("O usuario %s Logado com sucesso" , u);
                return ResponseEntity.status(200).build();
            }
        }
        return ResponseEntity.status(404).build();
    }
}
