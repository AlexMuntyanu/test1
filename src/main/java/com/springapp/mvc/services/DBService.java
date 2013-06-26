package com.springapp.mvc.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.springapp.mvc.entities.NoteImpl;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    private List<NoteImpl> listOfNotes = new ArrayList<NoteImpl>();

    public List<NoteImpl> getNoteList() throws Exception {
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.
                getConnection("jdbc:h2:~/test", "sa", "");
        // add application code here
        Statement s = connection.createStatement();

        try {
            s.execute("DROP TABLE NOTES");
        } catch (SQLException sqle) {
            System.out.println("Table not found, not dropping");
        }
        s.execute("CREATE TABLE NOTES (ID INT PRIMARY KEY, NOTE_NAME VARCHAR(64), TEXT VARCHAR(64), CREATED DATE (64), UPDATED DATE (64))");
        for (int i=0; i<10; i++){
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT into NOTES (ID,NOTE_NAME,TEXT) values (");
            sb.append(i).append(",")
                    .append("'Name_").append(i).append("',")
                    .append("'some text here'")
                    //.append(",")
                    //.append(new Date(System.currentTimeMillis() - i * 500000000)).append(",")
                    //.append(new Date(System.currentTimeMillis() - i * 10000)).append(")")
                    .append(");");

            PreparedStatement insert = connection.prepareStatement(sb.toString());
            insert.execute();
        }

        PreparedStatement ps = connection.prepareStatement("select * from NOTES");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            NoteImpl note = new NoteImpl();
            note.setId(rs.getInt("ID"));
            note.setNoteName(rs.getString("NOTE_NAME"));
            note.setText(rs.getString("TEXT"));
            listOfNotes.add(note);

            StringBuilder sb = new StringBuilder(rs.getString("NOTE_NAME"));
            sb.append(rs.getString("TEXT"))
                    .append(rs.getDate("CREATED"))
                    .append(rs.getDate("UPDATED"));
            System.out.println(sb);

        }
        connection.close();
        return listOfNotes;
    }
}