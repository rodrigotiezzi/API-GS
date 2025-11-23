package br.com.fiap.biblioteca.Contoller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UsuarioControllerTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/usuarios";
    }

    @Test
    void testBuscarPorCpf() {
        given()
                .when()
                .get("61472895381")
                .then()
                .statusCode(anyOf(is(200), is(404)));
    }

    @Test
    void testSalvar() {

        String json = """
        {
            "nome": "Usu Teste",
            "cpf": "99999999999",
            "dataNascimento": "2000-01-01",
            "profissaoUsuario": "Tester",
            "logadouro": "Rua A",
            "numero": "100",
            "complemento": "Casa",
            "bairro": "Centro",
            "cidade": "São Paulo",
            "estado": "SP",
            "cep": "00000000"
        }
        """;

        given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post("/")
                .then()
                .statusCode(201);
    }

    @Test
    void testGetIdUsuario() {
        given()
                .when()
                .get("/id/23556298777")
                .then()
                .statusCode(anyOf(is(200), is(404)));
    }
}
