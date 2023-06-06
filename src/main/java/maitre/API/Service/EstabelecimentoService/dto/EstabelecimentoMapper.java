package maitre.API.Service.EstabelecimentoService.dto;

import maitre.API.Domain.Estabelecimento;

public class EstabelecimentoMapper {

    public static Estabelecimento of(CriacaoEstabelecimentoDto criacaoEstabelecimentoDto) {
        Estabelecimento estabelecimento = new Estabelecimento();

        estabelecimento.setNome(criacaoEstabelecimentoDto.getNome());
        estabelecimento.setLogradouro(criacaoEstabelecimentoDto.getLogradouro());
        estabelecimento.setNumero(criacaoEstabelecimentoDto.getNumero());
        estabelecimento.setCep(criacaoEstabelecimentoDto.getCep());
        estabelecimento.setCnpj(criacaoEstabelecimentoDto.getCnpj());
        estabelecimento.setTags(criacaoEstabelecimentoDto.getTags());

        return estabelecimento;

    }

    public static CriacaoEstabelecimentoDto of(Estabelecimento estabelecimento) {
        CriacaoEstabelecimentoDto criacaoEstabelecimentoDto = new CriacaoEstabelecimentoDto();

        criacaoEstabelecimentoDto.setNome(estabelecimento.getNome());
        criacaoEstabelecimentoDto.setLogradouro(estabelecimento.getLogradouro());
        criacaoEstabelecimentoDto.setNumero(estabelecimento.getNumero());
        criacaoEstabelecimentoDto.setCep(estabelecimento.getCep());
        criacaoEstabelecimentoDto.setCnpj(estabelecimento.getCnpj());
        criacaoEstabelecimentoDto.setTags(estabelecimento.getTags());
        criacaoEstabelecimentoDto.setEmail(estabelecimento.getEmail());
        criacaoEstabelecimentoDto.setAssentos(estabelecimento.getAssentos());

        return criacaoEstabelecimentoDto;

    }

    public static Estabelecimento of(PerfilEstabelecimentoDto perfilEstabelecimentoDto) {
        Estabelecimento estabelecimento = new Estabelecimento();

        estabelecimento.setNome(perfilEstabelecimentoDto.getNome());
        estabelecimento.setLogradouro(perfilEstabelecimentoDto.getLogradouro());
        estabelecimento.setNumero(perfilEstabelecimentoDto.getNumero());
        estabelecimento.setCep(perfilEstabelecimentoDto.getCep());
        estabelecimento.setCnpj(perfilEstabelecimentoDto.getCnpj());
        estabelecimento.setTags(perfilEstabelecimentoDto.getTags());
        estabelecimento.setEmail(perfilEstabelecimentoDto.getEmail());
        estabelecimento.setAssentos(perfilEstabelecimentoDto.getAssentos());

        return estabelecimento;
    }

    public static PerfilEstabelecimentoDto mapCriacaoDto(Estabelecimento estabelecimento) {
        PerfilEstabelecimentoDto perfilEstabelecimentoDto = new PerfilEstabelecimentoDto();

        perfilEstabelecimentoDto.setNome(estabelecimento.getNome());
        perfilEstabelecimentoDto.setLogradouro(estabelecimento.getLogradouro());
        perfilEstabelecimentoDto.setNumero(estabelecimento.getNumero());
        perfilEstabelecimentoDto.setCep(estabelecimento.getCep());
        perfilEstabelecimentoDto.setCnpj(estabelecimento.getCnpj());
        perfilEstabelecimentoDto.setTags(estabelecimento.getTags());
        perfilEstabelecimentoDto.setEmail(estabelecimento.getEmail());
        perfilEstabelecimentoDto.setAssentos(estabelecimento.getAssentos());

        return perfilEstabelecimentoDto;
    }
}

