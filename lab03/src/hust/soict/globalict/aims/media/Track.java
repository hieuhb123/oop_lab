package media;

public class Track implements Playable{
    private String title;
    private int length;
    public String getTitle(){
        return title;
    }
    public int getLength(){
        return length;
    }
    public Track() {
	}
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
