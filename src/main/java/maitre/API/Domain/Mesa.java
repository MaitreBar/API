package maitre.API.Domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMesa;
    private Boolean disponivel;
    @JoinColumn(name="fkMesa")
    @JsonManagedReference
    @OneToMany
    private List<Assento> assentos;

    public Integer getId() {
        return idMesa;
    }

    public void setId(Integer idMesa) {
        this.idMesa = idMesa;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public List<Assento> getAssentos() {
        return assentos;
    }

    public void setAssentos(List<Assento> assentos) {
        this.assentos = assentos;
    }
}
