package com.dropwizard.service;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskMapper implements RowMapper<Task> {
    @Override
    public Task map(ResultSet r, StatementContext ctx) throws SQLException {
        return new Task(r.getInt("taskId"), r.getInt("userId"), r.getString("username"), r.getString("status"), r.getString("subject"), r.getString("description"), r.getDate("startDate"), r.getDate("targetDate"));
    }

}
