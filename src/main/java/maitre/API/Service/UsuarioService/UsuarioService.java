package maitre.API.Service.UsuarioService;

import maitre.API.Domain.Usuario;
import maitre.API.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<Usuario> listaUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        if(usuarios.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return usuarios;
    }

    public Usuario buscaPorId(Integer id){
        Optional<Usuario> optUsuario = usuarioRepository.findById(id);
        if (optUsuario.isPresent()){
            return optUsuario.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    public Usuario cadastrarUsuario(Usuario user){
        List<Usuario> usuarioList = usuarioRepository.findAll();
        for(Usuario u: usuarioList) {
            if (user.getEmail().equals(u.getEmail())) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
            } else {
                if (user.getCpf().equals(u.getCpf())) {
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
                } else {
                    if (user.getRg().equals(u.getRg())) {
                        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
                    } else {
                        Usuario usuario = usuarioRepository.save(user);
                        return usuario;
                    }
                }
            }
        }
        throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT);
    }

    public Usuario atualizaUser(Integer id, Usuario usuario){
        usuario.setId(id);
        usuario.setReservas(buscaPorId(id).getReservas());
        if (this.usuarioRepository.existsById(id)){
            Usuario usuarioAtualizado = this.usuarioRepository.save(usuario);
            return usuarioAtualizado;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Usuario login(String email, String senha) {
        List<Usuario> usuario = usuarioRepository.findAll();
        for (Usuario u : usuario){
            if (u.getEmail().equals(email) && u.getSenha().equals(senha)){
                System.out.printf("O usuario %s Logado com sucesso" , u.getNome());
                return u;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Void delete(Integer id){
        if (this.usuarioRepository.existsById(id)){
            this.usuarioRepository.deleteById(id);
            throw new ResponseStatusException(HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Integer buscarPosicaoUsuarioFilaPorId(Integer id) {
        List<Usuario> usuarios = usuarioRepository.findAllOrderByOrdemFila(id);

//        for (int i = 0; i < usuarios.size(); i++) {
//            if (usuarios.get(i).getId() == id)
//                return i + 1;
//        }

        return usuarios.indexOf(usuarios.stream().filter(usuario -> usuario.getId() == id))+1;

}

}

