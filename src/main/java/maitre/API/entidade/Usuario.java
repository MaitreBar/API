package maitre.API.entidade;

import maitre.API.repositorio.IReserva;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String nome;
    private List<Usuario> usuarios;
    @Email
    private String email;
    @Past
    private Date dtNasc;
    @CPF
    private String cpf;
    private String rg;
    private String senha;
    List<IReserva> listaUsuario = new ArrayList<>();

    public Usuario(){
    }

    public Usuario(Long idUser, String nome, String email, Date dtNasc, String cpf, String rg, String senha, List<IReserva> listaUsuario) {
        this.idUser = idUser;
        this.nome = nome;
        this.email = email;
        this.dtNasc = dtNasc;
        this.cpf = cpf;
        this.rg = rg;
        this.senha = senha;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    //METODOS
    public void adicionarReserva(IReserva r){ //à ser alterado com a regra do banco de dados, após o mesmo ser implementado.
        listaUsuario.add(r);
    }

    public void removerReserva(IReserva r){ //à ser alterado com a regra do banco de dados, após o mesmo ser implementado.
        listaUsuario.remove(r);
    };

//    public void alterarReserva(Estabelecimento e){ //à ser alterado com a regra do banco de dados, após o mesmo ser implementado.
//
//    };

//    public ResponseEntity cadastrarUsuario(@RequestBody User u){
//        for (int i = 0; i > listaUsuario.size() ; i++){
//            if ()
//        }
//    };


}