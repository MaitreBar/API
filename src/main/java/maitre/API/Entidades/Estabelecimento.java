package maitre.API.Entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String senha;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
    private String diasDaSemana;
    private String cnpj;
    private String horarioAbertura;
    private String horarioFechamento;
    private String descricao;
    private String email;
    @OneToMany
    private List<Assento> assentos;
    private String tags;
    @OneToMany
    private List<Reserva> reservas;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getDiasDaSemana() {
        return diasDaSemana;
    }

    public void setDiasDaSemana(String diasDaSemana) {
        this.diasDaSemana = diasDaSemana;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getHorarioAbertura() {
        return horarioAbertura;
    }

    public void setHorarioAbertura(String horarioAbertura) {
        this.horarioAbertura = horarioAbertura;
    }

    public String getHorarioFechamento() {
        return horarioFechamento;
    }

    public void setHorarioFechamento(String horarioFechamento) {
        this.horarioFechamento = horarioFechamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
