package br.com.demoparkapi.web.controller;

import br.com.demoparkapi.model.Usuario;
import br.com.demoparkapi.service.UsuarioService;
import br.com.demoparkapi.web.dto.UsuarioAlterarSenhaDto;
import br.com.demoparkapi.web.dto.UsuarioCreateDto;
import br.com.demoparkapi.web.dto.UsuarioResponseDto;
import br.com.demoparkapi.web.dto.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> criarUsuario (@RequestBody UsuarioCreateDto dto){
        Usuario user = usuarioService.criarUsuario(UsuarioMapper.toUsuario(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> buscarPorId(@PathVariable Long id){
        Usuario usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(UsuarioMapper.toDto(usuario));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> buscarTodos(){
        List<Usuario> usuarios = usuarioService.buscarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(UsuarioMapper.toListDto(usuarios));
    }
    
    @PatchMapping("/alterar-senha/{id}")
    public ResponseEntity<UsuarioAlterarSenhaDto> alterarSenha(@PathVariable Long id, @RequestBody UsuarioAlterarSenhaDto dto){
            Usuario usuario = usuarioService.alterarSenha(id,dto.getSenhaAtual(),dto.getNovaSenha(),dto.getConfirmaSenha());
        return ResponseEntity.noContent().build();
    }
}
