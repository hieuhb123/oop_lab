package hust.soict.globalict.aims.store;
import java.util.ArrayList;

import hust.soict.globalict.aims.media.Media;




public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        for (int i = 0; i < itemsInStore.size(); i++) {
            if (itemsInStore.get(i).equals(media)) {
                System.out.println("This media have been available in store!!!");
                return;
            }
        }

        itemsInStore.add(media);
        System.out.println("The disc have been added successfully!!!");
        return;
    }
    
    public void removeMedia(Media media) {
        if (itemsInStore.isEmpty()) {
            System.out.println("The store have none media!!!");
            return;
        }
        if (itemsInStore.remove(media)) {
            System.out.println("The disc have been removed!!!");
            return;
        }
        System.out.println("There is no such disc!!!");
        return;
    }

    public int getNumberOfMedia() {
        return itemsInStore.size();
    }

    public ArrayList<Media> getItemsInStore(){
        return itemsInStore;
    }
    public void print() {
        System.out.println("********************Store*******************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println(String.valueOf(i + 1) + ". DVD - " + itemsInStore.get(i).getTitle());
        }
        System.out.println("********************************************");
    }

    public Media searchMediaByTitle(String title) {
        for (int i = 0; i < itemsInStore.size(); i++) {
            if (itemsInStore.get(i).getTitle().equals(title)) {
                System.out.println("Media found at index " + String.valueOf(i) + ".");
                return itemsInStore.get(i);
            }
        }
        System.out.println("There is no media with such title!!!");
        return null;
    }
}
