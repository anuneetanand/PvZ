package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.util.ResourceBundle;

public class GameController extends Click implements Initializable
{
    public ImageView zombie_1;
    public ImageView sun;
    public ImageView pea;
    public ImageView zombie_head;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        TranslateTransition T1 = new TranslateTransition(Duration.millis(25000),zombie_1 );
        T1.setFromX(0);
        T1.setToX(-800);
        T1.play();
        TranslateTransition T2 = new TranslateTransition(Duration.millis(25000),sun );
        T2.setFromY(0);
        T2.setToY(900);
        T2.play();
        TranslateTransition T3 = new TranslateTransition(Duration.millis(2500),pea );
        T3.setFromX(0);
        T3.setToX(1000);
        T3.setCycleCount(100);
        T3.play();
        TranslateTransition T4 = new TranslateTransition(Duration.millis(100000),zombie_head );
        T4.setFromX(0);
        T4.setToX(-250);
        T4.play();
    }

    @FXML
    public void Pause(MouseEvent mouseEvent) throws IOException { Main.setRoot_PauseMenu(); }
}
