package mx.ipn.cic.collectionsexample.model;

/**
 * Created by jmperezsantos on 11/18/17.
 */

public class Song {

    private String title;

    private String artist;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public Song() {
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }

}
