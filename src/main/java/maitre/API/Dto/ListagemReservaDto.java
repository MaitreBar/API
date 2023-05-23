package maitre.API.Dto;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.FutureOrPresent;
import maitre.API.Entidades.Assento;
import maitre.API.Entidades.Estabelecimento;
import maitre.API.Entidades.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public class ListagemReservaDto {
    private LocalDateTime dtHoraReserva;
    private LocalDateTime dtHoraCheckIn;
    private LocalDateTime dtHoraCheckOut;
    private Estabelecimento estabelecimento;
    private Usuario usuario;
    private List<Assento> assentos;

    public ListagemReservaDto(LocalDateTime dtHoraReserva, LocalDateTime dtHoraCheckIn, LocalDateTime dtHoraCheckOut, Estabelecimento estabelecimento, Usuario usuario, List<Assento> assentos) {
        this.dtHoraReserva = dtHoraReserva;
        this.dtHoraCheckIn = dtHoraCheckIn;
        this.dtHoraCheckOut = dtHoraCheckOut;
        this.estabelecimento = estabelecimento;
        this.usuario = usuario;
        this.assentos = assentos;
    }

    public LocalDateTime getDtHoraReserva() {
        return dtHoraReserva;
    }

    public void setDtHoraReserva(LocalDateTime dtHoraReserva) {
        this.dtHoraReserva = dtHoraReserva;
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
