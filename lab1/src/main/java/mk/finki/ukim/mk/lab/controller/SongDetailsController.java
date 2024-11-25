package mk.finki.ukim.mk.lab.controller;

import jakarta.servlet.http.HttpSession;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.service.ArtistService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SongDetailsController {

    private final SongService songService;
    private final ArtistService artistService;

    public SongDetailsController(SongService songService, ArtistService artistService) {
        this.songService = songService;
        this.artistService = artistService;
    }

    @GetMapping("/addArtistToSong")
    public String addArtistToSong(Long artistId,Long trackId, HttpSession httpSession, Model model) {
        Artist artist = artistService.findById(artistId);
        Song song = songService.findByTrackId(trackId.toString());

        songService.addArtistToSong(artist, song);
        httpSession.setAttribute("selectedSong", song);
        model.addAttribute("song", song);

        return "songDetails";
    }
}
