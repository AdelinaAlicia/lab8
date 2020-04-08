package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AlbumController {
    public AlbumController() { }

    public void create(String name, int artistId, int releaseYear) {
        try {
            Connection con = Database.getConn("STUDENT", "STUDENT");
            String sql = "INSERT INTO albums (name, artist_id, release_year) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, artistId);
            pstmt.setInt(3, releaseYear);
            pstmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void findByArtist(int artistId) {
        try {
            Connection con = Database.getConn("STUDENT", "STUDENT");
            String sql = "SELECT * FROM albums WHERE artist_id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, artistId);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
                System.out.println("[album.findByArtist] ID: " + rs.getInt(1) + ", Name: " + rs.getString(2) + ", ID Artist: " + rs.getInt(3) + ", Release Year: " + rs.getString(4));
            con.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
