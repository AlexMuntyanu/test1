package com.springapp.notes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "NOTES")
public class Note {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    private String noteName;
    private String text;
    private Date dateOfCreation;
    private Date dateOfModification;

    public long getId() {
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

    public void setId(long id) {
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
