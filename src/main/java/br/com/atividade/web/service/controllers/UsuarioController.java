package br.com.atividade.web.service.controllers;

import br.com.atividade.web.service.models.Usuario;
import br.com.atividade.web.service.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ResponseEntity<List<Usuario>> getUsuarios () {
        return new ResponseEntity<List<Usuario>>(usuarioService.listarUsuarios(), HttpStatus.FOUND);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Usuario>> usuarioPorId (@PathVariable int id) {
        return new ResponseEntity<>(usuarioService.usuarioPorId(id), HttpStatus.OK);
    }

    @PostMapping("/criar")
    public ResponseEntity<Usuario> criarUsuario (@RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.criarUsuario(usuario), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar{id}")
    public ResponseEntity<Optional<Usuario>> atualizarUsuario (@PathVariable int id, @RequestBody Usuario usuario) {
        if (usuarioService.atualizarUsuario(id, usuario)) {
            return new ResponseEntity<>(usuarioService.usuarioPorId(id), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuarioService.usuarioPorId(id), HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarUsuario (@PathVariable int id) {
        if (usuarioService.deletarUsuario(id)) {
            return new ResponseEntity<>("Não Encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Deletado", HttpStatus.OK);
    }

}
