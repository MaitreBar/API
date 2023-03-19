package maitre.API;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User{
    private int idUser;
    private String nome;
    private String email;
    private Date dtNasc;
    private String cpf;
    private String rg;

    List<IReserva> listaUsuario = new ArrayList<>();

    public User(){
    }

    public User(int idUser, String nome, String email, Date dtNasc, String cpf, String rg, List<IReserva> listaUsuario) {
        this.idUser = idUser;
        this.nome = nome;
        this.email = email;
        this.dtNasc = dtNasc;
        this.cpf = cpf;
        this.rg = rg;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getNome() {
        return nome;
    }

    public Date getDtNasc() {
        return dtNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public List<IReserva> getListaUsuario() {
        return listaUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //METODOS
    public void adicionarReserva(IReserva r){ //à ser alterado com a regra do banco de dados, após o mesmo ser implementado.
        listaUsuario.add(r);
    }

    public void removerReserva(IReserva r){ //à ser alterado com a regra do banco de dados, após o mesmo ser implementado.
        listaUsuario.remove(r);
    };

    public void alterarReserva(Estabelecimento e){ //à ser alterado com a regra do banco de dados, após o mesmo ser implementado.

    };

    public void cadastrarUsuario(User u){ //à ser alterado com a regra do banco de dados, após o mesmo ser implementado.

    };


}