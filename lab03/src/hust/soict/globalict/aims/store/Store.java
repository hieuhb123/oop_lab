package store;
import java.util.ArrayList;

import media.Media;
public class Store {
    private ArrayList<Media> itemsInStore;
    public void addMedia(Media media){
        if(itemsInStore.contains(media)){
            System.out.println("This media existed!");
        }
        else{
            this.itemsInStore.add(media);
            System.out.println("Media added");
        }
    } 
    public void removeMedia(Media media){
        if(itemsInStore.contains(media)){
            this.itemsInStore.remove(media);
            System.out.println("Media removed!");
        }
        else{
            System.out.println("This media does not exist!");
        }
    }

    public void print(){
        System.out.println("***********************Store***********************");
        System.out.println("Items: ");
        for(Media e : itemsInStore){
            System.out.println(Integer.toString(e.getId()) + ".DVD-" + e.getTTitle() + "-"+ e.getTCategory() + "-"+ e.getTCost());
        }
        System.out.println("***************************************************");
    }
}
