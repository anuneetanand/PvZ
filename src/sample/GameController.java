package sample;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import javafx.fxml.FXML;

public class GameController extends Click
{
    private Image Selection = null;
    private boolean ShovelSelected = false;
    
    @FXML
    public void Pause(MouseEvent mouseEvent) throws IOException { Main.setRoot_PauseMenu(); }

    public void Select(MouseEvent mouseEvent)
    {
        String s = ((ImageView) mouseEvent.getSource()).getId();
        if (s.equals("SelectPeaShooter")) { Selection = new Image("sample/Resources/pea_shooter.gif"); ShovelSelected = false; }
        else if (s.equals("SelectSunflower")) {Selection = new Image("sample/Resources/sun_flower.gif"); ShovelSelected = false;}
        else if (s.equals("SelectWallnut")){Selection = new Image("sample/Resources/wallnut.gif"); ShovelSelected = false;}
        else if (s.equals("SelectShovel")){Selection = new Image("sample/Resources/shovel.png"); ShovelSelected=true;}
    }

    public void Place(MouseEvent mouseEvent)
    {
        ImageView m = (ImageView) mouseEvent.getSource();
        if ((Selection!=null))
        {
            if ((!ShovelSelected)&&(m.getImage()==null))
            { m.setImage(Selection);m.setFitHeight(80);m.setFitWidth(80);m.setPreserveRatio(true); }
            else
            { m.setImage(null); }
        }
    }
}
