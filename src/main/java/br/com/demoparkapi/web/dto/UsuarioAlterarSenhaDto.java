package br.com.demoparkapi.web.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioAlterarSenhaDto {
    private String senhaAtual;
    private String novaSenha;
    private String confirmaSenha;
}
