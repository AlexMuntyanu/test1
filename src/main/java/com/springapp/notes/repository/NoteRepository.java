package com.springapp.notes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springapp.notes.entities.Note;

public interface NoteRepository extends CrudRepository<Note, Long> {
  List<Note> findAll();
}
