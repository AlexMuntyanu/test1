package com.springapp.notes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springapp.notes.entities.Note;
import com.springapp.notes.repository.NoteRepository;

@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    public List<Note> getNotes() {
        return noteRepository.findAll();
    }
}