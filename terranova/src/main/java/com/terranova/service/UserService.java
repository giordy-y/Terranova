package com.terranova.service;

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
    public User create(User model) {
        logger.debug(
                "The method create has been invoked for the table {}, with parameter model = {}",
                TABLE_NAME,
                model);
        return repository.save(model);
    }

    @Override
    public User update(User model) {
        logger.debug(
                "The method update has been invoked for the table {}, with parameter model = {}",
                TABLE_NAME,
                model);
        return repository.save(model);
    }

    @Override
    public void delete(User model) {
        logger.debug(
                "The method delete has been invoked for the table {}, with parameter model = {}",
                TABLE_NAME,
                model);
        repository.delete(model);
    }
}
