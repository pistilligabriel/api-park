package br.com.demoparkapi.web.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioCreateDto {
    private String usuario;
    private String senha;
}
