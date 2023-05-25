package maitre.API.Entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @FutureOrPresent
    private LocalDate dtReserva;
    private LocalTime horaReserva;
    private Boolean checkIn;
    private LocalDateTime dtHoraCheckIn;
    private Boolean checkOut;
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

    public LocalDate getDtReserva() {
        return dtReserva;
    }

    public void setDtReserva(LocalDate dtReserva) {
        this.dtReserva = dtReserva;
    }

    public LocalTime getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(LocalTime horaReserva) {
        this.horaReserva = horaReserva;
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

    public Usuario getUsuario() {
        return usuario;
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
                ", dtReserva=" + dtReserva +
                ", horaReserva=" + horaReserva +
                ", checkIn=" + checkIn +
                ", dtHoraCheckIn=" + dtHoraCheckIn +
                ", checkOut=" + checkOut +
                ", dtHoraCheckOut=" + dtHoraCheckOut +
                '}';
    }
}
