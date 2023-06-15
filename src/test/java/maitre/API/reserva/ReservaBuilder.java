package maitre.API.reserva;

import maitre.API.Domain.Assento;
import maitre.API.Domain.Estabelecimento;
import maitre.API.Domain.Reserva;
import maitre.API.Domain.Usuario;
import maitre.API.Service.EstabelecimentoService.EstabelecimentoService;
import maitre.API.Service.ReservaService.dto.CriacaoReservaDto;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservaBuilder {

    private ReservaBuilder() { throw  new IllegalStateException("Classe Utilitária");}

    public static Reserva criarReserva(){
        LocalDate dtReserva = LocalDate.of(1956, 8, 7);
        Time hrReserva = Time.valueOf("12:45:56");
        Boolean checkIn = Boolean.FALSE;
        Boolean checkOut = Boolean.TRUE;
        LocalDateTime dtHoraCheckIn = LocalDateTime.of(2023, 06, 12, 11, 00, 00);
        LocalDateTime dtHoraCheckOut = LocalDateTime.of(2023, 06, 12, 12, 00, 00 );
        return new Reserva(1, dtReserva, hrReserva, checkIn, checkOut, dtHoraCheckIn , dtHoraCheckOut, "Muito bom!" );
    }

    public static Usuario criarUsuario() {
        return new Usuario(1, "Mayla", "Mayla@gmail.com", "40023689540", "119789456123", "985624250", "abc123");

    }
    public static CriacaoReservaDto criacaoReservaDto(){
        LocalDate dtReserva = LocalDate.of(1956, 8, 7);
        Time hrReserva = Time.valueOf("12:45:56");
        Boolean checkIn = Boolean.FALSE;
        Boolean checkOut = Boolean.TRUE;
        LocalDateTime dtHoraCheckIn = LocalDateTime.of(2023, 06, 12, 11, 00, 00);
        LocalDateTime dtHoraCheckOut = LocalDateTime.of(2023, 06, 12, 12, 00, 00 );
        List<Assento> assentos = new ArrayList<>();
        assentos.add(new Assento());
        Estabelecimento estabelecimento = new Estabelecimento();
        Usuario usuario = new Usuario();
        return new CriacaoReservaDto();
    }
    }

