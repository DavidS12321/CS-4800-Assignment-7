import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class SongServiceTest {
    private SongService realSongService;
    private SongService cachedSongService;
    private Song[] testSongs;

    @Before
    public void setUp() {
        // Initialize song array
        testSongs = new Song[]{
                new Song(1, "Blinding Lights", "The Weeknd", "After Hours", 200),
                new Song(3, "Levitating", "Dua Lipa", "Future Nostalgia", 203),
                new Song(4, "Don't Start Now", "Dua Lipa", "Future Nostalgia", 183)
        };
        realSongService = new RealSongService(testSongs);
        cachedSongService = new CachedSongService(realSongService);
    }

    @Test
    public void testSearchById() {
        Song preFetchedSong = cachedSongService.searchById(1);

        long startTime = System.currentTimeMillis();
        Song song = cachedSongService.searchById(1);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken by cached service: " + (endTime - startTime) + " ms");

        assertTrue("Fetching with cached service should be instant", endTime - startTime < 50);
        assertEquals("Blinding Lights", song.getTitle());
    }


    @Test
    public void testSearchByTitle() {
        List<Song> songs = realSongService.searchByTitle("Blinding Lights");
        assertEquals(1, songs.size());
        assertEquals("The Weeknd", songs.get(0).getArtist());

        songs = cachedSongService.searchByTitle("Blinding Lights");
        assertEquals(1, songs.size());
        assertEquals("The Weeknd", songs.get(0).getArtist());
    }

    @Test
    public void testSearchByAlbum() {
        List<Song> songs = realSongService.searchByAlbum("After Hours");
        assertEquals(1, songs.size());
        assertEquals("Blinding Lights", songs.get(0).getTitle());

        songs = cachedSongService.searchByAlbum("After Hours");
        assertEquals(1, songs.size());
        assertEquals("Blinding Lights", songs.get(0).getTitle());
    }
}