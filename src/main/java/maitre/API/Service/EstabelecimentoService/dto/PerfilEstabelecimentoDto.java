package maitre.API.Service.EstabelecimentoService.dto;

import maitre.API.Domain.Assento;

import java.util.List;

public class PerfilEstabelecimentoDto {
    private String nome;
    private String logradouro;
    private String numero;
    private String cep;
    private String cnpj;
    private List<Assento> assentos;
    private String tags;
    private  String email;

    public PerfilEstabelecimentoDto() {
        this.nome = nome;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.cnpj = cnpj;
        this.assentos = assentos;
        this.tags = tags;
        this.email = email;
    }

    public void setAssentos(List<Assento> assentos) {
        this.assentos = assentos;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Assento> getAssentos() {
        return assentos;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}