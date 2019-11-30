package sample;

import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class GameController extends Click
{
    public Image Selection;
    public boolean ShovelSelected;
    @FXML
    public AnchorPane BG;
    public GameHelper G;

    public GameController()
    { Selection = null;ShovelSelected = false; }

    @FXML
    public void Pause(MouseEvent mouseEvent) throws IOException { Main.setRoot_PauseMenu(); }

    @FXML
    public void Select(MouseEvent mouseEvent)
    {
        String s = ((ImageView) mouseEvent.getSource()).getId();
        if (s.equals("SelectPeaShooter")) { Selection = new Image("sample/Resources/pea_shooter.gif"); ShovelSelected = false; }
        else if (s.equals("SelectSunflower")) {Selection = new Image("sample/Resources/sun_flower.gif"); ShovelSelected = false;}
        else if (s.equals("SelectWallnut")){Selection = new Image("sample/Resources/wallnut.gif"); ShovelSelected = false;}
        else if (s.equals("SelectShovel")){Selection = new Image("sample/Resources/shovel.png"); ShovelSelected = true;}
    }

    @FXML
    public void Place(MouseEvent mouseEvent)
    {
        ImageView Tile = (ImageView) mouseEvent.getSource();
        if ((Selection!=null))
        {
            if ((!ShovelSelected)&&(Tile.getImage()==null))
            { Tile.setImage(Selection);Tile.setFitHeight(80);Tile.setFitWidth(80);Tile.setPreserveRatio(true); }
            else if(ShovelSelected){ Tile.setImage(null); }
        }
    }

    public void StartGame()
    { G = new GameHelper(5,10,100,this); G.Process(); }
}