package maitre.API.Service.UsuarioService.dto;

import maitre.API.Domain.Usuario;

public class UsuarioMapper {

    public static Usuario of(CriacaoUsuarioDto criacaoUsuarioDto){
        Usuario usuario = new Usuario();

        usuario.setNome(criacaoUsuarioDto.getNome());
        usuario.setEmail(criacaoUsuarioDto.getEmail());
        usuario.setCpf(criacaoUsuarioDto.getCpf());
        usuario.setDtNasc(criacaoUsuarioDto.getDtNasc());
        usuario.setCelular(criacaoUsuarioDto.getCelular());
        usuario.setRg(criacaoUsuarioDto.getRg());
        usuario.setSenha(criacaoUsuarioDto.getSenha());
        usuario.setTags(criacaoUsuarioDto.getTags());

        return usuario;
    }

    public static CriacaoUsuarioDto of(Usuario usuario){
        CriacaoUsuarioDto criacaoUsuarioDto = new CriacaoUsuarioDto();

        criacaoUsuarioDto.setNome(usuario.getNome());
        criacaoUsuarioDto.setEmail(usuario.getEmail());
        criacaoUsuarioDto.setCpf(usuario.getCpf());
        criacaoUsuarioDto.setDtNasc(usuario.getDtNasc());
        criacaoUsuarioDto.setCelular(usuario.getCelular());
        criacaoUsuarioDto.setRg(usuario.getRg());
        criacaoUsuarioDto.setSenha(usuario.getSenha());
        criacaoUsuarioDto.setTags(usuario.getTags());

        return criacaoUsuarioDto;
    }

    public static Usuario of(PerfilUsuarioDto perfilUsuarioDto){
        Usuario usuario = new Usuario();

        usuario.setNome(perfilUsuarioDto.getNome());
        usuario.setEmail(perfilUsuarioDto.getEmail());
        usuario.setCpf(perfilUsuarioDto.getCpf());
        usuario.setDtNasc(perfilUsuarioDto.getDtNasc());
        usuario.setCelular(perfilUsuarioDto.getCelular());
        usuario.setRg(perfilUsuarioDto.getRg());
        usuario.setTags(perfilUsuarioDto.getTags());

        return usuario;
    }

    public static PerfilUsuarioDto mapCriacaoDTO(Usuario usuario){
        PerfilUsuarioDto perfilUsuarioDto = new PerfilUsuarioDto();

        perfilUsuarioDto.setNome(usuario.getNome());
        perfilUsuarioDto.setEmail(usuario.getEmail());
        perfilUsuarioDto.setCpf(usuario.getCpf());
        perfilUsuarioDto.setDtNasc(usuario.getDtNasc());
        perfilUsuarioDto.setCelular(usuario.getCelular());
        perfilUsuarioDto.setRg(usuario.getRg());
        perfilUsuarioDto.setTags(usuario.getTags());

        return perfilUsuarioDto;
    }
}
