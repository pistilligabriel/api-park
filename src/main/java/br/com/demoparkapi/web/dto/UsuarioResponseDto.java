package br.com.demoparkapi.web.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioResponseDto {
    private Long codigo;
    private String usuario;
    private String role;
}
