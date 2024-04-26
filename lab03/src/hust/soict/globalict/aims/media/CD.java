package media;

public class CD extends Media{
    private int id;
    private String title;
    private String category;
    private String artist;
    private String director;
    private float price;
    private class track_list{
        String titletl;
        int length;
    }

    public Boolean isMatch(String title){
        if(this.title == title) return true;
        return false;
    }
}
