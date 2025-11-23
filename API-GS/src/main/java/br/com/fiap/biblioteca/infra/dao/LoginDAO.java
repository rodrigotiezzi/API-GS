package br.com.fiap.biblioteca.infra.dao;

import br.com.fiap.biblioteca.dominio.Login;
import br.com.fiap.biblioteca.dominio.RepositorioLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO implements RepositorioLogin {

    public LoginDAO() {}


    // 1. CRIAR: salvar um novo login
    @Override
    public void salvar(Login login) {
        try {
            Connection conexao = new ConnectionFactory().getConnection();
            String sql = "INSERT INTO TB_SMT_LOGIN (id_usuario, email, senha) VALUES (?, ?, ?)";
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setLong(1, login.getIdUsuario());
            comando.setString(2, login.getEmail());
            comando.setString(3, login.getSenha());

            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar login", e);
        }
    }

    // 2. CONSULTAR: buscar login
    @Override
    public Login buscarPorIdUsuario(Long idUsuario) {
        Login login = null;
        try {
            Connection conexao = new ConnectionFactory().getConnection();
            String sql = "SELECT * FROM TB_SMT_LOGIN WHERE id_usuario = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setLong(1, idUsuario);
            ResultSet rs = comando.executeQuery();

            if (rs.next()) {
                login = new Login();
                login.setIdUsuario(rs.getLong("id_usuario"));
                login.setEmail(rs.getString("email"));
                login.setSenha(rs.getString("senha"));
            }

            rs.close();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar login por idUsuario", e);
        }
        return login;
    }

    @Override
    public Login buscarPorEmail(String email) {
        Login login = null;
        try {
            Connection conexao = new ConnectionFactory().getConnection();
            String sql = "SELECT * FROM TB_SMT_LOGIN WHERE email = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, email);
            ResultSet rs = comando.executeQuery();

            if (rs.next()) {
                login = new Login();
                login.setIdUsuario(rs.getLong("id_usuario"));
                login.setEmail(rs.getString("email"));
                login.setSenha(rs.getString("senha"));
            }

            rs.close();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar login por email", e);
        }
        return login;
    }

    // 3. ALTERAR: atualizar a senha

    public void atualizarSenha(Long idUsuario, String novaSenha) {
        try {
            Connection conexao = new ConnectionFactory().getConnection();
            String sql = "UPDATE TB_SMT_LOGIN SET senha = ? WHERE id_usuario = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, novaSenha);
            comando.setLong(2, idUsuario);

            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar senha", e);
        }
    }


    // 4. DELETAR: remover login
    public void deletar(Long idUsuario) {
        try {
            Connection conexao = new ConnectionFactory().getConnection();
            String sql = "DELETE FROM TB_SMT_LOGIN WHERE id_usuario = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setLong(1, idUsuario);

            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar login", e);
        }
    }



}
