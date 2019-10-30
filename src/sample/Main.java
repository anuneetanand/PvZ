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

import java.io.IOException;
import java.util.Scanner;

public class Main extends Application
{
    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws  IOException
    {
        stage = primaryStage;
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml"))));
        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        stage.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {if (KeyCode.ESCAPE == event.getCode()) {primaryStage.close();}});
    }

    public static void setRoot_Main_Menu() throws IOException {stage.setScene(new Scene(FXMLLoader.load(Main.class.getResource("MainMenu.fxml")))); stage.show(); stage.setFullScreen(true);}
    public static void setRoot_Game() throws IOException { stage.setScene(new Scene(FXMLLoader.load(Main.class.getResource("Game.fxml")))); stage.show(); stage.setFullScreen(true);}
    public static void setRoot_PauseMenu() throws IOException { stage.setScene(new Scene(FXMLLoader.load(Main.class.getResource("PauseMenu.fxml")))); stage.show(); stage.setFullScreen(true);}
    public static void  setRoot_LeaderBoard() throws IOException { stage.setScene(new Scene(FXMLLoader.load(Main.class.getResource("LeaderBoard.fxml")))); stage.show(); stage.setFullScreen(true);}
    public static void setRoot_Help() throws IOException { stage.setScene(new Scene(FXMLLoader.load(Main.class.getResource("Help.fxml")))); stage.show(); stage.setFullScreen(true);}
    public static Stage getStage() { return stage; }
    public static void main(String[] args) { launch(args); }
}
