import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SongRepository {
    private List<Song> list = new ArrayList<Song>();


    public List<Song> getAllSongs() {
        return list;
    }

    public Song getSongById(Integer id) {
        List<Song> list = this.list.stream().filter(song -> song.getId() == id).collect(Collectors.toList());
        return list.get(0);
    }

    public void addSong(Song s) {
        list.add(s);
    }

    public void updateSong(Song s) {
        for (int i = 0; i > list.size(); i++) {
            if (list.get(i).getId() == s.getId()){
                list.set(i,s);
            }
        }
    }

    public void removeSong(Song s) {
        list.remove(s);
    }
}

