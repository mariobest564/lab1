package mk.finki.ukim.mk.lab.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Song {
    public String trackId;
    public String title;
    public String genre;
    public int releaseYear;
    public List<Artist> performers = new ArrayList<>();
    private Long id;
    private Album album;

    public Song(String trackId, String title, String genre, int releaseYear, Artist performer, Long id, Album album) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers.add(performer);
        this.id = id;
        this.album = album;
    }
}
