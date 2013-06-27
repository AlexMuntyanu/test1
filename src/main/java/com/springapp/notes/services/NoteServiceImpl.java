package com.springapp.notes.services;

import java.util.List;

import com.springapp.notes.dao.NoteDAO;
import com.springapp.notes.entities.NoteImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl {

    @Autowired
    NoteDAO noteDAO;

    public List<NoteImpl> getNotes() {
        return noteDAO.getNotes();
    }
}