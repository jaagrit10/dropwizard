package com.dropwizard.service.resource;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/health/{name}")
@Tag(name = "Health Check Resource")
public class HealthCheckResource {
    @GET
    @Operation
    public String isHealthy(@PathParam("name") String name){
        return "Service is Up!, " + name.toUpperCase();
    }
}
