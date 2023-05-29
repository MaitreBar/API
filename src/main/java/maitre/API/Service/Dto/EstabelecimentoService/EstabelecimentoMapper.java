package maitre.API.Service.Dto.EstabelecimentoService;

import maitre.API.Domain.Entidades.Estabelecimento;

public class EstabelecimentoMapper {

    public static Estabelecimento of(CriacaoEstabelecimentoDto criacaoEstabelecimentoDto) {
        Estabelecimento estabelecimento = new Estabelecimento();

        estabelecimento.setNome(criacaoEstabelecimentoDto.getNome());
        estabelecimento.setLogradouro(criacaoEstabelecimentoDto.getLogradouro());
        estabelecimento.setNumero(criacaoEstabelecimentoDto.getNumero());
        estabelecimento.setCep(String.valueOf(criacaoEstabelecimentoDto.getCep()));
        estabelecimento.setCnpj(String.valueOf(criacaoEstabelecimentoDto.getCnpj()));
        estabelecimento.setTags(criacaoEstabelecimentoDto.getTags());

        return estabelecimento;

    }

    public static CriacaoEstabelecimentoDto of(Estabelecimento estabelecimento) {
        CriacaoEstabelecimentoDto criacaoEstabelecimentoDto = new CriacaoEstabelecimentoDto();

        criacaoEstabelecimentoDto.setNome(estabelecimento.getNome());
        criacaoEstabelecimentoDto.setLogradouro(estabelecimento.getLogradouro());
        criacaoEstabelecimentoDto.setNumero(estabelecimento.getNumero());
        criacaoEstabelecimentoDto.setCep(Integer.parseInt(estabelecimento.getCep()));
        criacaoEstabelecimentoDto.setCnpj(Integer.parseInt(estabelecimento.getCnpj()));
        criacaoEstabelecimentoDto.setTags(estabelecimento.getTags());
        criacaoEstabelecimentoDto.setEmail(estabelecimento.setEmail());
        criacaoEstabelecimentoDto.setAssento(estabelecimento.getAssento());

        return criacaoEstabelecimentoDto;

    }

    public static Estabelecimento of(PerfilEstabelecimentoDto perfilEstabelecimentoDto) {
        Estabelecimento estabelecimento = new Estabelecimento();

        estabelecimento.setNome(perfilEstabelecimentoDto.getNome());
        estabelecimento.setLogradouro(perfilEstabelecimentoDto.getLogradouro());
        estabelecimento.setNumero(perfilEstabelecimentoDto.getNumero());
        estabelecimento.setNumero(perfilEstabelecimentoDto.getNumero());
        estabelecimento.setCep(String.valueOf(perfilEstabelecimentoDto.getCep()));
        estabelecimento.setCnpj(String.valueOf(perfilEstabelecimentoDto.getCnpj()));
        estabelecimento.setTags(perfilEstabelecimentoDto.getTags());
        estabelecimento.setEmail(perfilEstabelecimentoDto.getEmail());
        estabelecimento.setAssentos(perfilEstabelecimentoDto.setAssentos());

        return estabelecimento;
    }

    public static PerfilEstabelecimentoDto mapCriacaoDto(Estabelecimento estabelecimento) {
        PerfilEstabelecimentoDto perfilEstabelecimentoDto = new PerfilEstabelecimentoDto();

        perfilEstabelecimentoDto.setNome(estabelecimento.getNome());
        perfilEstabelecimentoDto.setLogradouro(estabelecimento.getLogradouro());
        perfilEstabelecimentoDto.setNumero(estabelecimento.getNumero());
        perfilEstabelecimentoDto.setCep(Integer.parseInt(estabelecimento.getCep()));
        perfilEstabelecimentoDto.setCnpj(Integer.parseInt(estabelecimento.getCnpj()));
        perfilEstabelecimentoDto.setTags(estabelecimento.getTags());
        perfilEstabelecimentoDto.setEmail(estabelecimento.getEmail());
        perfilEstabelecimentoDto.setAssentos(estabelecimento.getAssento());

        return perfilEstabelecimentoDto;
    }
}

