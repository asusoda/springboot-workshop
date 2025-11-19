package com.example.soda_workshop;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Map<String, User> users = new ConcurrentHashMap<>();

    @GetMapping
    public Collection<User> allUsers() {
        // Implement the logic to return all users
        return users.values();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser) {
        // Implement the logic to create a new user
        if (newUser.getAsurite() == null || newUser.getAsurite().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "asurite is required");
        }
        users.put(newUser.getAsurite(), newUser);
        return newUser;
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteUser(@RequestBody User user) {
        User removed = users.remove(user.getAsurite());
        if (removed == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No user with asurite " + user.getAsurite() + " was found.");
        }
        return ResponseEntity.ok("Removed user " + user.getAsurite() + ".");
    }

    @PutMapping("/{asurite}")
    public ResponseEntity<String> updateUser(@PathVariable String asurite, @RequestBody User updates) {
        User existing = users.get(asurite);
        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No user with asurite " + asurite + " was found.");
        }

        if (updates.getName() != null) {
            existing.setName(updates.getName());
        }
        if (updates.getNumber() != null) {
            existing.setNumber(updates.getNumber());
        }

        return ResponseEntity.ok("Updated user " + asurite + ".");
    }
}

