package br.com.fiap.biblioteca.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class Usuario {

    @JsonProperty
    private Long idUsuario;

    @JsonProperty
    private String nome;

    @JsonProperty
    private String cpf;

    @JsonProperty
    private Date dataNascimento;

    @JsonProperty
    private String profissaoUsuario;

    @JsonProperty
    private String logadouro;

    @JsonProperty
    private String numero;

    @JsonProperty
    private String complemento;

    @JsonProperty
    private String bairro;

    @JsonProperty
    private String cidade;

    @JsonProperty
    private String estado;

    @JsonProperty
    private String cep;

    public Usuario() {}

    public Usuario(String nome, String cpf, Date dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    // GETTERS
    public Long getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getProfissaoUsuario() {
        return profissaoUsuario;
    }

    public String getLogadouro() {
        return logadouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    // SETTERS
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setProfissaoUsuario(String profissaoUsuario) {
        this.profissaoUsuario = profissaoUsuario;
    }

    public void setLogadouro(String logadouro) {
        this.logadouro = logadouro;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
