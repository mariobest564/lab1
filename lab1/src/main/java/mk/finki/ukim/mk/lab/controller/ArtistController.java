package mk.finki.ukim.mk.lab.controller;

import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ArtistController {
    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/artistsList")
    public String addArtists(Long trackId, Model model) {
        List<Artist> artists = artistService.listArtists();
        model.addAttribute("artists", artists);
        model.addAttribute("trackId", trackId);

        return "artistsList";
    }
}
