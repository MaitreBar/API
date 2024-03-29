package maitre.API.Service.EstabelecimentoService.dto;

import maitre.API.Domain.Estabelecimento;
import maitre.API.Service.EstabelecimentoService.EstabelecimentoService;

public class EstabelecimentoMapper {

    public static Estabelecimento of(CriacaoEstabelecimentoDto criacaoEstabelecimentoDto) {
        Estabelecimento estabelecimento = new Estabelecimento();

        estabelecimento.setNome(criacaoEstabelecimentoDto.getNome());
        estabelecimento.setLogradouro(criacaoEstabelecimentoDto.getLogradouro());
        estabelecimento.setNumero(criacaoEstabelecimentoDto.getNumero());
        estabelecimento.setCep(criacaoEstabelecimentoDto.getCep());
        estabelecimento.setCnpj(criacaoEstabelecimentoDto.getCnpj());
        estabelecimento.setTags(criacaoEstabelecimentoDto.getTags());
        estabelecimento.setEmail(criacaoEstabelecimentoDto.getEmail());
        estabelecimento.setComplemento(criacaoEstabelecimentoDto.getComplemento());
        estabelecimento.setSenha(criacaoEstabelecimentoDto.getSenha());
        estabelecimento.setDiasDaSemana(criacaoEstabelecimentoDto.getDiasDaSemana());
        estabelecimento.setFaixaDePreco(criacaoEstabelecimentoDto.getFaixaDePreco());
        estabelecimento.setHorarioAbertura(criacaoEstabelecimentoDto.getHorarioAbertura());
        estabelecimento.setHorarioFechamento(criacaoEstabelecimentoDto.getHorarioFechamento());
        estabelecimento.setDescricao(criacaoEstabelecimentoDto.getDescricao());
        estabelecimento.setAssentos(criacaoEstabelecimentoDto.getAssentos());
        estabelecimento.setTelefoneContato(criacaoEstabelecimentoDto.getTelefoneContato());

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
        criacaoEstabelecimentoDto.setComplemento(estabelecimento.getComplemento());
        criacaoEstabelecimentoDto.setSenha(estabelecimento.getSenha());
        criacaoEstabelecimentoDto.setDiasDaSemana(estabelecimento.getDiasDaSemana());
        criacaoEstabelecimentoDto.setFaixaDePreco(estabelecimento.getFaixaDePreco());
        criacaoEstabelecimentoDto.setHorarioAbertura(estabelecimento.getHorarioAbertura());
        criacaoEstabelecimentoDto.setHorarioFechamento(estabelecimento.getHorarioFechamento());
        criacaoEstabelecimentoDto.setDescricao(estabelecimento.getDescricao());
        criacaoEstabelecimentoDto.setAssentos(estabelecimento.getAssentos());
        criacaoEstabelecimentoDto.setTelefoneContato(estabelecimento.getTelefoneContato());

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
        estabelecimento.setComplemento(perfilEstabelecimentoDto.getComplemento());
        estabelecimento.setSenha(perfilEstabelecimentoDto.getSenha());
        estabelecimento.setDiasDaSemana(perfilEstabelecimentoDto.getDiasDaSemana());
        estabelecimento.setFaixaDePreco(perfilEstabelecimentoDto.getFaixaDePreco());
        estabelecimento.setHorarioAbertura(perfilEstabelecimentoDto.getHorarioAbertura());
        estabelecimento.setHorarioFechamento(perfilEstabelecimentoDto.getHorarioFechamento());
        estabelecimento.setDescricao(perfilEstabelecimentoDto.getDescricao());
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
        perfilEstabelecimentoDto.setComplemento(estabelecimento.getComplemento());
        perfilEstabelecimentoDto.setSenha(estabelecimento.getSenha());
        perfilEstabelecimentoDto.setDiasDaSemana(estabelecimento.getDiasDaSemana());
        perfilEstabelecimentoDto.setFaixaDePreco(estabelecimento.getFaixaDePreco());
        perfilEstabelecimentoDto.setHorarioAbertura(estabelecimento.getHorarioAbertura());
        perfilEstabelecimentoDto.setHorarioFechamento(estabelecimento.getHorarioFechamento());
        perfilEstabelecimentoDto.setDescricao(estabelecimento.getDescricao());
        perfilEstabelecimentoDto.setAssentos(estabelecimento.getAssentos());

        return perfilEstabelecimentoDto;
    }

    public static Estabelecimento of(AtualizacaoEstabelecimentoDTO atualizacaoEstabelecimentoDTO) {
        Estabelecimento estabelecimento = new Estabelecimento();

        estabelecimento.setNome(atualizacaoEstabelecimentoDTO.getNome());
        estabelecimento.setLogradouro(atualizacaoEstabelecimentoDTO.getLogradouro());
        estabelecimento.setNumero(atualizacaoEstabelecimentoDTO.getNumero());
        estabelecimento.setCep(atualizacaoEstabelecimentoDTO.getCep());
        estabelecimento.setCnpj(atualizacaoEstabelecimentoDTO.getCnpj());
        estabelecimento.setTags(atualizacaoEstabelecimentoDTO.getTags());
        estabelecimento.setEmail(atualizacaoEstabelecimentoDTO.getEmail());
        estabelecimento.setComplemento(atualizacaoEstabelecimentoDTO.getComplemento());
        estabelecimento.setSenha(atualizacaoEstabelecimentoDTO.getSenha());
        estabelecimento.setDiasDaSemana(atualizacaoEstabelecimentoDTO.getDiasDaSemana());
        estabelecimento.setFaixaDePreco(atualizacaoEstabelecimentoDTO.getFaixaDePreco());
        estabelecimento.setHorarioAbertura(atualizacaoEstabelecimentoDTO.getHorarioAbertura());
        estabelecimento.setHorarioFechamento(atualizacaoEstabelecimentoDTO.getHorarioFechamento());
        estabelecimento.setDescricao(atualizacaoEstabelecimentoDTO.getDescricao());

        return estabelecimento;
    }

    public static AtualizacaoEstabelecimentoDTO MapAtualizacaoDTO(Estabelecimento estabelecimento) {
        AtualizacaoEstabelecimentoDTO atualizacaoEstabelecimentoDTO = new AtualizacaoEstabelecimentoDTO();

        atualizacaoEstabelecimentoDTO.setNome(estabelecimento.getNome());
        atualizacaoEstabelecimentoDTO.setLogradouro(estabelecimento.getLogradouro());
        atualizacaoEstabelecimentoDTO.setNumero(estabelecimento.getNumero());
        atualizacaoEstabelecimentoDTO.setCep(estabelecimento.getCep());
        atualizacaoEstabelecimentoDTO.setCnpj(estabelecimento.getCnpj());
        atualizacaoEstabelecimentoDTO.setTags(estabelecimento.getTags());
        atualizacaoEstabelecimentoDTO.setEmail(estabelecimento.getEmail());
        atualizacaoEstabelecimentoDTO.setComplemento(estabelecimento.getComplemento());
        atualizacaoEstabelecimentoDTO.setSenha(estabelecimento.getSenha());
        atualizacaoEstabelecimentoDTO.setDiasDaSemana(estabelecimento.getDiasDaSemana());
        atualizacaoEstabelecimentoDTO.setFaixaDePreco(estabelecimento.getFaixaDePreco());
        atualizacaoEstabelecimentoDTO.setHorarioAbertura(estabelecimento.getHorarioAbertura());
        atualizacaoEstabelecimentoDTO.setHorarioFechamento(estabelecimento.getHorarioFechamento());
        atualizacaoEstabelecimentoDTO.setDescricao(estabelecimento.getDescricao());

        return atualizacaoEstabelecimentoDTO;
    }
}

