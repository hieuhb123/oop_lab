package hust.soict.globalict.aims.cart;

import hust.soict.globalict.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;

import javax.naming.LimitExceededException;
import hust.soict.globalict.aims.exception.AddSameCartException;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    
    public int getNumberOfMedia() {
        return itemsOrdered.size();
    }
	public void addMedia(Media media) throws AddSameCartException, LimitExceededException{
		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED){
			System.out.println("The cart has been full, take out another item to place");
            throw new LimitExceededException("ERROR: The number of media has reached its limit");
		}
		else {
			for (int i = 0; i < itemsOrdered.size(); i++) {
                if (itemsOrdered.get(i).equals(media)) {
                    System.out.println("This media have been available in cart!!!");
                    throw new AddSameCartException("This media have been available in cart!!!");
                }
            }

            itemsOrdered.add(media);
            System.out.println("The disc have been added successfully!!!");
            return;
		}
	}
	public void removeMedia(Media media) {
		if (itemsOrdered.isEmpty()) {
			System.out.println("The cart is empty");
			return;
		}
		if (itemsOrdered.remove(media)) {
            System.out.println("The item have been removed!!!");
            return;
        }
        System.out.println("There is no such item!!!");
        return;
	}

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            total += itemsOrdered.get(i).getCost();
        }
        return total;
    }
    
    public void placeOrder() {
        itemsOrdered.clear();
    }
    public void print() {
        System.out.println("********************CART********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println(String.valueOf(i + 1) + ". Media - " + itemsOrdered.get(i).toString());
        }
        System.out.println("********************************************");
    }
    
    public Media searchMediaByTitle(String title) {
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getTitle().equals(title)) {
                return itemsOrdered.get(i);
            }
        }
        return null;
    }
    
    public void displaySortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("The cart ordered by Title and Cost:");
        this.print();
    }

    public void displaySortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("The cart ordered by Cost and Title:");
        this.print();
    }

    public ObservableList<Media> getItemsOrdered(){
        return itemsOrdered;
    }
    public ObservableList<Media> searchItemsById(int id){
        ObservableList<Media> temp = FXCollections.observableArrayList();
        for (int i = 0; i < itemsOrdered.size(); i++){
            if (itemsOrdered.get(i).getId() == id){
                temp.add(itemsOrdered.get(i));
            }
        }
        return temp;
    }

    public ObservableList<Media> searchItemsByTitle(String title){
        ObservableList<Media> temp = FXCollections.observableArrayList();
        for (int i = 0; i < itemsOrdered.size(); i++){
            if (itemsOrdered.get(i).getTitle().contains(title)){
                temp.add(itemsOrdered.get(i));
            }
        }
        return temp;
    }
}
