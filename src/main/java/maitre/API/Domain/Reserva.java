package maitre.API.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReserva;
    @FutureOrPresent
    private LocalDate dtReserva;
    private LocalTime horaReserva;
    private Boolean checkIn;
    private LocalDateTime dtHoraCheckIn;
    private boolean checkOut;
    private LocalDateTime dtHoraCheckOut;
    private String feedback;
    @JoinColumn(name="fkEstabelecimento")
    @JsonBackReference(value="reservas-estabelecimento")
    @ManyToOne
    private Estabelecimento estabelecimento;
    @JoinColumn(name="fkUsuario")
    @JsonBackReference(value="reservas-usuario")
    @ManyToOne
    private Usuario usuario;
    @JoinColumn(name="fkReserva")
    @JsonManagedReference(value="assentos-reserva")
    @OneToMany @Fetch(FetchMode.JOIN)
    private List<Assento> assentos;

    public Reserva(Integer idReserva, LocalDate dtReserva, Time horaReserva, Boolean checkIn, LocalDateTime dtHoraCheckIn, boolean checkOut, LocalDateTime dtHoraCheckOut, String feedback) {
        this.idReserva = idReserva;
        this.dtReserva = dtReserva;
        this.horaReserva = horaReserva.toLocalTime();
        this.checkIn = checkIn;
        this.dtHoraCheckIn = dtHoraCheckIn;
        this.checkOut = checkOut;
        this.dtHoraCheckOut = dtHoraCheckOut;
        this.feedback = feedback;
    }

    public Reserva(int id, LocalDate dtReserva, Time hrReserva, Boolean checkIn, Boolean checkOut, LocalDateTime dtHoraCheckIn, LocalDateTime dtHoraCheckOut, String feedback) {

    }

    public Reserva() {

    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getId() {
        return idReserva;
    }

    public void setId(Integer idReserva) {
        this.idReserva = idReserva;
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

    public boolean isCheckOut() {
        return checkOut;
    }

    public void setCheckOut(boolean checkOut) {
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

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
