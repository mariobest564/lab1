package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.repository.SongRepository;
import mk.finki.ukim.mk.lab.service.AlbumService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final AlbumService albumService;

    public SongServiceImpl(SongRepository songRepository, AlbumService albumService) {
        this.songRepository = songRepository;
        this.albumService = albumService;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        return songRepository.addArtistToSong(artist, song);
    }

    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }

    @Override
    public void createSong(String title, String trackId, String genre, int releaseYear, Long albumId) {
        Album album = albumService.findById(albumId).orElse(null);

        if (album == null) {
            System.out.println("Album not found, using default album.");
        }

        Song song = new Song(trackId, title, genre, releaseYear, null, new Random().nextLong(), album);
        songRepository.save(song);
    }

    public void editSong(String title, String trackId, String genre, int releaseYear, Long albumId) {

    }



    @Override
    public void updateSong(Long songId, String title, String trackId, String genre, int releaseYear, Long albumId) {

    }

    @Override
    public void deleteById(Long id) {
        boolean removed = songRepository.deleteById(id);
        if (!removed) {
            throw new IllegalArgumentException("Song with ID " + id + " not found");
        }
    }
}
