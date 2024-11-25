package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.seeder.DatabaseSeeder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository {
    private final List<Song> songs = new ArrayList<>();

    public SongRepository() {
        songs.addAll(DatabaseSeeder.initialSongs);
    }

    public List<Song> findAll() {
        return songs;
    }

    public Song findByTrackId(String id) {
        for(Song s : songs) {
            if (s.getTrackId().equals(id)) {
                return s;
            }
        }
        return null;
    }

   public Artist addArtistToSong(Artist artist, Song song) {
        if (!song.getPerformers().contains(artist)) {
            song.getPerformers().add(artist);
        }
        return artist;
    }

    public void save(Song song) {
        songs.add(song);
    }

    public Boolean deleteById(Long id) {
        return songs.removeIf(song -> song.getId().equals(id));
    }
}
