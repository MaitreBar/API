package maitre.API.Entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String logradouro;
    private String numero;
    private int cep;
    private int cnpj;
    private int qtAreas;
    @OneToMany
    private List<Assento> assentos;
    private String tags;
    @OneToMany
    private List<Reserva> reservas;

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
    public void addReserva(Reserva reserva) {
        reservas.add(reservas.size() - 1, reserva);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public int getQtAreas() {
        return qtAreas;
    }

    public void setQtAreas(int qtAreas) {
        this.qtAreas = qtAreas;
    }

    public List<Assento> getAssentos() {
        return assentos;
    }

    public void setAssentos(List<Assento> assentos) {
        this.assentos = assentos;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getAssento() {
        String stringAssentos = "";
        for (Assento a : assentos) {
            stringAssentos += a.toString()+";";
        }
        return stringAssentos;
    }

    public String getResesva() {
        String stringReservas = "";
        for (Reserva r : reservas) {
            stringReservas += r.toString()+";";
        }
        return stringReservas;
    }
}
