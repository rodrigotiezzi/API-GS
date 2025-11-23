package br.com.fiap.biblioteca.controller;

import br.com.fiap.biblioteca.dominio.RepositorioUsuarios;
import br.com.fiap.biblioteca.dominio.Usuario;
import br.com.fiap.biblioteca.infra.dao.UsuarioDAO;
import br.com.fiap.biblioteca.service.UsuarioService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/usuarios")
public class UsuarioController {

    private RepositorioUsuarios repositorioUsuarios;
    private UsuarioService usuarioService;

    public UsuarioController() {
        this.repositorioUsuarios = new UsuarioDAO();
        this.usuarioService = new UsuarioService(repositorioUsuarios);
    }

    @POST
    public Response salvar(Usuario usuario) {
        try {
            usuarioService.cadastrarUsuario(usuario);
            return Response.status(Response.Status.CREATED).build();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @GET
    @Path("{cpf}")
    public Response buscarPorCpf(
            @PathParam("cpf") String cpf) {
        Response.Status status = null;
        Usuario usuario = usuarioService.buscarPorCpf(cpf);
        if (usuario == null) status = Response.Status.NOT_FOUND;
        else status = Response.Status.OK;
        return Response
                .status(status)
                .entity(usuario)
                .build();
    }

    @GET
    @Path("/id{cpf}")
    public Response getidUsuario(
            @PathParam("cpf") String cpf) {
        Response.Status status = null;
        Long id = usuarioService.getidUsuario(cpf);
        if (id == null) status = Response.Status.NOT_FOUND;
        else status = Response.Status.OK;
        return Response
                .status(status)
                .entity(id)
                .build();
    }

}
