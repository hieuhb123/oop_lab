package cart;
import java.util.ArrayList;

import media.Media;

public class Cart{
    public static final int MAX_NUMBER_ODERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    public void addMedia(Media media){
        if(itemsOrdered.contains(media)){
            System.out.println("This media existed!");
        }
        else{
            this.itemsOrdered.add(media);
            System.out.println("Media added");
        }
    } 
    public void removeMedia(Media media){
        if(itemsOrdered.contains(media)){
            this.itemsOrdered.remove(media);
            System.out.println("Media removed!");
        }
        else{
            System.out.println("This media does not exist!");
        }
    }

    public float totalCost(){
        float sum = 0;
        for(Media e : itemsOrdered){
            sum += e.getTCost();
        }
        return sum;
    }

    public void print(){
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for(Media e : itemsOrdered){
            System.out.println(Integer.toString(e.getId()) + ".DVD-" + e.getTTitle() + "-"+ e.getTCategory() + "-"+ e.getTCost());
        }
        System.out.println("Total cost:" + totalCost());
        System.out.println("***************************************************");
    }
}