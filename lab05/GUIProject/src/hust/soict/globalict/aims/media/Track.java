package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class Track implements Playable{
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
		return title;
	}

    public int getLength() {
        return length;
    }

    public void play() throws PlayerException{
        if (this.getLength() > 0){
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else{
            throw new PlayerException("ERROR: DVD length is non-positive");
        }
        
    }
    @Override
    public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Track temp = (Track) o;
            return this.getTitle() == temp.getTitle() && this.getLength() == temp.getLength();
        }
}
