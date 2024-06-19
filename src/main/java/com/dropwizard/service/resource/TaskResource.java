package com.dropwizard.service.resource;

import com.dropwizard.service.DAO;
import com.dropwizard.service.Task;
import com.dropwizard.service.services.TaskService;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jdbi.v3.core.Jdbi;



@Path("/task")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
@Tag(name = "Task Resource")

public class TaskResource {
    DAO dao;
    private final TaskService taskService;
    public TaskResource(Jdbi jdbi, TaskService taskService){
        dao = jdbi.onDemand(DAO.class);
        this.taskService = taskService;
    }


    @POST
    @Path("/add")
    @Consumes({MediaType.APPLICATION_JSON})
    @UnitOfWork
    @Operation(
            summary = "add task",
            description = "adds task for a particular user",
            responses = {@ApiResponse(responseCode = "200", description = "success")})
    public Response addTask(Task task){
        return taskService.addTask(task);
    }

    @GET
    @Path("/get/{userId}")
    @Produces({MediaType.APPLICATION_JSON})
    @Operation(
            summary = "get tasks for user",
            description = "get all tasks for a particular user"
    )
    public Response getTask(@PathParam("userId") int userId){
        return taskService.getTasksForUser(userId);
    }

    @GET
    @Path("/get/{userId}/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "get task for a user",
            description = "get a particular task for a particular user"
    )
    public Response getTaskByTaskId( @PathParam("taskId") int taskId){
        return taskService.getTaskByTaskId(taskId);
    }

    @DELETE
    @Path("/delete/{taskId}")
    @Operation(
            summary = "delete task for a user",
            description = "delete a particular task for a particular user"
    )

    public Response deleteTaskByTaskId(@PathParam("taskId") int taskId){
        return taskService.deleteTaskByTaskId(taskId);
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "update task for a user",
            description = "update a particular task for a particular user"
    )
    public Response updateTaskByTaskId(Task task){
        return taskService.updateTaskByTaskId(task);
    }



}
