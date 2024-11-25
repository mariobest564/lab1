package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;

import java.util.List;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    Song findByTrackId(String trackId);
    void createSong(String title, String trackId, String genre, int releaseYear, Long albumId);

    void updateSong(Long songId, String title, String trackId, String genre, int releaseYear, Long albumId);

    void deleteById(Long id);
}
