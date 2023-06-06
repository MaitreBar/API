package maitre.API.Service.ReservaService.dto;

import maitre.API.Domain.Reserva;

public class ReservaMapper {

    public static Reserva of(CriacaoReservaDto criacaoReservaDto) {
        Reserva reserva = new Reserva();

        reserva.setDtReserva(criacaoReservaDto.getDtReserva());
        reserva.setHoraReserva(criacaoReservaDto.getHoraReserva());
        reserva.setDtHoraCheckIn(criacaoReservaDto.getDtHoraCheckIn());
        reserva.setDtHoraCheckOut(criacaoReservaDto.getDtHoraCheckOut());
        reserva.setEstabelecimento(criacaoReservaDto.getEstabelecimento());
        reserva.setUsuario(criacaoReservaDto.getUsuario());
        reserva.setAssentos(criacaoReservaDto.getAssentos());
        reserva.setFeedback(criacaoReservaDto.getFeedback());

        return reserva;
    }

    public static CriacaoReservaDto of(Reserva reserva) {
        CriacaoReservaDto criacaoReservaDto = new CriacaoReservaDto();

        criacaoReservaDto.setDtReserva(reserva.getDtReserva());
        criacaoReservaDto.setHoraReserva(reserva.getHoraReserva());
        criacaoReservaDto.setDtHoraCheckIn(reserva.getDtHoraCheckIn());
        criacaoReservaDto.setDtHoraCheckOut(reserva.getDtHoraCheckOut());
        criacaoReservaDto.setEstabelecimento(reserva.getEstabelecimento());
        criacaoReservaDto.setUsuario(reserva.getUsuario());
        criacaoReservaDto.setAssentos(reserva.getAssentos());
        criacaoReservaDto.setFeedback(reserva.getFeedback());

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
        reserva.setFeedback(listagemReservaDto.getFeedback());

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
        listagemReservaDto.setFeedback(reserva.getFeedback());

        return listagemReservaDto;
}
}
