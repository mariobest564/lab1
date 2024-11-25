//package mk.finki.ukim.mk.lab.controller;
//
//import mk.finki.ukim.mk.lab.model.Artist;
//import mk.finki.ukim.mk.lab.model.Song;
//import mk.finki.ukim.mk.lab.service.SongService;
//import mk.finki.ukim.mk.lab.service.ArtistService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.List;
//
//@Controller
//public class SongListController {
//
//    private final SongService songService;
//
//    @Autowired
//    public SongListController(SongService songService) {
//        this.songService = songService;
//    }
//
//    @GetMapping("/listSongs")
//    public String listSongs(Model model) {
//        List<Song> songs = songService.listSongs();
//        model.addAttribute("songs", songs);
//
//        return "listSongs";
//    }
//
//}
