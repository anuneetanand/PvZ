// Anuneet Anand
// Naman Tyagi
// AP Project

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;


public class Main extends Application
{
    private static Stage stage;
    private static MediaPlayer SoundPlayer;
    public static boolean MusicToggle  = true;

    private static  void LoadMusic()
    {
        try
        {
            File audioFile = new File("GameSound.mp3");
            Media Sound = new Media(audioFile.toURI().toURL().toString());
            SoundPlayer = new MediaPlayer(Sound);
            SoundPlayer.setOnEndOfMedia(() -> SoundPlayer.seek(Duration.ZERO));
        }
        catch (MalformedURLException e)
        { System.out.println("No Audio File Found"); }
    }

    public static void Music() { if (MusicToggle) {SoundPlayer.play();} else {SoundPlayer.pause();} }

    @Override
    public void start(Stage primaryStage) throws  IOException
    {
        stage = primaryStage;
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml"))));
        //stage.setFullScreen(true);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        LoadMusic();
        stage.show();
        stage.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {if (KeyCode.ESCAPE == event.getCode()) {primaryStage.close();}});
    }

    public static void setRoot_Main_Menu() throws IOException {stage.setScene(new Scene(FXMLLoader.load(Main.class.getResource("MainMenu.fxml")))); stage.show(); }
    public static void setRoot_Game() throws IOException { stage.setScene(new Scene(FXMLLoader.load(Main.class.getResource("Game.fxml")))); stage.show(); Main.Music();}
    public static void setRoot_PauseMenu() throws IOException { stage.setScene(new Scene(FXMLLoader.load(Main.class.getResource("PauseMenu.fxml")))); stage.show();}
    public static void  setRoot_LeaderBoard() throws IOException { stage.setScene(new Scene(FXMLLoader.load(Main.class.getResource("LeaderBoard.fxml")))); stage.show(); }
    public static void setRoot_Help() throws IOException { stage.setScene(new Scene(FXMLLoader.load(Main.class.getResource("Help.fxml")))); stage.show(); }
    public static void setRoot_Level() throws IOException { stage.setScene(new Scene(FXMLLoader.load(Main.class.getResource("LevelMenu.fxml")))); stage.show(); }
    public static void setRoot_Load() throws IOException { stage.setScene(new Scene(FXMLLoader.load(Main.class.getResource("LoadGame.fxml")))); stage.show(); }
    public static Stage getStage() { return stage; }
    public static void main(String[] args) { launch(args); }
}
