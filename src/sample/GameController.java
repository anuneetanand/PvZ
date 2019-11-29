package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.util.HashMap;
import javafx.fxml.FXML;

public class GameController extends Click
{
    public Image Selection;
    public boolean ShovelSelected;
    public HashMap<Plant,ImageView> Plants;
    public HashMap<Zombie,ImageView> Zombies;
    public HashMap<SunToken,ImageView> SunTokens;
    public HashMap<Projectile,ImageView> Bullets;

    public GameController()
    {
        Selection = null;
        ShovelSelected = false;
        Plants = new HashMap<>();
        Zombies = new HashMap<>();
        SunTokens = new HashMap<>();
        Bullets = new HashMap<>();
    }

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

}