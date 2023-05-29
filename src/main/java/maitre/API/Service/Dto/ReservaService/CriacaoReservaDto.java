package maitre.API.Service.Dto.ReservaService;

import maitre.API.Domain.Entidades.Assento;
import maitre.API.Domain.Entidades.Estabelecimento;
import maitre.API.Domain.Entidades.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public class CriacaoReservaDto {


    private LocalDateTime dtReserva;
    private LocalDateTime HoraReserva;
    private LocalDateTime dtHoraCheckIn;
    private LocalDateTime dtHoraCheckOut;
    private Estabelecimento estabelecimento;
    private Usuario usuario;
    private List<Assento> assentos;

    public CriacaoReservaDto(LocalDateTime dtReserva, LocalDateTime horaReserva, LocalDateTime dtHoraCheckIn, LocalDateTime dtHoraCheckOut, Estabelecimento estabelecimento, Usuario usuario, List<Assento> assentos) {
        this.dtReserva = dtReserva;
        HoraReserva = horaReserva;
        this.dtHoraCheckIn = dtHoraCheckIn;
        this.dtHoraCheckOut = dtHoraCheckOut;
        this.estabelecimento = estabelecimento;
        this.usuario = usuario;
        this.assentos = assentos;
    }

    public CriacaoReservaDto() {

    }

    public LocalDateTime getDtReserva() {
        return dtReserva;
    }

    public void setDtReserva(LocalDateTime dtReserva) {
        this.dtReserva = dtReserva;
    }

    public LocalDateTime getHoraReserva() {
        return HoraReserva;
    }

    public void setHoraReserva(LocalDateTime horaReserva) {
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
