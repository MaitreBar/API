//package maitre.API.entidade;
//
//import maitre.API.repositorio.IReserva;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public abstract class Estabelecimento implements IReserva {
//    private int idEstabelecimento;
//    private String nome;
//    private String logadouro;
//    private String numero;
//    private int cep;
//    private int cnpj;
//    private int qtdAssentos;
//    private int qtdAreas;
//    private int qtdMesas;
//    private String tipoComida;
//    private String tipoBebida;
//    private String tipoMusica;
//    List<Estabelecimento> listaEstabelecimento = new ArrayList<>();
//
//    public Estabelecimento(){
//    }
//
//    public Estabelecimento(int idEstabelecimento, String nome, String logadouro, String numero, int cep, int cnpj, int qtdAssentos, int qtdAreas, int qtdMesas, String tipoComida, String tipoBebida, String tipoMusica, List<Estabelecimento> lista) {
//        this.idEstabelecimento = idEstabelecimento;
//        this.nome = nome;
//        this.logadouro = logadouro;
//        this.numero = numero;
//        this.cep = cep;
//        this.cnpj = cnpj;
//        this.qtdAssentos = qtdAssentos;
//        this.qtdAreas = qtdAreas;
//        this.qtdMesas = qtdMesas;
//        this.tipoComida = tipoComida;
//        this.tipoBebida = tipoBebida;
//        this.tipoMusica = tipoMusica;
//    }
//
//    public int getIdEstabelecimento() {
//        return idEstabelecimento;
//    }
//
//    public void setIdEstabelecimento(int idEstabelecimento) {
//        this.idEstabelecimento = idEstabelecimento;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public String getLogadouro() {
//        return logadouro;
//    }
//
//    public void setLogadouro(String logadouro) {
//        this.logadouro = logadouro;
//    }
//
//    public String getNumero() {
//        return numero;
//    }
//
//    public void setNumero(String numero) {
//        this.numero = numero;
//    }
//
//    public int getCep() {
//        return cep;
//    }
//
//    public void setCep(int cep) {
//        this.cep = cep;
//    }
//
//    public int getCnpj() {
//        return cnpj;
//    }
//
//    public void setCnpj(int cnpj) {
//        this.cnpj = cnpj;
//    }
//
//    public int getQtdAssentos() {
//        return qtdAssentos;
//    }
//
//    public void setQtdAssentos(int qtdAssentos) {
//        this.qtdAssentos = qtdAssentos;
//    }
//
//    public int getQtdAreas() {
//        return qtdAreas;
//    }
//
//    public void setQtdAreas(int qtdAreas) {
//        this.qtdAreas = qtdAreas;
//    }
//
//    public int getQtdMesas() {
//        return qtdMesas;
//    }
//
//    public void setQtdMesas(int qtdMesas) {
//        this.qtdMesas = qtdMesas;
//    }
//
//    public String getTipoComida() {
//        return tipoComida;
//    }
//
//    public void setTipoComida(String tipoComida) {
//        this.tipoComida = tipoComida;
//    }
//
//    public String getTipoBebida() {
//        return tipoBebida;
//    }
//
//    public void setTipoBebida(String tipoBebida) {
//        this.tipoBebida = tipoBebida;
//    }
//
//    public String getTipoMusica() {
//        return tipoMusica;
//    }
//
//    public void setTipoMusica(String tipoMusica) {
//        this.tipoMusica = tipoMusica;
//    }
//
//    public List<Estabelecimento> getListaEstabelecimento() {
//        return listaEstabelecimento;
//    }
//
//    public void checkIn(Usuario u){ //à ser alterado com a regra do banco de dados, após o mesmo ser implementado.
//
//    };
//
//    public void checkOut(Usuario u){ //à ser alterado com a regra do banco de dados, após o mesmo ser implementado.
//
//    };
//
//    public void cadastrarEstabelecimento(Estabelecimento e){ //à ser alterado com a regra do banco de dados, após o mesmo ser implementado.
//        listaEstabelecimento.add(e);
//    };
//
//    public void alterarEstabelecimento(Estabelecimento antigo, Estabelecimento alterado){ //à ser alterado com a regra do banco de dados, após o mesmo ser implementado.
//        for (int i = 0; i < listaEstabelecimento.size(); i++) {
//            if(listaEstabelecimento.get(i) == antigo){
//                listaEstabelecimento.add(i, alterado);
//            }
//        }
//    };
//
//    public void alterarTipo(Estabelecimento antigo, Estabelecimento alterado){ //à ser alterado com a regra do banco de dados, após o mesmo ser implementado.
//        for (int i = 0; i < listaEstabelecimento.size(); i++) {
//            if(listaEstabelecimento.get(i) == antigo){
//                listaEstabelecimento.add(i, alterado);
//            }
//        }
//
//    };
//
//    public void alterarArea(Estabelecimento antigo, Estabelecimento alterado){ //à ser alterado com a regra do banco de dados, após o mesmo ser implementado.
//        for (int i = 0; i < listaEstabelecimento.size(); i++) {
//            if(listaEstabelecimento.get(i) == antigo){
//                listaEstabelecimento.add(i, alterado);
//            }
//        }
//
//    };
//
//    public void alterarAssentos(Estabelecimento antigo, Estabelecimento alterado){ //à ser alterado com a regra do banco de dados, após o mesmo ser implementado.
//        for (int i = 0; i < listaEstabelecimento.size(); i++) {
//            if(listaEstabelecimento.get(i) == antigo){
//                listaEstabelecimento.add(i, alterado);
//            }
//        }
//
//    };
//
//}
