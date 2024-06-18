package com.dropwizard.service.resource;

import com.dropwizard.service.DAO;
import com.dropwizard.service.Task;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jdbi.v3.core.Jdbi;

import java.util.List;


@Path("/task")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
@Tag(name = "Task Resource")

public class TaskResource {
    DAO dao;
    public TaskResource(Jdbi jdbi){
        dao = jdbi.onDemand(DAO.class);
    }


    @POST
    @Path("/add")
    @Consumes({MediaType.APPLICATION_JSON})
    @UnitOfWork
    @Operation(
            summary = "add task",
            description = "adds task for a particular user",
            responses = {@ApiResponse(responseCode = "200", description = "success")})
    public boolean addTask(Task task){
        dao.insertTask(task.getUserId(), task.getUsername(), task.getStatus(), task.getSubject(), task.getDescription(), task.getStartDate(), task.getTargetDate());
        return true;
    }

    @GET
    @Path("/get/{userId}")
    @Produces({MediaType.APPLICATION_JSON})
    @Operation(
            summary = "get tasks for user",
            description = "get all tasks for a particular user"
    )
    public List<Task> getTask(@PathParam("userId") int userId){
        System.out.println(dao.getTasksForUser(userId));
        return dao.getTasksForUser(userId);
    }

    @GET
    @Path("/get/{userId}/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "get task for a user",
            description = "get a particular task for a particular user"
    )
    public Task getTaskByTaskId( @PathParam("taskId") int taskId){
        return dao.getTaskByTaskId(taskId);
    }

    @DELETE
    @Path("/delete/{taskId}")
    @Operation(
            summary = "delete task for a user",
            description = "delete a particular task for a particular user"
    )

    public boolean deleteTaskByTaskId(@PathParam("taskId") int taskId){
        dao.deleteTaskByTaskId(taskId);
        return true;
    }



}
