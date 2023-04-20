package maitre.api.Entidades;

import jakarta.persistence.*;
import maitre.api.Entidades.Estabelecimento;

import java.util.Date;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    private Estabelecimento estabelecimento;
    private String email;
    private String cpf;
    private Date dtNasc;
    private String rg;
    private String senha;

    public Usuario() {
    }

    public Usuario(Long id, String nome, Estabelecimento estabelecimento, String email, String cpf, Date dtNasc, String rg, String senha) {
        this.id = id;
        this.nome = nome;
        this.estabelecimento = estabelecimento;
        this.email = email;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
        this.rg = rg;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
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

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Date dtNasc) {
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
