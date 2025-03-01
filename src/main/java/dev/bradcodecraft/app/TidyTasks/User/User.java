package dev.bradcodecraft.app.TidyTasks.User;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
  @Id
  private Integer userId;
  private String userName;
  private String userPassword;
  private String userEmail;
  private LocalDateTime userJoinDate;

  public User(Integer userId, String userName, String userPassword, String userEmail, LocalDateTime userJoinDate) {
    this.userId = userId;
    this.userName = userName;
    this.userPassword = userPassword;
    this.userEmail = userEmail;
    this.userJoinDate = userJoinDate;
  }

  public Integer getUserId() {
    return this.userId;
  }

  public String getUserName() {
    return this.userName;
  }

  public String getUserPassword() {
    return this.userPassword;
  }

  public String getUserEmail() {
    return this.userEmail;
  }

  public LocalDateTime getUserJoinDate() {
    return this.userJoinDate;
  }
}
