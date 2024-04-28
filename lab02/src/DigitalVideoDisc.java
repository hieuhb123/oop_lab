
public class DigitalVideoDisc {
    
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

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

    public DigitalVideoDisc(String tile){
        this.title = tile;
    }
    public DigitalVideoDisc (String tile, String category,  float cost){
        this.category = category;
        this.title = tile;
        this.cost = cost;
    }
    public DigitalVideoDisc (String tile, String director,String category,  float cost){
        this.director = director;
        this.category = category;
        this.title = tile;
        this.cost = cost;
    }
    public DigitalVideoDisc(String tile, String category, String director, int length, float cost){
        this.director = director;
        this.category = category;
        this.title = tile;
        this.length = length;
        this.cost = cost;
    }
}
