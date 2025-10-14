package org.example.demoproject.Controller;

import org.example.demoproject.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //  Create user
    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody String userJson) throws IOException {
        return userService.createUser(userJson);
    }

    //  List users
    @GetMapping("/get")
    public ResponseEntity<String> listUsers() throws IOException {
        return userService.listUsers();
    }

    //  Get user by ID / UID
    @GetMapping("/{id}")
    public ResponseEntity<String> getUser(@PathVariable String id) throws IOException {
        return userService.getUser(id);
    }

    //  Update user
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id, @RequestBody String userJson) throws IOException {
        return userService.updateUser(id, userJson);
    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) throws IOException {
        return userService.deleteUser(id);
    }
}
