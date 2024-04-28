package media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Media implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }
    
    public String getArtist(){
        return artist;
    }
    public void addTrack(Track track){
        if(tracks.contains(track)) System.out.println("The track already exists!");
        else{
            this.tracks.add(track);
            System.out.println("The track added");
        }
    }
    public void removeTrack(Track track){
        if(tracks.contains(track)){
            this.tracks.remove(track);
            System.out.println("The track removed");
        }
        else{
            System.out.println("The track does not exists!");
        }
    }
    public int getLength(){
		int sum = 0;
		for (Track e : tracks) sum += e.getLength();
		return sum;
    }
    public void play(){
        for(Track e : tracks){
            e.play();
        }
    }
}
