package hust.soict.globalict.test.screen.customer.store;

import java.util.ArrayList;

import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.AddSameCartException;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.screen.customer.controller.ViewStoreController;
import hust.soict.globalict.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application{
    private static Store store;
    private static Cart cart;
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        final String STORE_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        ArrayList<String> authors = new ArrayList<>();
        authors.add("Author 1");
        store.addMedia(new Book("Motivation", "Inspiration", 10.0f, authors));
        store.addMedia(new Book("My little kitty", "Cute", 15.0f, authors));
        store.addMedia(new Book("Dune", "Adventure", 20.0f, authors));

        // Create and add 3 compact discs
        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(new Track("Track 1", 100));
        tracks.add(new Track("Track 2", 150));
        tracks.add(new Track("Track 3", 120));
        store.addMedia(new CompactDisc("Brave Shine", "Sound Track", "Aimer", 370, 25.0f, "Aimer", tracks));
        store.addMedia(new CompactDisc("Star Dust", "Sound Track", "Aimer", 420, 30.0f, "Aimer"));
        store.addMedia(new CompactDisc("Somebody's pressure", "Pop", "Lewis", 300, 20.0f, "Hedra"));

        // Create and add 3 digital video discs
        store.addMedia(new DigitalVideoDisc("DVD 1", "Category 7", "Director 1", 90, 10.0f));
        store.addMedia(new DigitalVideoDisc("DVD 2", "Category 8", "Director 2", 120, 15.0f));
        store.addMedia(new DigitalVideoDisc("DVD 3", "Category 9", "Director 3", 150, 20.0f));
        
        
        cart = new Cart();
        ArrayList<String> authorsc = new ArrayList<>();
        authorsc.add("Author 1");
        try{
        cart.addMedia(new Book("Motivation", "Inspiration", 10.0f, authorsc));
        cart.addMedia(new Book("My little kitty", "Cute", 15.0f, authorsc));
        cart.addMedia(new Book("Dune", "Adventure", 20.0f, authorsc));

        // Create and add 3 compact discs
        ArrayList<Track> tracksc = new ArrayList<>();
        tracksc.add(new Track("Track 1", 100));
        tracksc.add(new Track("Track 2", 150));
        tracksc.add(new Track("Track 3", 120));
        cart.addMedia(new CompactDisc("Brave Shine", "Sound Track", "Aimer", 370, 25.0f, "Aimer", tracksc));
        cart.addMedia(new CompactDisc("Star Dust", "Sound Track", "Aimer", 420, 30.0f, "Aimer"));
        cart.addMedia(new CompactDisc("Somebody's pressure", "Pop", "Lewis", 300, 20.0f, "Hedra"));

        // Create and add 3 digital video discs
        cart.addMedia(new DigitalVideoDisc("DVD 1", "Category 7", "Director 1", 90, 10.0f));
        cart.addMedia(new DigitalVideoDisc("DVD 2", "Category 8", "Director 2", 120, 15.0f));
        cart.addMedia(new DigitalVideoDisc("DVD 3", "Category 9", "Director 3", 150, 20.0f));
        } catch (AddSameCartException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "The item is already in the cart.", ButtonType.OK);
            alert.showAndWait();
            System.err.println("AddSameCartException: " + e.getMessage());
        } catch (LimitExceededException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "You have exceeded the limit!", ButtonType.OK);
            alert.showAndWait();
            System.err.println("LimitExceededException: " + e.getMessage());
        }
        launch(args);
    }
}
