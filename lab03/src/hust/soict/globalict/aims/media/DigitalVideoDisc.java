package media;
public class DigitalVideoDisc extends Media implements Playable{
    private int length;
    private String director;
    public String getTitle(){
        return getTTitle();
    }

    public String getCategory(){
        return getTCategory();
    }

    public String getDirector(){
        return director;
    }

    public int getLength(){
        return length;
    }

    public float getCost(){
        return getTCost();
    }

    public DigitalVideoDisc(String title){
        super(title);
    }
    public DigitalVideoDisc (String tile, String category, float cost){
        super(tile, category, cost);
    }
    public DigitalVideoDisc (String tile,String category, String director, float cost){
        super(tile, category, cost);
        this.director = director;
    }
    public DigitalVideoDisc(String tile, String category, String director, int length, float cost){
        super(tile, category, cost);
        this.director = director;
        this.length = length;
    }
    public Boolean isMatch(String title){
        if(this.getTitle() == title) return true;
        return false;
    }
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
