package br.com.fiap.biblioteca.controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/testcontroller")
public class TestController {


    @Path("/testcontroller")

    @GET
    public String test() {
        return "Controller funcionando!";
    }
}

