package com.dropwizard.service.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/health/{name}")
public class HealthCheckResource {
    @GET
    public String isHealthy(@PathParam("name") String name){
        return "Service is Up!, " + name.toUpperCase();
    }
}
