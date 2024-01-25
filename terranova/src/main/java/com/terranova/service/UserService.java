package com.terranova.service;

import com.terranova.exception.UserNotFoundException;
import com.terranova.model.dto.UserDto;
import com.terranova.model.entity.User;
import com.terranova.model.mapper.UserMapper;
import com.terranova.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService implements ICrudService<User,Long> {
    private static final String TABLE_NAME="users";

    protected static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired protected UserRepository repository;
    @Autowired protected UserMapper mapper;

    @Override
    public List<User> findAll() {
        logger.debug("The method findAll has been invoked for the table {}", TABLE_NAME);
        return repository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        logger.debug(
                "The method findById has been invoked for the table {}, with parameter id = {}",
                TABLE_NAME,
                id);
        return repository.findById(id);
    }

    @Override
    public User create(User user) {
        logger.debug(
                "The method create has been invoked for the table {}, with parameter model = {}",
                TABLE_NAME,
                user);
        return repository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        logger.debug("The method delete has been invoked for the table {}, with parameter model = {}",
                TABLE_NAME,
                id);
        return repository.findById(id).map(userTrovato->{
            userTrovato.setNome(user.getNome());
            userTrovato.setCognome(user.getCognome());
            userTrovato.setMail(user.getMail());
            return repository.save(userTrovato);
        }).orElseThrow(
                ()-> new UserNotFoundException("user non trovato con l'id fornito")
        );
    }

    @Override
    public void delete(Long id) {
        logger.debug(
                "The method delete has been invoked for the table {}, with parameter model = {}",
                TABLE_NAME,
                id);
        repository.deleteById(id);
    }
}
