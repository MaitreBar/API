package maitre.API.Service.Dto;

public class CriacaoEstabelecimentoDto {

    private  String nome;
    private String logradouro;
    private String numero;
    private int cep;
    private int cnpj;
    private int qtAreas;
    private String tags;

    public CriacaoEstabelecimentoDto (String nome, String logradouro, String numero, int cep, int cnpj, int qtAreas, String tags) {
        this.nome = nome;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.cnpj = cnpj;
        this.qtAreas = qtAreas;
        this.tags = tags;
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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
