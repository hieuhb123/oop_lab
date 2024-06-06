import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;
public class PainterController {
    @FXML
    private Pane drawingAreaPane;
    private int choose = 0;
    @FXML
    void clearButtonPressed(ActionEvent event){
        drawingAreaPane.getChildren().clear();
    }
    @FXML
    void eraseButtonPressed(ActionEvent event){
        this.choose = 1;
    }
    @FXML
    void penButtonPressed(ActionEvent event){
        this.choose = 0;
    }
    @FXML
    void drawingAreaMouseDragged(MouseEvent event){
        if(choose == 0){
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
            drawingAreaPane.getChildren().add(newCircle);
        }
        else{
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.WHITE);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }
    
}
