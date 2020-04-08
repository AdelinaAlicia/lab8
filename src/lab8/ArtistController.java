package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ArtistController {
    public ArtistController() { }

    public void create(String name, String country) {
        try {
            Connection con = Database.getConn("STUDENT", "STUDENT");
            String sql = "INSERT INTO artists (name, country) VALUES (?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, country);
            pstmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void findByName(String name) {
        try {
            Connection con = Database.getConn("STUDENT", "STUDENT");
            String sql = "SELECT * FROM artists WHERE name = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
                System.out.println("[artist.findByName] ID: " + rs.getInt(1) + ", Name: " + rs.getString(2) + ", Country: " + rs.getString(3));
            con.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
