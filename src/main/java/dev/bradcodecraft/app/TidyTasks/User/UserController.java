package dev.bradcodecraft.app.TidyTasks.User;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
  private UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  // CREATE
  //
  // READ
  @GetMapping("")
  public List<User> readAllUsers() {
    return this.userRepository.readAllUsers();
  }

  @GetMapping("/{userId}")
  public User readUserById(@PathVariable Integer userId) {
    Optional<User> optionalUser = this.userRepository.readUserById(userId);

    if (optionalUser.isEmpty()) {
      throw new UserNotFoundException();
    }

    return optionalUser.get();
  }

  // UPDATE
  //
  // DELETE
}
