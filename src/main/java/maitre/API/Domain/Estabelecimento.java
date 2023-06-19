package maitre.API.Domain;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstabelecimento;
    private String nome;
    private String senha;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
    private String diasDaSemana;
    private String faixaDePreco;
    private String cnpj;
    private String telefoneContato;
    private String horarioAbertura;
    private String horarioFechamento;
    private String descricao;
    private String email;
    @JoinColumn(name="fkEstabelecimento")
    @JsonManagedReference(value="assentos-estabelecimento")
    @OneToMany
    private List<Assento> assentos;
    private String tags;
    @JoinColumn(name="fkEstabelecimento")
    @JsonManagedReference(value="reservas-estabelecimento")
    @OneToMany
    private List<Reserva> reservas;

    public Estabelecimento() {
    }

    public Estabelecimento(String nome, String logradouro, String numero, String bairro, String cnpj, String telefoneContato, String email) {
        this.nome = nome;
        this.logradouro = bairro;
        this.logradouro += " " + logradouro;
        this.numero = numero;
        this.cnpj = cnpj;
        this.telefoneContato = telefoneContato;
        this.email = email;
        this.assentos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public Estabelecimento(String nome, String logradouro, String numero, String cnpj, String telefoneContato, String horarioAbertura, String horarioFechamento, String email, String tags) {
        this.nome = nome;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cnpj = cnpj;
        this.telefoneContato = telefoneContato;
        this.horarioAbertura = horarioAbertura;
        this.horarioFechamento = horarioFechamento;
        this.email = email;
        this.tags = tags;
        this.assentos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public String getFaixaDePreco() {
        return faixaDePreco;
    }

    public void setFaixaDePreco(String faixaDePreco) {
        this.faixaDePreco = faixaDePreco;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

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
        this.reservas.add(reservas.size() - 1, reserva);
    }

    public Integer getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(Integer idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
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

//    public String getAssento() {
//        String stringAssentos = "";
//        for (Assento a : assentos) {
//            stringAssentos += a.toString()+";";
//        }
//        return stringAssentos;
//    }

//    public String getResesva() {
//        String stringReservas = "";
//        for (Reserva r : reservas) {
//            stringReservas += r.toString()+";";
//        }
//        return stringReservas;
//    }

    @Override
    public String toString() {
        return "Estabelecimento{" +
                ", nome='" + nome +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", email='" + telefoneContato + '\'' +
                ", telefoneContato='" + email + '\'' +
                '}';
    }
}
