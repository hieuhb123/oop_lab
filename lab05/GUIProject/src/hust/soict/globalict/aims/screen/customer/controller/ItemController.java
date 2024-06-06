package hust.soict.globalict.aims.screen.customer.controller;

import javax.swing.plaf.InsetsUIResource;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {

    private Media media;
    private InnerItemController innerItemController;
    public ItemController(InnerItemController innerItemController){
        this.innerItemController = innerItemController;
    }

    public void setData(Media media){
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");
        if(media instanceof Playable){
            btnPlay.setVisible(true);
        }
        else{
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        innerItemController.addToCart(media);
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Currenly playing" + media.getTitle(), ButtonType.OK);
        alert.showAndWait();
    }

    public interface InnerItemController {
        public void addToCart(Media media);
    }
}

