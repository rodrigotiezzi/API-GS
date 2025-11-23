package br.com.fiap.biblioteca.infra.dao;

import br.com.fiap.biblioteca.dominio.RepositorioUsuarios;
import br.com.fiap.biblioteca.dominio.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO implements RepositorioUsuarios {

    public UsuarioDAO() {}

    @Override
    public void salvar(Usuario usuario) {
        try {
            Connection conexao = new ConnectionFactory().getConnection();

            String sql = "INSERT INTO TB_SMT_USUARIO "
                    + "(nome, cpf, data_nascimento, profissao_usuario, logadouro, numero, complemento, bairro, cidade, estado, cep) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getCpf());
            comando.setDate(3, new java.sql.Date(usuario.getDataNascimento().getTime()));
            comando.setString(4, usuario.getProfissaoUsuario());
            comando.setString(5, usuario.getLogadouro());
            comando.setString(6, usuario.getNumero());
            comando.setString(7, usuario.getComplemento());
            comando.setString(8, usuario.getBairro());
            comando.setString(9, usuario.getCidade());
            comando.setString(10, usuario.getEstado());
            comando.setString(11, usuario.getCep());

            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar usuário", e);
        }
    }

    // Buscar o usuário completo pelo CPF
    @Override
    public Usuario buscarPorCpf(String cpf) {
        Usuario usuario = null;

        try {
            Connection conexao = new ConnectionFactory().getConnection();
            String sql = "SELECT * FROM TB_SMT_USUARIO WHERE cpf = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, cpf);

            ResultSet rs = comando.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();

                usuario.setIdUsuario(rs.getLong("id_usuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setDataNascimento(rs.getDate("data_nascimento"));
                usuario.setProfissaoUsuario(rs.getString("profissao_usuario"));
                usuario.setLogadouro(rs.getString("logadouro"));
                usuario.setNumero(rs.getString("numero"));
                usuario.setComplemento(rs.getString("complemento"));
                usuario.setBairro(rs.getString("bairro"));
                usuario.setCidade(rs.getString("cidade"));
                usuario.setEstado(rs.getString("estado"));
                usuario.setCep(rs.getString("cep"));
            }

            rs.close();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuário por CPF", e);
        }

        return usuario;
    }



    // Buscar somente o ID pelo CPF
    public Long getidUsuario(String cpf) {
        Long id = null;

        try {
            Connection conexao = new ConnectionFactory().getConnection();
            String sql = "SELECT id_usuario FROM TB_SMT_USUARIO WHERE cpf = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, cpf);

            ResultSet rs = comando.executeQuery();

            if (rs.next()) {
                id = rs.getLong("id_usuario");
            }

            rs.close();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar id do usuário por CPF", e);
        }

        return id;
    }

    @Override
    public void deletar(Long idUsuario) {
        try {
            Connection conexao = new ConnectionFactory().getConnection();
            String sql = "DELETE FROM TB_SMT_USUARIO WHERE id_usuario = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setLong(1, idUsuario);
            comando.executeUpdate();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar usuário", e);
        }
    }

}
