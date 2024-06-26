package hust.soict.globalict.aims.screen.customer.controller;

import java.io.IOException;

import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.AddSameCartException;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.screen.customer.controller.ItemController.InnerItemController;
import hust.soict.globalict.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ViewStoreController implements InnerItemController{

    private Store store;
    private Cart cart;

    public ViewStoreController(Store store){
        this.store = store;
    }
    public ViewStoreController(Store store, Cart cart){
        this.store = store;
        this.cart = cart;
    }

    @FXML
    private GridPane gridPane;

    @FXML
    void btnViewCartPressed(ActionEvent event) {
        try{
            final String CART_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Cart.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
            fxmlLoader.setController(new CartController(store, cart));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Cart");
            stage.show();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize(){
        final String ITEM_FXML_PATH = "/hust/soict/globalict/aims/screen/customer/view/Item.fxml";
        int column = 0;
        int row = 1;
        for(int i = 0; i < store.getItemsInStore().size(); i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(ITEM_FXML_PATH));
                ItemController itemController = new ItemController(this);
                fxmlLoader.setController(itemController);
                AnchorPane anchorPane = new AnchorPane();
                anchorPane = fxmlLoader.load();
                itemController.setData(store.getItemsInStore().get(i));

                if(column == 3){
                    column = 0;
                    row ++;
                }

                gridPane.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(20, 10, 10, 10));
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void addToCart(Media media){
        try {
            cart.addMedia(media);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "The item has been added successfully!!!", ButtonType.OK);
            alert.showAndWait();
        } catch (AddSameCartException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "The item is already in the cart.", ButtonType.OK);
            alert.showAndWait();
            System.err.println("AddSameCartException: " + e.getMessage());
        } catch (LimitExceededException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "You have exceeded the limit!", ButtonType.OK);
            alert.showAndWait();
            System.err.println("LimitExceededException: " + e.getMessage());
        }
    }
}

