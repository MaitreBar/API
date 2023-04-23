package maitre.API.Entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import java.time.LocalDateTime;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @FutureOrPresent
    private LocalDateTime dtHoraReserva;
    private Boolean checkIn;
    private Boolean checkOut;
    @ManyToOne
    private Estabelecimento estabelecimento;
    @ManyToOne
    private Usuario usuario;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDtHoraReserva() {
        return dtHoraReserva;
    }

    public void setDtHoraReserva(LocalDateTime dtHoraReserva) {
        this.dtHoraReserva = dtHoraReserva;
    }

    public Boolean getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Boolean checkIn) {
        this.checkIn = checkIn;
    }

    public Boolean getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Boolean checkOut) {
        this.checkOut = checkOut;
    }
}
