package com.springapp.mvc.services;

import java.util.List;

import com.springapp.mvc.dao.NoteDAO;
import com.springapp.mvc.entities.NoteImpl;
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