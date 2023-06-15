package maitre.API.Service.UsuarioService.dto;

import java.time.LocalDate;

public class FilaUsuarioDto {
    private Integer id;
    private String nome;
    private String email;
    private String cpf;
    private LocalDate dtNasc;
    private String celular;
    private String rg;
    private String tags;

    public FilaUsuarioDto(Integer id, String nome, String email, String cpf, LocalDate dtNasc, String celular, String rg, String tags) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
        this.celular = celular;
        this.rg = rg;
        this.tags = tags;
    }

    public FilaUsuarioDto() {
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
