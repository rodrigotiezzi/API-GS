package br.com.fiap.biblioteca.dominio;


public interface RepositorioUsuarios {

    // Salva um novo usuário no banco
    void salvar(Usuario usuario);

    // Busca o usuário completo pelo CPF
    Usuario buscarPorCpf(String cpf);

    // Busca somente o ID pelo CPF
    Long getidUsuario(String cpf);

    // Deletar Usuario
    void deletar(Long idUsuario);
}


