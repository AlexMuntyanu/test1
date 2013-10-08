package com.springapp.notes.repository;

import org.springframework.data.repository.CrudRepository;

import com.springapp.notes.entities.User;

public interface UserRepository extends CrudRepository<User, String> {
}
