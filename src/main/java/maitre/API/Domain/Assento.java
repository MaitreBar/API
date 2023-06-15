package maitre.API.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@Entity
public class Assento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAssento;
    public Boolean disponivel;
    @ManyToOne
    @JsonBackReference(value="assentos-reserva")
    @JoinColumn(name="fkReserva")
    public Reserva reserva;
    @ManyToOne
    @JsonBackReference(value="assentos-estabelecimento")
    @JoinColumn(name="fkEstabelecimento")
    public Estabelecimento estabelecimento;

    public Integer getId() {
        return idAssento;
    }

    public void setId(Integer idAssento) {
        this.idAssento = idAssento;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Assento{" +
                "idAssento=" + idAssento +
                ", disponivel=" + disponivel +
                '}';
    }
}
