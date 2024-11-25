package mk.finki.ukim.mk.lab.controller;

import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.service.AlbumService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SongController {
    private final SongService songService;
    private final AlbumService albumService;

    @Autowired
    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @PostMapping("/songs/add")
    public String saveSong(@RequestParam String title,
                           @RequestParam String trackId,
                           @RequestParam String genre,
                           @RequestParam int releaseYear,
                           @RequestParam Long albumId) {
        try {
            songService.createSong(title, trackId, genre, releaseYear, albumId);
        } catch (IllegalArgumentException e) {
            return "redirect:/add?error=" + e.getMessage();
        }
        return "redirect:/songs";
    }

    @GetMapping("/songs/toDelete")
    public String toDeleteSongsPage(Model model) {
        List<Song> songs = songService.listSongs();
        model.addAttribute("songs", songs);
        return "deleteSongs";
    }

    @PostMapping("/songs/deleteMultiple")
    public String deleteMultipleSongs(@RequestParam List<Long> songIds) {
        for (Long songId : songIds) {
            try {
                songService.deleteById(songId);
            } catch (IllegalArgumentException e) {
                return "redirect:/songs?error=" + e.getMessage();
            }
        }
        return "redirect:/songs";
    }

//    @PostMapping("songs/edit")
//    public String editSong(@PathVariable Long songId,
//                           @RequestParam String title,
//                           @RequestParam String trackId,
//                           @RequestParam String genre,
//                           @RequestParam int releaseYear,
//                           @RequestParam Long albumId) {
//
//    }


    @GetMapping("/songs")
    public String getSongsPage(@RequestParam(required = false) String error, Model model) {
        List<Song> songs = songService.listSongs();
        List<Album> albums = albumService.findAll();

        model.addAttribute("songs", songs);
        model.addAttribute("albums", albums);
        if (error != null) {
            model.addAttribute("error", error);
        }
        return "listSongs";
    }

    @GetMapping("/add")
    public String getAddSongPage(@RequestParam(required = false) String error, Model model) {
        List<Album> albums = albumService.findAll();
        model.addAttribute("albums", albums);
        if (error != null) {
            model.addAttribute("error", error);
        }
        return "add";
    }
}
