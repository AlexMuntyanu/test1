package com.springapp.mvc.dao;

import java.util.List;

import com.springapp.mvc.entities.NoteImpl;

/**
 */
public interface NoteDAO {
    public List<NoteImpl> getNotes();
}
