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
        LocalDate dtNasc =  LocalDate.of(2000,07, 12);
        Usuario usuario = new Usuario(1, "Mayla", "mayla@gmail.com", "40023689540",dtNasc,  "119789456123", "985624250", "abc123", "Pop, rock");
        usuario.setReservas(new ArrayList<>());

        return usuario;
    }

    public static CriacaoUsuarioDto criacaoUsuarioDto() {
        LocalDate dataNascimento = LocalDate.of(1990, 7, 9);
        return new CriacaoUsuarioDto("Alex", "alex@gmail.com", "2345678903-00", dataNascimento, "(11)987654321", "45789253-0", "123abc", "cerveja, rock");
    }


    public static List<Usuario> listarUsuario() {
        LocalDate dtNasc1 =  LocalDate.of(2002,07, 12);
        LocalDate dtNasc2 =  LocalDate.of(2001,07, 12);
        LocalDate dtNasc3 =  LocalDate.of(1999,07, 12);
        LocalDate dtNasc4 =  LocalDate.of(1998,07, 12);
        return List.of(
                new Usuario(2, "Mayla", "Mayla@gmail.com", "090845678932", dtNasc1, "3456789021", "123456789", "fasvjaj", "pop"),
                new Usuario(3, "Aline", "Aline@gmail.com", "098541234567", dtNasc2, "567893457", "123456788", "465767889", "mpb"),
                new Usuario(1, "Landim", "Landim@gmail.com", "1234567890", dtNasc3, "1234554321", "123456777", "123456", "rock"),
                new Usuario(4, "Maciel", "Maciel@gmail.com", "65432099812", dtNasc4, "123197854", "123456666", "1234", "pop")
        );
    }

}