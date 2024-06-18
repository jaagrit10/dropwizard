package com.dropwizard.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jdbi.v3.core.mapper.reflect.ColumnName;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Task {
    @JsonIgnore
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
