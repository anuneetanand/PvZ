package sample;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;

public class MainMenuController extends Click
{
    private static MediaPlayer Music;

    @FXML
    public void Exit(javafx.scene.input.MouseEvent mouseEvent)
    { System.exit(0); }

    @FXML
    public void NewGame(MouseEvent mouseEvent)
    { Main.setRoot_Game(); }

    @FXML
    public void Help(MouseEvent mouseEvent)
    { Main.setRoot_Help(); }

    @FXML
    public void LeaderBoard(MouseEvent mouseEvent)
    { Main.setRoot_LeaderBoard(); }

    public void LoadGame(MouseEvent mouseEvent)
    { }
}
