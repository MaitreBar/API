package maitre.API.Domain;

import jakarta.persistence.*;
import maitre.API.Service.EstabelecimentoService.EstabelecimentoService;

@Entity
public class Assento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAssento;
    public Boolean disponivel;
    @ManyToOne
    @JoinColumn(name="fkReserva")
    public Reserva reserva;
    @ManyToOne
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
