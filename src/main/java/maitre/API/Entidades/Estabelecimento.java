package maitre.api.Entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "nome")
    private List<Usuario> usuarios;
    private String nome;
    private String logradouro;
    private String numero;
    private int cep;
    private int cnpj;
    private int qtAssentos;
    private int qtAreas;
    private int qtMesas;
    private String tipoComida;
    private String tipoBebida;
    private String tipoMusica;

}
