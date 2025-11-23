package br.com.fiap.biblioteca.controller;

import br.com.fiap.biblioteca.dominio.Login;
import br.com.fiap.biblioteca.dominio.RepositorioLogin;
import br.com.fiap.biblioteca.infra.dao.LoginDAO;
import br.com.fiap.biblioteca.service.LoginService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/login")
public class LoginController {

    private RepositorioLogin repositorioLogin;
    private LoginService loginService;

    public LoginController() {
        this.repositorioLogin = new LoginDAO();
        this.loginService = new LoginService(repositorioLogin);
    }


    // Criar novo login
    @POST
    public Response salvar(Login login) {
        try {
            loginService.cadastrarLogin(login);
            return Response.status(Response.Status.CREATED).build();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        }
    }


    // Buscar login pelo idUsuario
    @GET
    @Path("{idUsuario}")
    public Response buscarPorIdUsuario(@PathParam("idUsuario") Long idUsuario) {
        Response.Status status = null;
        Login login = loginService.buscarPorIdUsuario(idUsuario);
        if (login == null) status = Response.Status.NOT_FOUND;
        else status = Response.Status.OK;
        return Response
                .status(status)
                .entity(login)
                .build();
    }

    // Buscar login pelo email

    @GET
    @Path("/email/{email}")
    public Response buscarPorEmail(@PathParam("email") String email) {
        Response.Status status = null;
        Login login = loginService.buscarPorEmail(email);
        if (login == null) status = Response.Status.NOT_FOUND;
        else status = Response.Status.OK;
        return Response
                .status(status)
                .entity(login)
                .build();
    }

    // Endpoint para trocar a senha
    @PUT
    @Path("/{idUsuario}/senha/{novaSenha}")
    public Response trocarSenha(
            @PathParam("idUsuario") Long idUsuario,
            @PathParam("novaSenha") String novaSenha) {
        try {
            loginService.alterarSenha(idUsuario, novaSenha);
            return Response.status(Response.Status.OK).build();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        }
    }

    //DELETAR - Para apagar o login e o id
    @DELETE
    @Path("/deletar/{email}/{senha}")
    public Response deletarLoginPorEmailESenha(
            @PathParam("email") String email,
            @PathParam("senha") String senha) {
        try {
            loginService.deletarLogineUsuario(email, senha);
            return Response.status(Response.Status.OK).build();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }


}
