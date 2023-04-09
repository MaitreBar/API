package maitre.API.controller;

import maitre.API.repositorio.UserRepository;
import maitre.API.entidade.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> listaUsuarios(){
        List<User> users = userRepository.findAll();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping
    public ResponseEntity<User> cadastrarUsuario(
            @RequestBody @Valid User newUser
    ){
        User usuario = userRepository.save(newUser);
        return ResponseEntity.status(201).body(usuario);
    };

    @PutMapping("/{idUser}")
    public ResponseEntity<User> atualizaUser(
            @PathVariable int idUser,
            @RequestBody @Valid User user
    ){
        user.setIdUser(idUser);
        if (this.userRepository.existsById(String.valueOf(idUser))){
            User usuarioAtualizado = this.userRepository.save(user);
            return ResponseEntity.status(200).body(usuarioAtualizado);
        }

        return null;
    }

    @PostMapping("/{email}/{senha}")
    public ResponseEntity<String> login(
            @PathVariable String nome,
            @PathVariable String senha
    ) {
        List<User> usuario = userRepository.findAll();
        for (User u : usuario){
            if (u.getNome().equals(nome) && u.getSenha().equals(senha)){
                System.out.printf("O usuario %s Logado com sucesso" , u);
                return ResponseEntity.status(200).build();
            }
        }
        return ResponseEntity.status(404).build();
    }
}
