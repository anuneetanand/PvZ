package sample;

import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class LeaderBoardController extends Click
{
    public void Back(MouseEvent mouseEvent) throws IOException
    {
        Main.setRoot_Main_Menu();
    }
}
