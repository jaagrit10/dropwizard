package com.dropwizard.service;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.Date;
import java.util.List;

public interface DAO {
    @SqlUpdate("create table userData (id int primary key, name varchar(100))")
    void createUserTable();

    @SqlUpdate("insert into userData (id, name) values (:id, :name)")
    void insert(@Bind("id") int id, @Bind("name") String name);

    @SqlUpdate("insert into tasks (taskId, userId, username, status, subject, description, startDate, targetDate) values (:taskId, :userId, :username, :status, :subject, :description, :startDate, :targetDate)")
    void insertTask(@Bind("taskId") String taskId, @Bind("userId") int userId, @Bind("username") String username, @Bind("status") String status, @Bind("subject") String subject, @Bind("description") String description, @Bind("startDate") Date startDate, @Bind("targetDate") Date targetDate);

    @SqlQuery("select name from userData where id = :id")
    String findNameById(@Bind("id") int id);

    @SqlQuery("select name from userData")
    List<String> getAllNames();

    @SqlQuery("select name from userData where id 1")
    String testQuery();

    @SqlQuery("select * from tasks where userId = :userId")
    @RegisterRowMapper(TaskMapper.class)
    List<Task> getTasksForUser(@Bind("userId") int userId);

    @SqlQuery("select * from tasks where taskId = :taskId")
    @RegisterRowMapper(TaskMapper.class)
    Task getTaskByTaskId(@Bind("taskId") String taskId);

    @SqlUpdate("delete from tasks where taskId = :taskId")
    void deleteTaskByTaskId(@Bind("taskId") String taskId);

    @SqlUpdate("replace into tasks (taskId, userId, username, status, subject, description, startDate, targetDate) values (:taskId, :userId, :username, :status, :subject, :description, :startDate, :targetDate)")
    void updateTask(@Bind("taskId") String taskId, @Bind("userId") int userId, @Bind("username") String username, @Bind("status") String status, @Bind("subject") String subject, @Bind("description") String description, @Bind("startDate") Date startDate, @Bind("targetDate") Date targetDate);
}
