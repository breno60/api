package br.com.atividade.web.service.services;

import br.com.atividade.web.service.models.Usuario;
import br.com.atividade.web.service.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios () {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> usuarioPorId (int id) {
        return usuarioRepository.findById(id);
    }

    public Usuario criarUsuario (Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public boolean atualizarUsuario (int id, Usuario usuario) {
        Optional<Usuario> usuarioEncontrado = this.usuarioPorId(id);
        boolean notFound = true;
        if (usuarioEncontrado.isPresent()) {
            Usuario usuarioAtualizado = usuarioEncontrado.get();

            usuarioAtualizado.setNome(usuario.getNome());
            usuarioAtualizado.setUsuario(usuario.getUsuario());
            usuarioAtualizado.setSenha(usuario.getSenha());
            notFound = false;
        }

        return notFound;
    }

    public boolean deletarUsuario (int id) {
        Optional<Usuario> usuarioEncontrado = this.usuarioPorId(id);
        boolean notFound = true;
        if (usuarioEncontrado.isPresent()) {
            usuarioRepository.delete(usuarioEncontrado.get());
            notFound = false;
        }
        return notFound;
    }

}
