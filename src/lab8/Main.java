package com.company;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection con = Database.getConn("STUDENT","STUDENT");

        ArtistController artist = new ArtistController();
        AlbumController album = new AlbumController();

        artist.create("Miles Davis", "USA");
        artist.create("Elvis Presley", "USA");

        album.create("Kind of Blue", 1, 1955);
        album.create("Elvis Presley", 2, 1965);
        album.create("The Sun Sessions", 2, 1975);

        artist.findByName("Elvis Presley");
        album.findByArtist(2);
    }
}
