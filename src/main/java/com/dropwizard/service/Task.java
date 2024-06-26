package com.dropwizard.service;

import com.dropwizard.service.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.ws.rs.DefaultValue;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.util.Date;

public class Task {
    @ColumnName("taskId")
    private String taskId;
    @ColumnName("userId")
    private int userId;
    @ColumnName("username")
    private String username;
    @ColumnName("status")
    private StatusEnum status;
    @ColumnName("subject")
    private String subject;
    @ColumnName("description")
    private String description;
    @ColumnName("startDate")
    private Date startDate;
    @ColumnName("targetDate")
    private Date targetDate;

    public Task() {
    }

    public Task(int userId, String username, StatusEnum status, String subject, String description, Date startDate, Date targetDate) {
        this.userId = userId;
        this.username = username;
        this.status = status;
        this.subject = subject;
        this.description = description;
        this.startDate = startDate;
        this.targetDate = targetDate;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public Task(String taskId, int userId, String username, StatusEnum status, String subject, String description, Date startDate, Date targetDate) {
        this.taskId = taskId;
        this.userId = userId;
        this.username = username;
        this.status = status;
        this.subject = subject;
        this.description = description;
        this.startDate = startDate;
        this.targetDate = targetDate;
    }

    @JsonProperty
    public String getTaskId() {
        return taskId;
    }
    @JsonProperty
    public int getUserId() {
        return userId;
    }
    @JsonProperty
    public String getUsername() {
        return username;
    }
    @JsonProperty
    public StatusEnum getStatus() {
        return status;
    }
    @JsonProperty
    public String getSubject() {
        return subject;
    }
    @JsonProperty
    public String getDescription() {
        return description;
    }
    @JsonProperty
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    public Date getStartDate() {
        return startDate;
    }
    @JsonProperty
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    public Date getTargetDate() {
        return targetDate;
    }


}
