package br.com.demoparkapi.web.dto.mapper;

import br.com.demoparkapi.model.Usuario;
import br.com.demoparkapi.web.dto.UsuarioCreateDto;
import br.com.demoparkapi.web.dto.UsuarioResponseDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {
    public static Usuario toUsuario (UsuarioCreateDto dto){
        return new ModelMapper().map(dto,Usuario.class);
    }

    public static UsuarioResponseDto toDto(Usuario usuario){
        return new ModelMapper().map(usuario,UsuarioResponseDto.class);
    }

    public static List<UsuarioResponseDto> toListDto(List<Usuario> usuarios){
        return usuarios.stream().map(user -> toDto(user)).collect(Collectors.toList());
    }
}
