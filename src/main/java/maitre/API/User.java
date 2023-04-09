package maitre.API;

import maitre.API.Interface.IReserva;

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
    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    List<IReserva> listaUsuario = new ArrayList<>();

    public User(){
    }

    public User(int idUser, String nome, String email, Date dtNasc, String cpf, String rg, String senha, List<IReserva> listaUsuario) {
        this.idUser = idUser;
        this.nome = nome;
        this.email = email;
        this.dtNasc = dtNasc;
        this.cpf = cpf;
        this.rg = rg;
        this.senha = senha;
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

//    public ResponseEntity cadastrarUsuario(@RequestBody User u){
//        for (int i = 0; i > listaUsuario.size() ; i++){
//            if ()
//        }
//    };


}