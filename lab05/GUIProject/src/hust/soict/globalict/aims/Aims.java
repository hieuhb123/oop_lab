package hust.soict.globalict.aims;

import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.LimitExceededException;
import javax.swing.JOptionPane;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.AddSameCartException;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.store.Store;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Aims {
    public static Cart cart = new Cart();
    public static Store store = new Store();

    public static void showMenu() {
        System.out.println("AIMS:");
        System.out.println("--------------------------");
        System.out.println("1.View store");
        System.out.println("2.Update store");
        System.out.println("3.See current cart");
        System.out.println("0.Exit");
        System.out.println("--------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------");
        System.out.println("1.See a media's details");
        System.out.println("2.Add a media to cart");
        System.out.println("3.Play a media");
        System.out.println("4.See current cart");
        System.out.println("0.Back");
        System.out.println("--------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------");
        System.out.println("1.Add to cart");
        System.out.println("2.Play");
        System.out.println("0.Back");
        System.out.println("--------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------");
        System.out.println("1.Filter media in cart");
        System.out.println("2.Sort media in cart");
        System.out.println("3.Remove media from cart");
        System.out.println("4.Play a media");
        System.out.println("5.Place order");
        System.out.println("0.Back");
        System.out.println("--------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void addMenu() {
        System.out.println("What would you like to do:");
        System.out.println("1.Add DVD");
        System.out.println("2.Add CompactDisc");
        System.out.println("3.Add Book");
        System.out.println("4.Remove a media");
        System.out.println("0.Back");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void viewStore() {
        Scanner input = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            storeMenu();
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    DisplayMediaDetail();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playAMedia();
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("No such choice, try again!!!");
            }
        }
    }

    public static void DisplayMediaDetail() {
        Scanner input = new Scanner(System.in);
        Media theone = null;
        while (theone == null) {
            System.out.println("The media you wish to find:");
            String name = input.nextLine();
            theone = store.searchMediaByTitle(name);
        }
        theone.print();
        int choice = -1;
        while (choice != 0) {
            mediaDetailsMenu();
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                try{
                    cart.addMedia(theone);
                } catch (AddSameCartException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "The item is already in the cart.", ButtonType.OK);
                    alert.showAndWait();
                    System.err.println("AddSameCartException: " + e.getMessage());
                } catch (LimitExceededException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "You have exceeded the limit!", ButtonType.OK);
                    alert.showAndWait();
                    System.err.println("LimitExceededException: " + e.getMessage());
                }
                    break;
                case 2:
                    if (theone instanceof Book) {
                        System.out.println("Cannot be played, it's a book mate!!!");
                    } else if (theone instanceof CompactDisc) {
                        CompactDisc temp = (CompactDisc) theone;
                        try{
                            temp.play();
                        } catch(PlayerException e){
                            JOptionPane.showMessageDialog(null, "ERROR: Cannot play", "Error", JOptionPane.ERROR_MESSAGE);
            
                        }
                    } else {
                        DigitalVideoDisc temp = (DigitalVideoDisc) theone;
                        try{
                            temp.play();
                        } catch(PlayerException e){
                            JOptionPane.showMessageDialog(null, "ERROR: Cannot play", "Error", JOptionPane.ERROR_MESSAGE);
            
                        }
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("No such choice, try again!!!");
            }
        }
    }
    
    public static void addMediaToCart() {
        Scanner input = new Scanner(System.in);
        Media theone = null;
        store.print();
        while (theone == null) {
            System.out.println("The media you wish to find:");
            String name = input.nextLine();
            theone = store.searchMediaByTitle(name);
        }
        try{
            cart.addMedia(theone);
        } catch (AddSameCartException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "The item is already in the cart.", ButtonType.OK);
            alert.showAndWait();
            System.err.println("AddSameCartException: " + e.getMessage());
        } catch (LimitExceededException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "You have exceeded the limit!", ButtonType.OK);
            alert.showAndWait();
            System.err.println("LimitExceededException: " + e.getMessage());
        }
        System.out.println("There are now " + cart.getNumberOfMedia() + " in your cart!!!");
    }

    public static void playAMedia() {
        Scanner input = new Scanner(System.in);
        Media theone = null;
        while (theone == null) {
            System.out.println("The media you wish to find:");
            String name = input.nextLine();
            theone = store.searchMediaByTitle(name);
        }
        if (theone instanceof Book) {
            System.out.println("Cannot be played, it's a book mate!!!");
        } else if (theone instanceof CompactDisc) {
            CompactDisc temp = (CompactDisc) theone;
            try{
                temp.play();
            } catch(PlayerException e){
                JOptionPane.showMessageDialog(null, "ERROR: Cannot play", "Error", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            DigitalVideoDisc temp = (DigitalVideoDisc) theone;
            try{
                temp.play();
            } catch(PlayerException e){
                JOptionPane.showMessageDialog(null, "ERROR: Cannot play", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }
    
    public static void updateStore() {
        Scanner input = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            addMenu();
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    addDVD();
                    break;
                case 2:
                    addCompactDisc();
                    break;
                case 3:
                    addBook();
                    break;
                case 4:
                    removeMedia();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("No such choice, try again!!!");
            }
        }
    }
    
    public static void addDVD() {
        String title;
        String category;
        float cost;
        int length;
        String director;
        Scanner input = new Scanner(System.in);
        System.out.println("Input title: ");
        title = input.nextLine();
        System.out.println("Input category: ");
        category = input.nextLine();
        System.out.println("Input director: ");
        director = input.nextLine();
        System.out.println("Input length:");
        length = input.nextInt();
        input.nextLine();
        System.out.println("Input cost:");
        cost = input.nextFloat();
        input.nextLine();
        DigitalVideoDisc temp = new DigitalVideoDisc(title, category, director, length, cost);
        store.addMedia(temp);
    }

    public static void addCompactDisc() {
        String title;
        String category;
        float cost;
        int length;
        String director;
        String artist;
        ArrayList<Track> tracks = new ArrayList<Track>();
        int number_of_tracks = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Input title: ");
        title = input.nextLine();
        System.out.println("Input category: ");
        category = input.nextLine();
        System.out.println("Input director: ");
        director = input.nextLine();
        System.out.println("Input length:");
        length = input.nextInt();
        input.nextLine();
        System.out.println("Input cost:");
        cost = input.nextFloat();
        input.nextLine();
        System.out.println("Input artist:");
        artist = input.nextLine();
        System.out.println("The number of tracks you want to add: ");
        number_of_tracks = input.nextInt();
        input.nextLine();
        for (int i = 0; i < number_of_tracks; i++) {
            String track_title;
            int track_length;
            System.out.println("Input title of track " + String.valueOf(i + 1) + ":");
            track_title = input.nextLine();
            System.out.println("Input lengthof track " + String.valueOf(i + 1) + ":");
            track_length = input.nextInt();
            input.nextLine();
            Track temp = new Track(track_title, track_length);
            tracks.add(temp);
        }
        CompactDisc temp = new CompactDisc(title, category, director, length, cost, artist, tracks);
        store.addMedia(temp);
    }

    public static void addBook() {
        String title;
        String category;
        float cost;
        int number_of_authors = 0;
        ArrayList<String> authors = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        System.out.println("Input title: ");
        title = input.nextLine();
        System.out.println("Input category: ");
        category = input.nextLine();
        System.out.println("Input cost:");
        cost = input.nextFloat();
        input.nextLine();
        number_of_authors = input.nextInt();
        for (int i = 0; i < number_of_authors; i++) {
            String author;
            System.out.println("Input the " + String.valueOf(i + 1) + " author:");
            author = input.nextLine();
            authors.add(author);
        }
        Book book = new Book(title, category, cost, authors);
        store.addMedia(book);
    }

    public static void removeMedia() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input title: ");
        String title = input.nextLine();
        Media temp = store.searchMediaByTitle(title);
        if (temp != null) {
            store.removeMedia(temp);
        }
        input.close();
    }

    public static void seeCurrentCart() {
        Scanner input = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            cartMenu();
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    filterMediaInCart();
                    break;
                case 2:
                    sortMediaInCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playAMedia();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("No such choice, try again!!!");
            }
        }
    }

    public static void filterMediaInCart() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input title: ");
        String title = input.nextLine();
        if (cart.searchMediaByTitle(title) != null) {
            cart.searchMediaByTitle(title).print();
        } else {
            System.out.println("There's no such media in cart!!!");
        }
    }
    
    public static void sortMediaInCart() {
        Scanner input = new Scanner(System.in);
        System.out.println("Your choice is to sort by title or cost??? ");
        int choice = input.nextInt();
        input.nextLine();
        if (choice == 1) {
            cart.displaySortByCostTitle();
        } else if (choice == 2) {
            cart.displaySortByTitleCost();
        } else {
            System.out.println("No such choice!!!");
        }
    }
    
    public static void removeMediaFromCart() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input title: ");
        String title = input.nextLine();
        Media temp = cart.searchMediaByTitle(title);
        if (temp != null) {
            cart.removeMedia(temp);
        }
        input.close();
    }

    public static void placeOrder() {
        System.out.println("Your order have been confirmed!!!");
        cart.print();
        cart.placeOrder();
    }
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            showMenu();
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("No such choice, try again!!!");
            }
        }
    }
}
