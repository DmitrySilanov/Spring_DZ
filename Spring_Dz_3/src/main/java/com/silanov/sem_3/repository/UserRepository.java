package com.silanov.sem_3.repository;

import com.silanov.sem_3.domain.User;
import com.silanov.sem_3.utils.UserMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepository {

    private final JdbcTemplate jdbc;

    private final UserMapper userMapper;

    public UserRepository(JdbcTemplate jdbc, UserMapper userMapper) {
        this.jdbc = jdbc;
        this.userMapper = userMapper;
    }


    public List<User> getUsers() {
        String sql = "select * from \"user\"";
        return jdbc.query(sql, userMapper);
    }

    public void addUser(User user){
        String sql = "insert into \"user\" (name, age, email) values (?, ?, ?)";
        jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
    }

}