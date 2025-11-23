package br.com.fiap.biblioteca.infra;

import br.com.fiap.biblioteca.infra.dao.UsuarioDAO;
import br.com.fiap.biblioteca.dominio.Usuario;
import java.util.List;

public class TesteUsuarioDAO {

    public static void main(String[] args) {

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // ===== TESTE 1: BUSCAR POR CPF =====
        System.out.println("\n=== BUSCAR POR CPF ===");
        try {
            Usuario usuario = usuarioDAO.buscarPorCpf("61472895381"); // coloque um cpf existente
            if (usuario != null) {
                System.out.println("Usuário encontrado: " + usuario);
            } else {
                System.out.println("Nenhum usuário com esse CPF.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar usuário:");
            e.printStackTrace();
        }

    }
}
