package org.example;

import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
//@Scope("request")
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class WebService {
    private final String message;

    @Inject
    public WebService(final String message) {
        this.message = message;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String message() {
        return message;
    }
}
