package com.stackroute.userauthentication.repository;
import org.springframework.data.repository.CrudRepository;

import com.stackroute.userauthentication.model.UserDao;
public interface UserRepository extends CrudRepository<UserDao, Integer> {
    UserDao findByUsername(String username);
}