package sample;

import javafx.fxml.FXML;
import javafx.scene.Scene;
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
    { Main.getStage().setScene(new Scene(Main.getRoot_Game())); }

    @FXML
    public void Help(MouseEvent mouseEvent)
    { Main.getStage().setScene(new Scene(Main.getRoot_Help())); }

    @FXML
    public void LeaderBoard(MouseEvent mouseEvent)
    { Main.getStage().setScene(new Scene(Main.getRoot_LeaderBoard())); }

    public void LoadGame(MouseEvent mouseEvent) {
    }
}
