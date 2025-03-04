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
  public void updateById(Integer userId, User user) {
    Integer status = this.jdbcClient.sql(
        "UPDATE \"user\" SET user_name = ?, user_password = ?, user_email = ?, user_join_date = ? WHERE user_id = ?")
        .params(
            List.of(user.getUserName(), user.getUserPassword(), user.getUserEmail(), user.getUserJoinDate(), userId))
        .update();

    Assert.state(status == 1, "Failed to update user " + userId);
  }

  // DELETE
  public void deleteById(Integer userId) {
    Integer status = this.jdbcClient.sql("DELETE FROM \"user\" WHERE user_id = ?")
        .param(userId)
        .update();

    Assert.state(status == 1, "Failed to delete user " + userId);
  }
}
