package com.dropwizard.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.util.Date;

public class Task {
    @ColumnName("taskId")
    private int taskId;
    @ColumnName("userId")
    private int userId;
    @ColumnName("username")
    private String username;
    @ColumnName("status")
    private String status;
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

    public Task(int userId, String username, String status, String subject, String description, Date startDate, Date targetDate) {
        this.userId = userId;
        this.username = username;
        this.status = status;
        this.subject = subject;
        this.description = description;
        this.startDate = startDate;
        this.targetDate = targetDate;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setStatus(String status) {
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

    public Task(int taskId, int userId, String username, String status, String subject, String description, Date startDate, Date targetDate) {
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
    public int getTaskId() {
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
    public String getStatus() {
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
