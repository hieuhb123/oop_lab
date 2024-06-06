package hust.soict.globalict.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CartController {

    Cart cart;
    Store store;
    private boolean isSearchById = true;

    public CartController(Cart cart){
        this.cart = cart;
    }

    public CartController(Store store, Cart cart){
        this.store = store;
        this.cart = cart;
    }

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TextField tfFilter;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Currenly playing", ButtonType.OK);
        alert.showAndWait();
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        costLabel.setText(String.valueOf(cart.totalCost()));
    }

    @FXML
    void btnViewStore(ActionEvent event) {
        try{
            final String STORE_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            fxmlLoader.setController(new ViewStoreController(store, cart));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void btnViewStorePressed(MouseEvent event) {
        try{
            final String STORE_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            fxmlLoader.setController(new ViewStoreController(store, cart));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize(){
        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        if(cart.getItemsOrdered() != null){
            tblMedia.setItems(cart.getItemsOrdered());
        }

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        costLabel.setText(String.valueOf(cart.totalCost()));

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue){
                updateButtonBar(newValue);
            }
        });

        tfFilter.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                showFilteredMedia(newValue);
            }
        });
    }

    void updateButtonBar(Media media){
        if (media == null){
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }
        else{
            btnRemove.setVisible(true);
            if(media instanceof Playable){
                btnPlay.setVisible(true);
            }
            else{
                btnPlay.setVisible(false);
            }
        }
    };

    @FXML
    void changeToId(ActionEvent event) {
        isSearchById = true;
    }

    @FXML
    void changeToTitle(ActionEvent event) {
        isSearchById = false;
    }


    public void showFilteredMedia(String string){
        if (isSearchById){
            tblMedia.setItems(cart.searchItemsById(Integer.valueOf(string)));
            System.out.println(cart.searchItemsById(Integer.valueOf(string)).get(0));
        }
        else{
            tblMedia.setItems(cart.searchItemsByTitle(string));
        }
    }

    @FXML
    void btnPlaceOrder(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Your order have been placed!!!", ButtonType.OK);
        alert.showAndWait();
        cart.placeOrder();
    }
}
