package com.dropwizard.service;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface DAO {
    @SqlUpdate("create table userData (id int primary key, name varchar(100))")
    void createUserTable();

    @SqlUpdate("insert into userData (id, name) values (:id, :name)")
    void insert(@Bind("id") int id, @Bind("name") String name);

    @SqlQuery("select name from userData where id = :id")
    String findNameById(@Bind("id") int id);

    @SqlQuery("select name from userData")
    List<String> getAllNames();

    @SqlQuery("select name from userData where id 1")
    String testQuery();
}
