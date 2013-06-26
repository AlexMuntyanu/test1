package com.springapp.mvc.services;

import java.util.List;

import com.springapp.mvc.entities.NoteImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl {
    @Autowired
    private DBService dbService;


    public List<NoteImpl> getNotes() {
        try {
            return dbService.getNoteList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}