package maitre.API.Service.Dto.EstabelecimentoService;

public class CriacaoEstabelecimentoDto {

    private  String nome;
    private String logradouro;
    private String numero;
    private int cep;
    private int cnpj;
    private String tags;
    private String email;
    private String assento;

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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    public String getAssento() {
        return assento;
    }
}
