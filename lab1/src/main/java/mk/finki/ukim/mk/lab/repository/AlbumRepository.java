package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.seeder.DatabaseSeeder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AlbumRepository {
    private final List<Album> albums = new ArrayList<>();

    public AlbumRepository() {
        albums.addAll(DatabaseSeeder.initialAlbums);
    }

    public List<Album> findAll() {
        return albums;
    }

    public Optional<Album> findAlbumById(Long Id) {
        for (Album album : albums) {
            if (album.getId().equals(Id)) {
               return Optional.of(album);
            }
        }
        return Optional.empty();
    }
}
