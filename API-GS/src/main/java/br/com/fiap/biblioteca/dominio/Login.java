package br.com.fiap.biblioteca.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Login {

    @JsonProperty
    private Long idUsuario; // FK para TB_SMT_USUARIO

    @JsonProperty
    private String email;

    @JsonProperty
    private String senha;

    public Login() {}

    public Login(Long idUsuario, String email, String senha) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.senha = senha;
    }

    // GETTERS
    public Long getIdUsuario() {
        return idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    // SETTERS
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
