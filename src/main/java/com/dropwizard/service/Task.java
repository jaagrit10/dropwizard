package com.dropwizard.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Task {
    @JsonIgnore
    private int taskId;
    private int userId;
    private String username;
    private String status;
    private String subject;
    private String description;
    private Date startDate;
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
