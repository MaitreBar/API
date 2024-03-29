package maitre.API.Service.ReservaService.dto;

import maitre.API.Domain.Assento;
import maitre.API.Domain.Estabelecimento;
import maitre.API.Domain.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class ListagemReservaDto {
    private LocalDate dtReserva;
    private LocalTime HoraReserva;
    private LocalDateTime dtHoraCheckIn;
    private LocalDateTime dtHoraCheckOut;
    private Estabelecimento estabelecimento;
    private Usuario usuario;
    private List<Assento> assentos;
    private String feedback;

    public ListagemReservaDto(LocalDate dtReserva, LocalTime horaReserva, LocalDateTime dtHoraCheckIn, LocalDateTime dtHoraCheckOut, Estabelecimento estabelecimento, Usuario usuario, List<Assento> assentos) {
        this.dtReserva = dtReserva;
        HoraReserva = horaReserva;
        this.dtHoraCheckIn = dtHoraCheckIn;
        this.dtHoraCheckOut = dtHoraCheckOut;
        this.estabelecimento = estabelecimento;
        this.usuario = usuario;
        this.assentos = assentos;
        this.feedback = feedback;
    }

    public ListagemReservaDto() {

    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public LocalDate getDtReserva() {
        return dtReserva;
    }

    public void setDtReserva(LocalDate dtReserva) {
        this.dtReserva = dtReserva;
    }

    public LocalTime getHoraReserva() {
        return HoraReserva;
    }

    public void setHoraReserva(LocalTime horaReserva) {
        HoraReserva = horaReserva;
    }

    public LocalDateTime getDtHoraCheckIn() {
        return dtHoraCheckIn;
    }

    public void setDtHoraCheckIn(LocalDateTime dtHoraCheckIn) {
        this.dtHoraCheckIn = dtHoraCheckIn;
    }

    public LocalDateTime getDtHoraCheckOut() {
        return dtHoraCheckOut;
    }

    public void setDtHoraCheckOut(LocalDateTime dtHoraCheckOut) {
        this.dtHoraCheckOut = dtHoraCheckOut;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Assento> getAssentos() {
        return assentos;
    }

    public void setAssentos(List<Assento> assentos) {
        this.assentos = assentos;
    }
}
