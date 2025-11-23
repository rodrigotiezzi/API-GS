package br.com.fiap.biblioteca.dominio;

import br.com.fiap.biblioteca.dominio.Login;

public interface RepositorioLogin {

    // Salvar um novo login no banco
    void salvar(Login login);

    // Buscar login pelo ID do usuário
    Login buscarPorIdUsuario(Long idUsuario);

    // Buscar login pelo email
    Login buscarPorEmail(String email);

    // Atualizar senha do login
    void atualizarSenha(Long idUsuario, String novaSenha);

    // Deletar o Login
    void deletar(Long idUsuario);
}
