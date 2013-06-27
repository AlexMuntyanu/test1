package com.springapp.notes.dao;

import java.util.List;

import com.springapp.notes.entities.NoteImpl;

/**
 */
public interface NoteDAO {
    public List<NoteImpl> getNotes();
}
