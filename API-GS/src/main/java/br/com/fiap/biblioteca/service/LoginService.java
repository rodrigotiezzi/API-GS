package br.com.fiap.biblioteca.service;

import br.com.fiap.biblioteca.dominio.Login;
import br.com.fiap.biblioteca.dominio.RepositorioLogin;
import br.com.fiap.biblioteca.dominio.RepositorioUsuarios;
import br.com.fiap.biblioteca.infra.dao.LoginDAO;
import br.com.fiap.biblioteca.infra.dao.UsuarioDAO;

public class LoginService {

    private RepositorioLogin repositorioLogin;
    private RepositorioUsuarios repositorioUsuarios;

    public LoginService(RepositorioLogin repositorioLogin) {
        this.repositorioLogin = repositorioLogin;
        this.repositorioUsuarios = new UsuarioDAO(); // Para deletar usuário junto
    }

    // Cadastrar um novo login
    public void cadastrarLogin(Login login) {
        repositorioLogin.salvar(login);
    }

    // Buscar login pelo ID do usuário
    public Login buscarPorIdUsuario(Long idUsuario) {
        return repositorioLogin.buscarPorIdUsuario(idUsuario);
    }

    // Buscar login pelo email
    public Login buscarPorEmail(String email) {
        return repositorioLogin.buscarPorEmail(email);
    }

    // Validar login pelo email e senha
    public boolean validarLogin(String email, String senha) {
        Login login = repositorioLogin.buscarPorEmail(email);
        if (login == null) {
            return false;
        }
        return login.getSenha().equals(senha);
    }

    // Alterar senha de um login
    public void alterarSenha(Long idUsuario, String novaSenha) {
        repositorioLogin.atualizarSenha(idUsuario, novaSenha);
    }

    // Deletar login e usuário associado pelo email e senha
    public void deletarLogineUsuario(String email, String senha) {
        Login login = repositorioLogin.buscarPorEmail(email);

        // Deleta login
        repositorioLogin.deletar(login.getIdUsuario());

        // Deleta usuário associado
        repositorioUsuarios.deletar(login.getIdUsuario());
    }
}
