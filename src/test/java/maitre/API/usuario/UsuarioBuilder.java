package maitre.API.usuario;

import maitre.API.Domain.Usuario;
import maitre.API.Service.UsuarioService.dto.CriacaoUsuarioDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioBuilder {
    private UsuarioBuilder() {
        throw new IllegalStateException("Classe Utilitária");
    }

    public static Usuario criarUsuario() {
        Usuario usuario = new Usuario(1, "Mayla", "mayla@gmail.com", "40023689540", "119789456123", "985624250", "abc123");
        usuario.setReservas(new ArrayList<>());

        return usuario;
    }

    public static CriacaoUsuarioDto criacaoUsuarioDto() {
        LocalDate dataNascimento = LocalDate.of(1990, 7, 9);
        return new CriacaoUsuarioDto("Alex", "alex@gmail.com", "2345678903-00", dataNascimento, "(11)987654321", "45789253-0", "123abc", "cerveja, rock");
    }


    public static List<Usuario> listarUsuario() {
        return List.of(
                new Usuario(2, "Mayla", "Mayla@gmail.com", "090845678932", "923480987", "3456789021", "1234"),
                new Usuario(3, "Aline", "Aline@gmail.com", "098541234567", "923457896", "567893457", "8906"),
                new Usuario(1, "Landim", "Landim@gmail.com", "1234567890", "978653421", "1234554321", "1233"),
                new Usuario(4, "Maciel", "Maciel@gmail.com", "65432099812", "934566662", "123197854", "2165")
        );
    }

}