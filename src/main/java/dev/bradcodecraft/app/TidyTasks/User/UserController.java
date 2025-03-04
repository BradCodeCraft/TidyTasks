package dev.bradcodecraft.app.TidyTasks.User;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.bradcodecraft.app.TidyTasks.User.Exceptions.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
  private UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  // CREATE
  @PostMapping("/sign-up")
  public void create(@RequestBody User user) {
    List<User> users = this.userRepository.readAll();

    if (user.getUserId() == users.size()) {
      throw new UserAlreadyExistsException();
    }

    this.userRepository.create(user);
  }

  // READ
  @GetMapping("")
  public List<User> readAll() {
    return this.userRepository.readAll();
  }

  @GetMapping("/{userId}")
  public User readById(@PathVariable Integer userId) {
    Optional<User> optionalUser = this.userRepository.readById(userId);

    if (optionalUser.isEmpty()) {
      throw new UserNotFoundException();
    }

    return optionalUser.get();
  }

  // UPDATE
  @PutMapping("/{userId}")
  public void updateById(@PathVariable Integer userId, @RequestBody User user) {
    Optional<User> optionalUser = this.userRepository.readById(userId);

    if (optionalUser.isEmpty()) {
      throw new UserNotFoundException();
    } else {
      this.userRepository.updateById(userId, user);
    }
  }

  // DELETE
  @DeleteMapping("/{userId}")
  public void deleteById(@PathVariable Integer userId) {
    Optional<User> optionalUser = this.userRepository.readById(userId);

    if (optionalUser.isEmpty()) {
      throw new UserNotFoundException();
    } else {
      this.userRepository.deleteById(userId);
    }
  }
}
