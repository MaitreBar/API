package maitre.API.Controller;

import maitre.API.Interface.UserRepository;
import maitre.API.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PutMapping
    public ResponseEntity<User> cadastrarUsuario(@RequestBody @Valid User newUser){
        User usuario = userRepository.save(newUser);
        return ResponseEntity.status(201).body(usuario);
    };
}
