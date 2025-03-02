package dev.bradcodecraft.app.TidyTasks.User;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public class UserRepository {
  private JdbcClient jdbcClient;

  public UserRepository(JdbcClient jdbcClient) {
    this.jdbcClient = jdbcClient;
  }

  // CREATE
  public void create(User user) {
    Integer status = this.jdbcClient.sql("INSERT INTO \"user\" VALUES (?, ?, ?, ?, ?)")
        .params(List.of(user.getUserId(), user.getUserName(), user.getUserPassword(), user.getUserEmail(),
            user.getUserJoinDate()))
        .update();

    Assert.state(status == 1, "Failed to create user " + user.getUserId());
  }

  // READ
  public List<User> readAll() {
    return this.jdbcClient.sql("SELECT * FROM \"user\" ORDER BY user_id")
        .query(User.class)
        .list();
  }

  public Optional<User> readById(Integer userId) {
    return this.jdbcClient.sql("SELECT * FROM \"user\" WHERE user_id = ?")
        .param(userId)
        .query(User.class)
        .optional();
  }

  // UPDATE
  //
  // DELETE
}
