package com.springapp.mvc.entities;

import java.sql.Date;

/**
 */
//@Entity
public class NoteImpl {
    private int id;
    private String noteName;
    private String text;
    private Date dateOfCreation;
    private Date dateOfModification;

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public Date getDateOfModification() {
        return dateOfModification;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public void setDateOfModification(Date dateOfModification) {
        this.dateOfModification = dateOfModification;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }
}
