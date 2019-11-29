package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameHelper
{
    public HashMap<LawnMower, ImageView> LawnMowers;
    public HashMap<Plant,ImageView> Plants;
    public HashMap<Zombie,ImageView> Zombies;
    public HashMap<SunToken,ImageView> SunTokens;
    public HashMap<Projectile,ImageView> Bullets;
    public Label STC;
    public ImageView ZB;
    public double ZS;
    public int ZC;
    public int ZH;

    public GameHelper(double speed, int count, int health, AnchorPane BG)
    {
        LawnMowers = new HashMap<>();
        Plants = new HashMap<>();
        Zombies = new HashMap<>();
        SunTokens = new HashMap<>();
        Bullets = new HashMap<>();
        STC = new Label();
        ZB = new ImageView("sample/Resources/ZombieHead.png");
        ZS = speed;
        ZC = count;
        ZH = health;
    }

    public void I_STC()
    { STC.setLayoutX(50); STC.setLayoutY(85); STC.setPrefHeight(10); STC.setPrefWidth(40); STC.setText("0"); }

    public void I_ZB()
    { ZB.setX(1230); ZB.setY(20); ZB.setFitHeight(50); ZB.setFitWidth(50);}
    
    public void I_LawnMower()
    {
        for(int i=0;i<5;i++)
        {
            ImageView I = new ImageView("sample/Resources/lawn_mower.gif");
            I.setX(175);I.setY(125+(i*150));I.setFitHeight(100);I.setFitWidth(100);
            LawnMower O = new LawnMower(175,125+(i*150));
            LawnMowers.put(O,I);
        }
    }

    public void I_SunToken()
    {
        int R = new Random().nextInt(8);
        ImageView I = new ImageView("sample/Resources/sun.gif");
        I.setX(300+(R*110));I.setY(0);I.setFitHeight(80);I.setFitWidth(80);
        I.setOnMouseClicked(e -> I.setOpacity(0));
        SunToken O = new SunToken(new pair(300+(R*110),0));
        SunTokens.put(O,I);
    }

    public void I_Zombie()
    {
        if (ZC>0)
        {
            int R = new Random().nextInt(5);
            ImageView I = new ImageView("sample/Resources/zombie_normal.gif");
            I.setX(1440);I.setY(125+(R*150));I.setFitHeight(100);I.setFitWidth(100);I.setPreserveRatio(true);
            Zombie O = new Zombie(ZH,1440,(125+(R*150)),"Normal",10);
            Zombies.put(O,I);
            ZC--;
        }
    }

    public void Move_SunToken()
    {
        for (Map.Entry S : SunTokens.entrySet())
        {
            SunToken SO = ((SunToken)S.getKey());
            ImageView SI = ((ImageView)S.getValue());
            if ((SO!=null)&&(SI!=null))
            {
                if (SI.getOpacity()==0) { Collect_SunToken(); SunTokens.remove(SO);}
                else if(SO.getPosition().getY()>900) { SunTokens.remove(SO); }
                else {SO.getPosition().setY(SO.getPosition().getY()+ZS*10);SI.setY(SI.getY()+ZS*10);}
            }
        }
    }

    public void Collect_SunToken()
    { STC.setText( String.valueOf(Integer.parseInt(STC.getText())+50)); }

    public void Use_SunToken(int X)
    { STC.setText( String.valueOf(Math.max(Integer.parseInt(STC.getText())-X,0))); }

    public void LZ_Collide(LawnMower LO,ImageView LI)
    {
        for (Map.Entry Z : Zombies.entrySet())
        {
            Zombie ZO = ((Zombie)Z.getKey());
            ImageView ZI = ((ImageView)Z.getValue());
            if ((ZO!=null) && (ZI!=null) && (ZO.getHealth()>0))
            {
                double dx = Math.abs(ZO.getPosition().getX()-LO.getPosition().getX());
                double dy = Math.abs(ZO.getPosition().getY()-LO.getPosition().getY());
                if ((dy==0) && (dx<50)) { Zombies.remove(ZO); } }
        }
    }

    public void Move_LawnMower(Zombie ZO,ImageView ZI) throws GameOverException
    {
        for (Map.Entry L : LawnMowers.entrySet())
        {
            LawnMower LO = ((LawnMower) L.getKey());
            ImageView LI = ((ImageView) L.getValue());
            if (LO.getPosition().getY()==ZO.getPosition().getY())
            {
                if (!LO.isUsed()) { LO.getPosition().setX(LO.getPosition().getX()+ZS*100); LI.setX(LI.getX()+ZS*100); LZ_Collide(LO,LI);}
                else { throw new GameOverException(); }
                if (LO.getPosition().getX()>1440) {LO.Use();LI.setVisible(false);}
            }
        }
    }

    public void  Move_Zombie() throws GameOverException
    {
        for (Map.Entry Z : Zombies.entrySet())
        {
            Zombie ZO = ((Zombie)Z.getKey());
            ImageView ZI = ((ImageView)Z.getValue());
            if ((ZO!=null) && (ZI!=null))
            {
                if (ZO.getHealth()<=0) { Zombies.remove(ZO);}
                else if(ZO.getPosition().getX()<250) { Move_LawnMower(ZO,ZI); Zombies.remove(ZO);}
                else if (!ZO.isBlocked()) { ZO.getPosition().setX(ZO.getPosition().getX()-ZS);ZI.setX(ZI.getX()-ZS);}
            }
        }
    }
}
