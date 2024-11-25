package mk.finki.ukim.mk.lab.seeder;

import lombok.experimental.UtilityClass;
import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class DatabaseSeeder {

    public static List<Artist> initialArtists = new ArrayList<>();
    public static List<Song> initialSongs = new ArrayList<>();
    public static List<Album> initialAlbums = new ArrayList<>();

    static {
        initialArtists.add(new Artist(2231L, "Dua ", "Lipa", "Pop"));
        initialArtists.add(new Artist(2542L, "Kamasi ", "Washington", "Jazz"));
        initialArtists.add(new Artist(1145L, "Kacey", "Musgraves", "Country"));
        initialArtists.add(new Artist(4543L, "Kendrick", "Lamar", "Hip-Hop"));
        initialArtists.add(new Artist(1245L, "Robert", "Plant", "Rock"));

        initialAlbums.add(new Album(225L, "Dummy Portshead", "Pop", "1992"));
        initialAlbums.add(new Album(123L, "Blood on Tracks", "Metal", "2000"));
        initialAlbums.add(new Album(456L, "Kind of blue", "Blues", "1970"));
        initialAlbums.add(new Album(765L, "The Beatles", "Rock", "1973"));
        initialAlbums.add(new Album(891L, "Moon Safari", "Jazz", "2001"));

        initialSongs.add(new Song("7361", "Levitating", "Pop", 2014, initialArtists.get(0), 231L, initialAlbums.get(0)));
        initialSongs.add(new Song("2333", "Truth", "Jazz", 1998, initialArtists.get(1), 123L, initialAlbums.get(1)));
        initialSongs.add(new Song("5641", "Rainbow", "Country", 2004, initialArtists.get(2), 321L, initialAlbums.get(2)));
        initialSongs.add(new Song("1234", "Humble", "Hip-Hop", 2009, initialArtists.get(3), 456L, initialAlbums.get(3)));
        initialSongs.add(new Song("8789", "Big Log", "Rock", 1991, initialArtists.get(4), 789L, initialAlbums.get(4)));
    }
}
