package sample;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;

public class MainMenuController extends Click
{
    private static MediaPlayer Music;

    @FXML
    public void New
    public void Exit(javafx.scene.input.MouseEvent mouseEvent)
    { System.exit(0); }

    public void NewGame(MouseEvent mouseEvent)
    { Main.getStage().setScene(new Scene()); }

    public void Help(MouseEvent mouseEvent)
    { }

    public void LeaderBoard(MouseEvent mouseEvent)
    { }

    public void LoadGame(MouseEvent mouseEvent)
    { }
}
