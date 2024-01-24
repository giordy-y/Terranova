package com.terranova.controller;

import com.terranova.exception.CustomException;
import com.terranova.model.entity.User;
import com.terranova.service.UserService;
import com.terranova.exception.EsecuzioneErrataException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOError;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/user")
public class UserController {
    @Autowired private final UserService service;

    @GetMapping(path = "tutti")
    public ResponseEntity<List<User>> getListaUser(String autenitcato)
            throws EsecuzioneErrataException {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping(path = "byId")
    public ResponseEntity<Optional<User>> getUserById(Long id)
        throws EsecuzioneErrataException{
        return ResponseEntity.ok(service.findById(id));
    }
    @PostMapping(path = "createUser")
    public ResponseEntity<User> createUser(@RequestBody User user)
        throws EsecuzioneErrataException{
        return ResponseEntity.ok(service.create(user));
    }
    @PutMapping(path = "updateUser")
    public ResponseEntity<User> updateUser(User user)
        throws EsecuzioneErrataException {
        return ResponseEntity.ok(service.update(user));
    }
    @DeleteMapping(path = "deleteUser/{id}")
    public void deleteUser(@PathVariable Long id)
        throws IOException, CustomException{
        service.delete(id);
    }

}

