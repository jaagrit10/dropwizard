package com.dropwizard.service.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/health/{name}")
public class HealthCheckResource {
    @GET
    public String isHealthy(@PathParam("name") String name){
        return "Service is Up!, " + name.toUpperCase();
    }
}
