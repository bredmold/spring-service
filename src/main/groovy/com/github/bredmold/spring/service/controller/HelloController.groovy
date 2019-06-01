package com.github.bredmold.spring.service.controller

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path('/')
class HelloController {
    @GET
    @Path('hello')
    String hello() {
        return 'hello'
    }

    @GET
    @Path('json')
    @Produces(MediaType.APPLICATION_JSON)
    json() {
        [
                hello: 'hello'
        ]
    }
}
