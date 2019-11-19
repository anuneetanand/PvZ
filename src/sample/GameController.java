package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.fxml.FXML;

public class GameController extends Click
{
    private Image Selection;
    private boolean ShovelSelected;
    private ArrayList<ArrayList<ImageView>> Grid;
    private ArrayList<ArrayList<ImageView>> Zombies;
    private ArrayList<ArrayList<ImageView>> SunTokens;
    public ImageView R1C1= new ImageView(),R1C2= new ImageView(),R1C3= new ImageView(),R1C4= new ImageView(),R1C5= new ImageView(),R1C6= new ImageView(),R1C7= new ImageView(),R1C8= new ImageView(),R1C9= new ImageView(),R2C1= new ImageView(),R2C2= new ImageView(),R2C3= new ImageView(),R2C4= new ImageView(),R2C5= new ImageView(),R2C6= new ImageView(),R2C7= new ImageView(),R2C8= new ImageView(),R2C9= new ImageView(),R3C1= new ImageView(),R3C2= new ImageView(),R3C3= new ImageView(),R3C4= new ImageView(),R3C5= new ImageView(),R3C6= new ImageView(),R3C7= new ImageView(),R3C8= new ImageView(),R3C9= new ImageView(),R4C1= new ImageView(),R4C2= new ImageView(),R4C3= new ImageView(),R4C4= new ImageView(),R4C5= new ImageView(),R4C6= new ImageView(),R4C7= new ImageView(),R4C8= new ImageView(),R4C9= new ImageView(),R5C1= new ImageView(),R5C2= new ImageView(),R5C3= new ImageView(),R5C4= new ImageView(),R5C5= new ImageView(),R5C6= new ImageView(),R5C7= new ImageView(),R5C8= new ImageView(),R5C9= new ImageView();
    public ImageView Z_1_1= new ImageView(),Z_2_1= new ImageView(),Z_3_1= new ImageView(),Z_4_1= new ImageView(),Z_5_1= new ImageView();
    public ImageView S_2= new ImageView(),S_4= new ImageView(),S_6= new ImageView(),S_8= new ImageView();

    public GameController()
    {
        ArrayList<ImageView>  B= new ArrayList<>(Arrays.asList(S_2,S_4));
        System.out.println(B.get(0));
        Selection = null;
        ShovelSelected = false;
        Grid = new ArrayList<ArrayList<ImageView>>();
        Grid.add(new ArrayList<ImageView>(Arrays.asList(R1C1,R1C2,R1C3,R1C4,R1C5,R1C6,R1C7,R1C8,R1C9)));
        Grid.add(new ArrayList<ImageView>(Arrays.asList(R2C1,R2C2,R2C3,R2C4,R2C5,R2C6,R2C7,R2C8,R2C9)));
        Grid.add(new ArrayList<ImageView>(Arrays.asList(R3C1,R3C2,R3C3,R3C4,R3C5,R3C6,R3C7,R3C8,R3C9)));
        Grid.add(new ArrayList<ImageView>(Arrays.asList(R4C1,R4C2,R4C3,R4C4,R4C5,R4C6,R4C7,R4C8,R4C9)));
        Grid.add(new ArrayList<ImageView>(Arrays.asList(R5C1,R5C2,R5C3,R5C4,R5C5,R5C6,R5C7,R5C8,R5C9)));
        Zombies = new ArrayList<ArrayList<ImageView>>();
        Zombies.add(new ArrayList<ImageView>(Arrays.asList(Z_1_1,Z_2_1,Z_3_1,Z_4_1,Z_5_1)));
        SunTokens = new ArrayList<ArrayList<ImageView>>();
        SunTokens.add(new ArrayList<ImageView>(Arrays.asList(S_2,S_4,S_6,S_8)));
    }

    @FXML
    public void Pause(MouseEvent mouseEvent) throws IOException { Main.setRoot_PauseMenu(); }

    public void Select(MouseEvent mouseEvent)
    {
        String s = ((ImageView) mouseEvent.getSource()).getId();
        if (s.equals("SelectPeaShooter")) { Selection = new Image("sample/Resources/pea_shooter.gif"); ShovelSelected = false; }
        else if (s.equals("SelectSunflower")) {Selection = new Image("sample/Resources/sun_flower.gif"); ShovelSelected = false;}
        else if (s.equals("SelectWallnut")){Selection = new Image("sample/Resources/wallnut.gif"); ShovelSelected = false;}
        else if (s.equals("SelectShovel")){Selection = new Image("sample/Resources/shovel.png"); ShovelSelected = true;}
    }

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