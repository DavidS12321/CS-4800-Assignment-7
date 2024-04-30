import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

public class RealSongService implements SongService {
    private List<Song> songDatabase;

    public RealSongService(Song[] songsArray) {
        this.songDatabase = new ArrayList<>(Arrays.asList(songsArray));
    }

    @Override
    public Song searchById(Integer songID) {
        simulateNetworkLatency();
        return songDatabase.stream()
                .filter(song -> song.getSongID().equals(songID))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        simulateNetworkLatency();
        return songDatabase.stream()
                .filter(song -> song.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        simulateNetworkLatency();
        return songDatabase.stream()
                .filter(song -> song.getAlbum().equalsIgnoreCase(album))
                .collect(Collectors.toList());
    }

    private void simulateNetworkLatency() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}