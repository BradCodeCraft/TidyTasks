package dev.bradcodecraft.app.TidyTasks.User;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
  private JdbcClient jdbcClient;

  public UserRepository(JdbcClient jdbcClient) {
    this.jdbcClient = jdbcClient;
  }

  // CREATE
  //
  // READ
  public List<User> readAllUsers() {
    return this.jdbcClient.sql("SELECT * FROM \"user\" ORDER BY user_id")
        .query(User.class)
        .list();
  }

  public Optional<User> readUserById(Integer userId) {
    return this.jdbcClient.sql("SELECT * FROM \"user\" WHERE user_id = ?")
        .param(userId)
        .query(User.class)
        .optional();
  }

  // UPDATE
  //
  // DELETE
}
