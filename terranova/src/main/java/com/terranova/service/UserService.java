package com.terranova.service;

import com.terranova.exception.ContattoNotFoundException;
import com.terranova.model.entity.User;
import com.terranova.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements ICrudService<User,Long> {
    private static final String TABLE_NAME="Sedi";
    protected static final Logger logger = LoggerFactory.getLogger(UserService.class);


    @Autowired
    protected UserRepository repository;

    @Override
    public List<User> findAll() {
        logger.debug("The method findAll has been invoked for the table {}", TABLE_NAME);
        return repository.findAll();
    }

    @Override
    public User findById(Long iDUser) {
        logger.debug(
                "The method findByID has been invoked for the table {}, with parameter ID = {}",
                TABLE_NAME,
                iDUser);
        return  repository.findById(iDUser).orElseThrow(()->new ContattoNotFoundException("nussun Contatto presente con questo IDUser"));
    }

    @Override
    public User create(User User) {
        logger.debug(
                "The method create has been invoked for the table {}, with parameter model = {}",
                TABLE_NAME,
                User);
        return repository.save(User);
    }

    @Override
    public User update(Long iDUser, User user) {
        logger.debug("The method delete has been invoked for the table {}, with parameter model = {}",
                TABLE_NAME,
                iDUser);
        return repository.findById(iDUser).map(UserTrovato->{
            UserTrovato.setNome(user.getNome());
            UserTrovato.setCognome(user.getCognome());
            UserTrovato.setEmail(user.getEmail());
            UserTrovato.setPassword(user.getPassword());
            return repository.save(UserTrovato);
        }).orElseThrow(
                ()-> new ContattoNotFoundException("Contatto non trovato con l'id fornito")
        );
    }

    @Override
    public void delete(Long iDUser) {
        logger.debug(
                "The method delete has been invoked for the table {}, with parameter model = {}",
                TABLE_NAME,
                iDUser);
        repository.deleteById(iDUser);
    }
}

