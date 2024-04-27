package disc;
import media.Disc;
import media.Playable;
public class DigitalVideoDisc extends Disc implements Playable{
    public String getTitle(){
        return title;
    }

    public String getCategory(){
        return category;
    }

    public String getDirector(){
        return director;
    }

    public int getLength(){
        return length;
    }

    public float getCost(){
        return cost;
    }

    public DigitalVideoDisc(String title){
        super(title);
    }
    public DigitalVideoDisc (String tile, String category, float cost){
        super(tile, category, cost);
    }
    public DigitalVideoDisc (String tile,String category, String director, float cost){
        super(tile, category, director, cost);
    }
    public DigitalVideoDisc(String tile, String category, String director, int length, float cost){
        super(tile, category, director, length, cost);
    }
    public Boolean isMatch(String title){
        if(super.title == title) return true;
        return false;
    }
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
