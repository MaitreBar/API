package maitre.API.Entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @FutureOrPresent
    private LocalDateTime dtHoraReserva;
    private Boolean checkIn;
    @FutureOrPresent
    private LocalDateTime dtHoraCheckIn;
    private Boolean checkOut;
    @FutureOrPresent
    private LocalDateTime dtHoraCheckOut;
    @ManyToOne
    private Estabelecimento estabelecimento;
    @ManyToOne
    private Usuario usuario;
    @OneToMany
    private List<Assento> assentos;

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

    public LocalDateTime getDtHoraCheckIn() {
        return dtHoraCheckIn;
    }

    public void setDtHoraCheckIn(LocalDateTime dtHoraCheckIn) {
        this.dtHoraCheckIn = dtHoraCheckIn;
    }

    public Boolean getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Boolean checkOut) {
        this.checkOut = checkOut;
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

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", dtHoraReserva=" + dtHoraReserva +
                ", checkIn=" + checkIn +
                ", dtHoraCheckIn=" + dtHoraCheckIn +
                ", checkOut=" + checkOut +
                ", dtHoraCheckOut=" + dtHoraCheckOut +
                '}';
    }
}
