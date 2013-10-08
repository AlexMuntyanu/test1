package com.springapp.notes.repository;


import com.springapp.notes.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
