package maitre.API.estabelecimento;

import maitre.API.Domain.Assento;
import maitre.API.Domain.Estabelecimento;
import maitre.API.Domain.Reserva;
import maitre.API.Domain.Usuario;

import java.util.ArrayList;
import java.util.List;

public class EstabelecimentoBuilder {

    private EstabelecimentoBuilder() {
        throw new IllegalStateException("Classe Utilitária");
    }

    public static Estabelecimento criarEstabelecimento() {
        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setIdEstabelecimento(1);
        estabelecimento.setNome("Nome do Estabelecimento");
        estabelecimento.setSenha("senha");
        estabelecimento.setLogradouro("Rua Principal");
        estabelecimento.setNumero("123");
        estabelecimento.setComplemento("Complemento");
        estabelecimento.setCep("12345-678");
        estabelecimento.setDiasDaSemana("Segunda a Sexta");
        estabelecimento.setFaixaDePreco("$$$");
        estabelecimento.setCnpj("123456789");
        estabelecimento.setHorarioAbertura("09:00");
        estabelecimento.setHorarioFechamento("18:00");
        estabelecimento.setDescricao("Descrição do estabelecimento");
        estabelecimento.setEmail("estabelecimento@example.com");

        // Adicione os assentos se necessário
        List<Assento> assentos = new ArrayList<>();
        // assentos.add(new Assento());
        estabelecimento.setAssentos(assentos);

        // Adicione as reservas se necessário
        List<Reserva> reservas = new ArrayList<>();
        // reservas.add(new Reserva());
        estabelecimento.setReservas(reservas);

        return estabelecimento;
    }
}
