package com.terranova.controller;

import com.terranova.exception.CustomException;
import com.terranova.exception.EsecuzioneErrataException;
import com.terranova.model.entity.User;
import com.terranova.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/user")
public class UserController {
    @Autowired
    private final UserService service;

    @GetMapping(path = "tutti")
    public ResponseEntity<List<User>> getListaUser()
            throws EsecuzioneErrataException {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping(path = "byId/{iDUser}")
    public ResponseEntity<User> getUserByIDAnagrafica(@PathVariable Long iDUser)
            throws EsecuzioneErrataException{
        return ResponseEntity.ok(service.findById(iDUser));
    }
    @PostMapping(path = "createUser")
    public ResponseEntity<User> createUser(@RequestBody User user)
            throws EsecuzioneErrataException{
        return ResponseEntity.ok(service.create(user));
    }
    @PutMapping(path = "updateUser/{iDUser}")
    public ResponseEntity<User> updateUser(@PathVariable Long iDUser,@RequestBody User user)
            throws EsecuzioneErrataException {
        return ResponseEntity.ok(service.update(iDUser, user));
    }
    @DeleteMapping(path = "deleteUser/{iDUser}")
    public void deleteUser(@PathVariable Long iDUser)
            throws IOException, CustomException {
        service.delete(iDUser);
    }

}