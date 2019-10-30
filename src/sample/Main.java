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
    private Parent root_Main_Menu;
    private Parent root_Game;
    private Parent root_PauseMenu;
    private Parent root_LeaderBoard;
    private Parent root_Help;
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        stage = primaryStage;
        Parent root_Main_Menu = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Parent root_Game = FXMLLoader.load(getClass().getResource("GAME.fxml"));
        Parent root_PauseMenu = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
        Parent root_LeaderBoard = FXMLLoader.load(getClass().getResource("LeaderBoard.fxml"));
        Parent root_Help = FXMLLoader.load(getClass().getResource("Help.fxml"));
        stage.setScene(new Scene(root_Main_Menu));
        stage.setFullScreen(true);
        stage.show();
        stage.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {if (KeyCode.ESCAPE == event.getCode()) {primaryStage.close();}});
    }

    public Parent getRoot_Main_Menu() { return root_Main_Menu; }
    public void setRoot_Main_Menu(Parent root_Main_Menu) { this.root_Main_Menu = root_Main_Menu; }
    public Parent getRoot_Game() { return root_Game; }
    public void setRoot_Game(Parent root_Game) { this.root_Game = root_Game; }
    public Parent getRoot_PauseMenu() { return root_PauseMenu; }
    public void setRoot_PauseMenu(Parent root_PauseMenu) { this.root_PauseMenu = root_PauseMenu; }
    public Parent getRoot_LeaderBoard() { return root_LeaderBoard; }

    public void setRoot_LeaderBoard(Parent root_LeaderBoard) { this.root_LeaderBoard = root_LeaderBoard;
    }

    public Parent getRoot_Help() {
        return root_Help;
    }

    public void setRoot_Help(Parent root_Help) {
        this.root_Help = root_Help;
    }

    public static Stage getStage() { return stage; }
    public static void setStage(Stage stage) { Main.stage = stage; }
    public static void main(String[] args) { launch(args); }
}
