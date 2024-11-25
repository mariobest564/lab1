package mk.finki.ukim.mk.lab.repository;

import lombok.AllArgsConstructor;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.seeder.DatabaseSeeder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ArtistRepository {

    private final List<Artist> artists = new ArrayList<>();

    public ArtistRepository() {
        artists.addAll(DatabaseSeeder.initialArtists);
    }

    public List<Artist> findAll() {
        System.out.println(artists);
        return artists;
    }

    public Optional<Artist> findByID(long id) {
        for (Artist a : artists) {
            if (a.getId() == id) {
                return Optional.of(a);
            }
        }
        return Optional.empty();
    }
}
