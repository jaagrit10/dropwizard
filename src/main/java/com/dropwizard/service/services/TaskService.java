package com.dropwizard.service.services;

import com.dropwizard.service.DAO;
import com.dropwizard.service.Task;
import com.dropwizard.service.enums.StatusEnum;
import jakarta.ws.rs.core.Response;
import org.jdbi.v3.core.Jdbi;

import java.util.Objects;

public class TaskService {
    DAO dao;
    public TaskService(Jdbi jdbi){
        dao = jdbi.onDemand(DAO.class);
    }

    public Response addTask(Task task){
        try {
            dao.insertTask(task.getUserId(),
                    task.getUsername(),
                    (Objects.isNull(task.getStatus())) ? StatusEnum.TODO.toString() : task.getStatus().toString(),
                    task.getSubject(),
                    task.getDescription(),
                    task.getStartDate(),
                    task.getTargetDate());
            return Response.ok("Task added Successfully").build();

        } catch (Exception e)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }

    public Response getTasksForUser(int userId){
        try{
            return Response
                    .ok(dao.getTasksForUser(userId))
                    .build();
        } catch (Exception e){
            return Response
                    .status(500, e.getMessage())
                    .build();
        }

    }

    public Response deleteTaskByTaskId(int taskId){
        try{
            dao.deleteTaskByTaskId(taskId);
            return Response
                    .ok("Task Deleted Successfully!")
                    .build();
        } catch (Exception e){
            return Response
                    .status(500, e.getMessage())
                    .build();
        }

    }

    public Response getTaskByTaskId(int taskId){
        try{
            return Response
                    .ok(dao.getTaskByTaskId(taskId))
                    .build();
        } catch (Exception e){
            return Response
                    .status(500, e.getMessage())
                    .build();
        }

    }

    public Response updateTaskByTaskId(Task task, int taskId, StatusEnum status){
        Task taskToBeUpdated = dao.getTaskByTaskId(taskId);
        if (Objects.isNull(taskToBeUpdated)){
            return Response.ok("No task with the given Task Id found, please select the correct taskId").build();
        }
        if (!(Objects.isNull(status)))  taskToBeUpdated.setStatus(status);
        if (!Objects.isNull(task) && !(Objects.isNull(task.getSubject())))   taskToBeUpdated.setSubject(task.getSubject());
        if (!Objects.isNull(task) && !(Objects.isNull(task.getDescription())))   taskToBeUpdated.setDescription(task.getDescription());
        if (!Objects.isNull(task) && !(Objects.isNull(task.getStartDate())))   taskToBeUpdated.setStartDate(task.getStartDate());
        if (!Objects.isNull(task) && !(Objects.isNull(task.getTargetDate())))   taskToBeUpdated.setTargetDate(task.getTargetDate());
        try{
            dao.updateTask(taskId,
                    taskToBeUpdated.getUserId(),
                    taskToBeUpdated.getUsername(),
                    taskToBeUpdated.getStatus().toString(),
                    taskToBeUpdated.getSubject(),
                    taskToBeUpdated.getDescription(),
                    taskToBeUpdated.getStartDate(),
                    taskToBeUpdated.getTargetDate());
            return Response
                    .ok(dao.getTaskByTaskId(taskId))
                    .build();
        } catch (Exception e){
            return Response
                    .status(500, e.getMessage())
                    .build();
        }

    }
}
