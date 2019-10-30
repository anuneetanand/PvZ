package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;

public class Main extends Application
{
    private static Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        stage = primaryStage;
        Parent root_Main_Menu = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        //Parent root_Game = FXMLLoader.load(getClass().getResource("GAME.fxml"));
        //Parent root_PauseMenu = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
        //Parent root_LeaderBoard = FXMLLoader.load(getClass().getResource("LeaderBoard.fxml"));
        //Parent root_Help = FXMLLoader.load(getClass().getResource("Help.fxml"));
        stage.setScene(new Scene(root_Main_Menu));
        stage.addEventHandler(MouseEvent.MOUSE_CLICKED , (MouseEvent event) -> {System.out.println("Clicked");});
        stage.setFullScreen(true);
        stage.show();
        stage.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {if (KeyCode.ESCAPE == event.getCode()) {primaryStage.close();}});
    }
    public static Stage getStage() { return stage; }
    public static void setStage(Stage stage) { Main.stage = stage; }
    public static void main(String[] args) { launch(args); }
}
