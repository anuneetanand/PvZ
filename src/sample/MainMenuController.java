package sample;

import javafx.fxml.FXML;
import javafx.scene.media.MediaPlayer;

public class MainMenuController extends Click
{
    private static MediaPlayer Music;

    @FXML
    public void Exit(javafx.scene.input.MouseEvent mouseEvent)
    { System.exit(0); }
}
