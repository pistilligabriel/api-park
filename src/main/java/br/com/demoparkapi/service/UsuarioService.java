package br.com.demoparkapi.service;

import br.com.demoparkapi.model.Usuario;
import br.com.demoparkapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorId (Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado")
        );
    }

    public List<Usuario> buscarTodos (){
        return usuarioRepository.findAll();
    }

    public Usuario alterarSenha(Long id, String senhaAtual, String novaSenha, String confirmaSenha){
        if(!novaSenha.equals(confirmaSenha)){
            throw new RuntimeException("Nova senha não combina com senha confirmada");
        }

        Usuario user = buscarPorId(id);

        if(!senhaAtual.equals(user.getSenha())){
            throw new RuntimeException("Senha atual está incorreta");
        }

        user.setSenha(novaSenha);
        return user;
    }
}
