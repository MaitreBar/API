package maitre.API.Service.Dto.ReservaService;

import maitre.API.Domain.Entidades.Reserva;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ReservaMapper {

    public static Reserva of(CriacaoReservaDto criacaoReservaDto) {
        Reserva reserva = new Reserva();

        reserva.setDtReserva(LocalDate.from(criacaoReservaDto.getDtReserva()));
        reserva.setHoraReserva(LocalTime.from(criacaoReservaDto.getHoraReserva()));
        reserva.setDtHoraCheckIn(criacaoReservaDto.getDtHoraCheckIn());
        reserva.setDtHoraCheckOut(criacaoReservaDto.getDtHoraCheckOut());
        reserva.setEstabelecimento(criacaoReservaDto.getEstabelecimento());
        reserva.setUsuario(criacaoReservaDto.getUsuario());
        reserva.setAssentos(criacaoReservaDto.getAssentos());

        return reserva;
    }

    public static CriacaoReservaDto of(Reserva reserva) {
        CriacaoReservaDto criacaoReservaDto = new CriacaoReservaDto();

        criacaoReservaDto.setDtReserva(LocalDateTime.from(reserva.getDtReserva()));
        criacaoReservaDto.setHoraReserva(LocalDateTime.from(reserva.getHoraReserva()));
        criacaoReservaDto.setDtHoraCheckIn(reserva.getDtHoraCheckIn());
        criacaoReservaDto.setDtHoraCheckOut(reserva.getDtHoraCheckOut());
        criacaoReservaDto.setEstabelecimento(reserva.getEstabelecimento());
        criacaoReservaDto.setUsuario(reserva.getUsuario());
        criacaoReservaDto.setAssentos(reserva.getAssentos());

        return criacaoReservaDto;
    }

    public static Reserva of(ListagemReservaDto listagemReservaDto) {
        Reserva reserva = new Reserva();

        reserva.setDtReserva(listagemReservaDto.getDtReserva());
        reserva.setHoraReserva(listagemReservaDto.getHoraReserva());
        reserva.setDtHoraCheckIn(listagemReservaDto.getDtHoraCheckIn());
        reserva.setDtHoraCheckOut(listagemReservaDto.getDtHoraCheckOut());
        reserva.setEstabelecimento(listagemReservaDto.getEstabelecimento());
        reserva.setUsuario(listagemReservaDto.getUsuario());
        reserva.setAssentos(listagemReservaDto.getAssentos());

        return reserva;
    }

public  static ListagemReservaDto mapCriacaoDto(Reserva reserva){
        ListagemReservaDto listagemReservaDto = new ListagemReservaDto();

        listagemReservaDto.setDtReserva(reserva.getDtReserva());
        listagemReservaDto.setHoraReserva(reserva.getHoraReserva());
        listagemReservaDto.setDtHoraCheckIn(reserva.getDtHoraCheckIn());
        listagemReservaDto.setDtHoraCheckOut(reserva.getDtHoraCheckOut());
        listagemReservaDto.setEstabelecimento(reserva.getEstabelecimento());
        listagemReservaDto.setAssentos(reserva.getAssentos());

        return listagemReservaDto;
}
}
