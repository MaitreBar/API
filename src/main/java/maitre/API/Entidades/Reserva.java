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
    private Boolean checkOut;
    @OneToMany
    private List<Mesa> mesas;
    @OneToMany
    private List<Usuario> usuarios;

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(List<Mesa> mesas) {
        this.mesas = mesas;
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
