package com.dropwizard.service.resource;

import com.dropwizard.service.DAO;
import com.dropwizard.service.Task;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jdbi.v3.core.Jdbi;

@Path("/{user}/task")
@Produces(MediaType.APPLICATION_JSON)
public class TaskResource {
    DAO dao;
    public TaskResource(Jdbi jdbi){
        dao = jdbi.onDemand(DAO.class);
    }

    @POST
    @Path("/add")
    @Consumes({MediaType.APPLICATION_JSON})
    public boolean addTask(Task task){
        dao.insertTask(task.getUserId(), task.getUsername(), task.getStatus(), task.getSubject(), task.getDescription(), task.getStartDate(), task.getTargetDate());
        return true;
    }

}
