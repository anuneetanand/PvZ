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
import javafx.stage.StageStyle;

public class Main extends Application
{
    private static Stage stage;
    private static Parent root_Main_Menu;
    private static Parent root_Game;
    private static Parent root_PauseMenu;
    private static Parent root_LeaderBoard;
    private static Parent root_Help;
    private static Parent root;
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        stage = primaryStage;
        Parent root_Main_Menu = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Parent root_Game = FXMLLoader.load(getClass().getResource("GAME.fxml"));
        Parent root_PauseMenu = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
        Parent root_LeaderBoard = FXMLLoader.load(getClass().getResource("LeaderBoard.fxml"));
        Parent root_Help = FXMLLoader.load(getClass().getResource("Help.fxml"));
        root = root_Main_Menu;
        stage.setScene(new Scene(root));
        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        stage.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {if (KeyCode.ESCAPE == event.getCode()) {primaryStage.close();}});
    }
    public static void setRoot_Main_Menu() { root = root_Main_Menu; stage.setScene(new Scene(root));}
    public static void setRoot_Game() { root = root_Game; }
    public static void setRoot_PauseMenu() { root = root_PauseMenu; stage.setScene(new Scene(root));}
    public static void setRoot_LeaderBoard() { root = root_LeaderBoard; stage.setScene(new Scene(root));}
    public static void setRoot_Help() { root = root_Help; stage.setScene(new Scene(root));}
    public static void setStage(Stage stage) { Main.stage = stage; }
    public static Stage getStage() { return stage; }
    public static void main(String[] args) { launch(args); }
}
