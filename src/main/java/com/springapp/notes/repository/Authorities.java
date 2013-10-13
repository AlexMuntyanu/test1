package com.springapp.notes.repository;

import com.springapp.notes.entities.Authority;
import org.springframework.data.repository.CrudRepository;

public interface Authorities  extends CrudRepository<Authority, String> {
}
