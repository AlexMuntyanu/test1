package com.springapp.notes.dao.impl;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.springapp.notes.dao.NoteDAO;
import com.springapp.notes.entities.NoteImpl;
import org.springframework.stereotype.Repository;

/**
 */
//@Repository
public class JdbcNoteDAO implements NoteDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<NoteImpl> getNotes(){
        String sql = "select * from NOTES";
        List<NoteImpl> listOfNotes = new ArrayList<NoteImpl>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                NoteImpl note = new NoteImpl();
                note.setId(rs.getInt("ID"));
                note.setNoteName(rs.getString("NOTE_NAME"));
                note.setText(rs.getString("TEXT"));
                ;
                listOfNotes.add(note);
            }
        } catch (SQLException e) {
            System.out.println("sql shit");
        }
        return listOfNotes;
    }

}
