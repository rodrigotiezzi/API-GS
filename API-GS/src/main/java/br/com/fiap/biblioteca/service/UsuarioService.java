package br.com.fiap.biblioteca.service;

import br.com.fiap.biblioteca.dominio.RepositorioUsuarios;
import br.com.fiap.biblioteca.dominio.Usuario;

public class UsuarioService {

    private RepositorioUsuarios repositorioUsuarios;

    public UsuarioService(RepositorioUsuarios  repositorioUsuarios) {
        this.repositorioUsuarios = repositorioUsuarios;
    }

    // Cadastrar um novo usuário
    public void cadastrarUsuario(Usuario usuario) {
        repositorioUsuarios.salvar(usuario);
    }

    // Buscar usuário completo pelo CPF
    public Usuario buscarPorCpf(String cpf) {
        return repositorioUsuarios.buscarPorCpf(cpf);
    }

    // Buscar apenas o ID pelo CPF
    public Long getidUsuario(String cpf) {
        return repositorioUsuarios.getidUsuario(cpf);
    }
}
