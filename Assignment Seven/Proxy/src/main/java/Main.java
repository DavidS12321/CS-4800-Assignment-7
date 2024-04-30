import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Song[] songs = new Song[]{
                new Song(1, "Blinding Lights", "The Weeknd", "After Hours", 200),
                new Song(2, "Save Your Tears", "The Weeknd", "After Hours", 216),
                new Song(3, "Levitating", "Dua Lipa", "Future Nostalgia", 203),
                new Song(4, "Don't Start Now", "Dua Lipa", "Future Nostalgia", 183),
                new Song(5, "good 4 u", "Olivia Rodrigo", "SOUR", 178),
                new Song(6, "drivers license", "Olivia Rodrigo", "SOUR", 242),
                new Song(7, "Peaches", "Justin Bieber", "Justice", 198),
                new Song(8, "STAY", "The Kid LAROI", "F*CK LOVE 3: OVER YOU", 141),
                new Song(9, "Heat Waves", "Glass Animals", "Dreamland", 238),
                new Song(10, "INDUSTRY BABY", "Lil Nas X", "MONTERO", 212)
        };

        SongService realSongService = new RealSongService(songs);
        SongService cachedSongService = new CachedSongService(realSongService);

        for (Song song : songs) {
            System.out.println("Searching by ID " + song.getSongID() + ":");
            Song foundById = cachedSongService.searchById(song.getSongID());
            System.out.println("Found song: " + foundById.getTitle());
        }

        for (Song song : songs) {
            System.out.println("Searching by Title \"" + song.getTitle() + "\":");
            List<Song> foundByTitle = cachedSongService.searchByTitle(song.getTitle());
            String titles = foundByTitle.stream().map(Song::getTitle).collect(Collectors.joining(", "));
            System.out.println("Found songs: " + titles);
        }

        for (Song song : songs) {
            System.out.println("Searching by Album \"" + song.getAlbum() + "\":");
            List<Song> foundByAlbum = cachedSongService.searchByAlbum(song.getAlbum());
            String albumTitles = foundByAlbum.stream().map(Song::getTitle).collect(Collectors.joining(", "));
            System.out.println("Found songs: " + albumTitles);
        }
    }
}