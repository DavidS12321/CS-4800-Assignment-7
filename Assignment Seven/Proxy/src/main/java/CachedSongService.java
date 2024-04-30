import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CachedSongService implements SongService {
    private final SongService realSongService;
    private final Map<Integer, Song> idCache = new HashMap<>();
    private final Map<String, List<Song>> titleCache = new HashMap<>();
    private final Map<String, List<Song>> albumCache = new HashMap<>();

    public CachedSongService(SongService realSongService) {
        this.realSongService = realSongService;
    }

    @Override
    public Song searchById(Integer songID) {
        return idCache.computeIfAbsent(songID, realSongService::searchById);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        return titleCache.computeIfAbsent(title, realSongService::searchByTitle);
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        return albumCache.computeIfAbsent(album, realSongService::searchByAlbum);
    }
}