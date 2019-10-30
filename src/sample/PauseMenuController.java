package sample;

import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class PauseMenuController extends Click
{
    public void Music(MouseEvent mouseEvent)
    { }

    public void RestartGame(MouseEvent mouseEvent) throws IOException { Main.setRoot_Game();}

    public void SaveGame(MouseEvent mouseEvent) throws IOException { Main.setRoot_Main_Menu(); }

    public void Back(MouseEvent mouseEvent) throws IOException { Main.setRoot_Game(); }
}
