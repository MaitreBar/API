package maitre.API.Entidades;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String cpf;
    private LocalDate dtNasc;
    private String celular;
    private String rg;
    private String senha;
    private String tipoComida;
    private String tipoBebida;
    private String tipoMusica;

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public String getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(String tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    public String getTipoMusica() {
        return tipoMusica;
    }

    public void setTipoMusica(String tipoMusica) {
        this.tipoMusica = tipoMusica;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(LocalDate dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
