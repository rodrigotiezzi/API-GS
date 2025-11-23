package br.com.fiap.biblioteca.infra;
import br.com.fiap.biblioteca.infra.dao.ConnectionFactory;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

public class ConnectonFactory {

    public static void main(String[] args) {

        System.out.println("Testando conexão com o banco Oracle...");

        try (Connection conn = new ConnectionFactory().getConnection()) {

            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();

                System.out.println("✔ Conexão bem-sucedida!");
                System.out.println("Banco conectado: " + meta.getDatabaseProductName());
                System.out.println("Versão: " + meta.getDatabaseProductVersion());
            } else {
                System.out.println("❌ Conexão retornou null!");
            }

        } catch (Exception e) {
            System.out.println("❌ Erro ao conectar ao banco:");
            e.printStackTrace();
        }
    }
}
