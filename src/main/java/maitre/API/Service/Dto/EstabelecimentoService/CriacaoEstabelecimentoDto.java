package maitre.API.Service.Dto.EstabelecimentoService;

import maitre.API.Domain.Entidades.Assento;

import java.util.List;

public class CriacaoEstabelecimentoDto {

    private  String nome;
    private String logradouro;
    private String numero;
    private String cep;
    private String cnpj;
    private String tags;
    private String email;
    private List<Assento> assentos;

    public CriacaoEstabelecimentoDto() {

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

    public List<Assento> getAssentos() {
        return assentos;
    }

    public void setAssentos(List<Assento> assentos) {
        this.assentos = assentos;
    }
}
