package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextAlignment;

import java.util.*;

public class GameHelper
{
    public AnimationTimer T;
    public GameController A;
    public HashMap<LawnMower, ImageView> LawnMowers;
    public HashMap<Plant,ImageView> Plants;
    public HashMap<Zombie,ImageView> Zombies;
    public HashMap<SunToken,ImageView> SunTokens;
    public HashMap<Projectile,ImageView> Bullets;
    public Label STC;public ImageView ZB;
    public double ZS;public int ZC;public int ZH;public int Time;public long PT;

    public GameHelper(double speed, int count, int health, GameController a)
    {
        T = new AnimationTimer() 
        {@Override public void start() { PT = System.nanoTime();super.start();}
        @Override public void handle(long Now) { long ET = Now - PT;Execute();PT = ET; }};
        LawnMowers = new HashMap<>();Plants = new HashMap<>();Zombies = new HashMap<>();SunTokens = new HashMap<>();Bullets = new HashMap<>();
        STC = new Label();ZB = new ImageView("sample/Resources/ZombieHead.png");
        ZS = speed;ZC = count;ZH = health;A = a;Time = 0;
        //A.BG.getChildren().add();
        I_STC();I_ZB();I_LawnMower();
    }

    public void I_STC()
    { STC.setLayoutX(50); STC.setLayoutY(85); STC.setPrefHeight(20); STC.setPrefWidth(40); STC.setText("0"); STC.setTextAlignment(TextAlignment.CENTER); A.BG.getChildren().add(STC); }

    public void I_ZB()
    { ZB.setX(1230); ZB.setY(20); ZB.setFitHeight(50); ZB.setFitWidth(50);A.BG.getChildren().add(ZB); }

    public void I_LawnMower()
    {
        for(int i=0;i<5;i++)
        {
            ImageView I = new ImageView("sample/Resources/lawn_mower.gif");
            I.setX(175);I.setY(125+(i*150));I.setFitHeight(100);I.setFitWidth(100);
            A.BG.getChildren().add(I);
            LawnMower O = new LawnMower(175,125+(i*150));
            LawnMowers.put(O,I);
        }
    }

    public void I_SunToken()
    {
        int R = new Random().nextInt(8);
        ImageView I = new ImageView("sample/Resources/sun.gif");
        I.setX(300+(R*110));I.setY(0);I.setFitHeight(75);I.setFitWidth(75);
        A.BG.getChildren().add(I);
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
            A.BG.getChildren().add(I);
            Zombie O = new Zombie(ZH,1440,(125+(R*150)),"Normal",10);
            Zombies.put(O,I);
            ZC--;
        }
    }

    public void Move_ZB()
    { if (ZB.getX()>950) { ZB.setX(ZB.getX()-(ZS*0.005));} else {} } // Write Game Winner Exception

    public void Move_SunToken()
    {
        for (Map.Entry<SunToken,ImageView> S : SunTokens.entrySet())
        {
            SunToken SO = S.getKey();
            ImageView SI = S.getValue();
            if ((SO!=null)&&(SI!=null))
            {
                if (SI.getOpacity()==0) { Collect_SunToken(); SunTokens.remove(SO);}
                else if(SO.getPosition().getY()>900) { SunTokens.remove(SO); }
                else {SO.getPosition().setY(SO.getPosition().getY()+ZS*0.3);SI.setY(SI.getY()+ZS*0.3);}
            }
        }
    }

    public void Collect_SunToken()
    { STC.setText( String.valueOf(Integer.parseInt(STC.getText())+50)); }

    public void Use_SunToken(int X)
    { STC.setText( String.valueOf(Math.max(Integer.parseInt(STC.getText())-X,0))); }

    public void LZ_Collide(LawnMower LO,ImageView LI)
    {
        for (Map.Entry<Zombie,ImageView> Z : Zombies.entrySet())
        {
            Zombie ZO = Z.getKey();
            ImageView ZI = Z.getValue();
            if ((ZO!=null) && (ZI!=null) && (ZO.getHealth()>0))
            {
                double dx = Math.abs(ZO.getPosition().getX()-LO.getPosition().getX());
                double dy = Math.abs(ZO.getPosition().getY()-LO.getPosition().getY());
                if ((dy==0) && (dx<50)) {ZI.setOpacity(0); Zombies.remove(ZO); } }
        }
    }

    public void Move_LawnMower(Zombie ZO,ImageView ZI)              // Edit Speed & Collision Detection
    {
        for (Map.Entry<LawnMower,ImageView> L : LawnMowers.entrySet())
        {
            LawnMower LO =  L.getKey();
            ImageView LI =  L.getValue();
            if (LO.getPosition().getY()==ZO.getPosition().getY())
            {
                if (!LO.isUsed())
                { LO.getPosition().setX(LO.getPosition().getX()+ZS*100); LI.setX(LI.getX()+ZS*100); LZ_Collide(LO,LI);}
                else {  }
                if (LO.getPosition().getX()>1300) {LO.Use();LI.setVisible(false);}
            }
        }
    }

    public void  Move_Zombie()
    {
        for (Map.Entry<Zombie, ImageView> Z : Zombies.entrySet())
        {
            Zombie ZO = Z.getKey();
            ImageView ZI = Z.getValue();
            if ((ZO!=null) && (ZI!=null))
            {
                if (ZO.getHealth()<=0) { Zombies.remove(ZO); }
                else if(ZO.getPosition().getX()<250) { Zombies.remove(ZO); Move_LawnMower(ZO,ZI); }
                else if (!ZO.isBlocked()) { ZO.getPosition().setX(ZO.getPosition().getX()-ZS*0.1);ZI.setX(ZI.getX()-ZS*0.1);}
            }
        }
    }

    public void Execute()
    {
        Time++;
        Move_ZB();
        Move_SunToken();
        Move_Zombie();
        //System.out.println(Time);
        if(Time%1000==0) {I_SunToken(); I_Zombie();}
    }

    public void Process()
    { T.start(); }

}

