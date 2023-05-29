package maitre.API.Service.Dto.EstabelecimentoService;

import maitre.API.Domain.Entidades.Assento;

import java.util.List;

public class PerfilEstabelecimentoDto {
    private String nome;
    private String logradouro;
    private String numero;
    private int cep;
    private int cnpj;
    private String assentos;
    private String tags;
    private  String email;

    public PerfilEstabelecimentoDto() {
        this.nome = nome;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.cnpj = cnpj;
        this.assentos = assentos.toString();
        this.tags = tags;
        this.email = email;
    }

    public void setAssentos(List<Assento> assentos) {
        this.assentos = assentos.toString();
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


    public String getAssentos() {
        return assentos;
    }

    public void setAssentos(String assentos) {
        this.assentos = assentos;
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