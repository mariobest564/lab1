package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Artist;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ArtistService {
    List<Artist> listArtists();
    Artist findById(Long id);
}
