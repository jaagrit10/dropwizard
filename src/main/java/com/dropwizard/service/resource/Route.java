package com.dropwizard.service.resource;

import com.dropwizard.service.DAO;
import com.dropwizard.service.User;
import com.google.gson.Gson;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jdbi.v3.core.Jdbi;


import java.util.List;

@Path("/data")
@Produces(MediaType.APPLICATION_JSON)
public class Route {
    DAO dao;
    public Route(Jdbi jdbi) {
        dao = jdbi.onDemand(DAO.class);
//        try {
//            dao.testQuery();
//        } catch (Exception e) {
//            dao.createUserTable();
//        }
    }
    @POST
    @Path("/post")
    @Consumes({ MediaType.APPLICATION_JSON })
    public boolean setData(User user) {
        dao.insert(user.getid(), user.getName());
        return true;
    }
    @GET
    @Path("/get/{id}")
    public String getDataById(@PathParam("id") Integer id) {
        String name = dao.findNameById(id);
        return name;
    }
    @GET
    @Path("/get")
    public String getAllData() {
        List<String> list = dao.getAllNames();
        String str = new Gson().toJson(list);
        return str;
    }

}
