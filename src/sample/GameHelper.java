package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    public Label STC;public ImageView ZB;
    public ImageView Select_PS, Select_SF, Select_WN, Select_PM, Select_TN, Select_JP;
    public int C_PS,C_SF,C_WN,C_PM,C_TN,C_JP;
    public Glow On,Off;
    public ImageView Selection;
    public boolean ShovelSelected;
    public int L; public double ZS;public int ZC;public int ZH;public int Time;public long PT;

    public GameHelper(int Level,double speed, int count, int health, GameController a)
    {
        T = new AnimationTimer()
        {@Override public void start() { PT = System.nanoTime();super.start();}
        @Override public void handle(long Now) { long ET = Now - PT;Execute();PT = ET; }};
        LawnMowers = new HashMap<>();Plants = new HashMap<>();Zombies = new HashMap<>();SunTokens = new HashMap<>();
        STC = new Label();ZB = new ImageView("sample/Resources/ZombieHead.png");
        ZS = speed;ZC = count;ZH = health;A = a;Time = 0;L = Level;
        Selection = null; ShovelSelected = false;
        C_PS=0;C_SF=0;C_WN=0;C_PM=0;C_TN=0;C_JP=0;
        On = new Glow(1); Off = new Glow(0);
        //A.BG.getChildren().add();
        I_STC();I_ZB();I_LawnMower();I_Inventory();
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

    public void I_Inventory()
    {
        Select_PS = new ImageView("sample/Resources/active_peashooter.png");Select_PS.setFitHeight(80); Select_PS.setFitWidth(80); Select_PS.setX(270); Select_PS.setY(10);Select_PS.setId("100"); Select_PS.setEffect(Off); A.BG.getChildren().add(Select_PS);
        Select_PS.setOnMouseClicked(this::Move_Inventory);
        Select_SF = new ImageView("sample/Resources/active_sunflower.png");Select_SF.setFitHeight(80); Select_SF.setFitWidth(80); Select_SF.setX(360); Select_SF.setY(10);A.BG.getChildren().add(Select_SF);
        if(L>1){Select_WN = new ImageView("sample/Resources/active_walnut.png");Select_WN.setFitHeight(80); Select_WN.setFitWidth(80); Select_WN.setX(450); Select_WN.setY(10);A.BG.getChildren().add(Select_WN);}
        if(L>2){Select_PM = new ImageView();Select_PM.setFitHeight(80); Select_PM.setFitWidth(80); Select_PM.setX(540); Select_PM.setY(10);A.BG.getChildren().add(Select_PM);}
        if(L>3){Select_TN = new ImageView();Select_TN.setFitHeight(80); Select_TN.setFitWidth(80); Select_TN.setX(630); Select_TN.setY(10);A.BG.getChildren().add(Select_TN);}
        if(L>4){Select_JP = new ImageView();Select_JP.setFitHeight(80); Select_JP.setFitWidth(80); Select_JP.setX(720); Select_JP.setY(10);A.BG.getChildren().add(Select_JP);}
    }

    public void I_Plant(ImageView Tile)
    {
        if ((Selection!=null))
        {
            if ((!ShovelSelected)&&(Tile.getImage()==null))
            {
                double x = Tile.getLayoutX()+300; double y = Tile.getLayoutY()+125;
                ImageView I = new ImageView(Selection.getImage());
                I.setX(x); I.setY(y); I.setFitWidth(75); I.setFitHeight(75); I.setPreserveRatio(true);
                A.BG.getChildren().add(I);
                if(Selection.getId().equals("100"))
                { Shooter O = new Shooter(100,x,y,"Shooter",100); A.BG.getChildren().add(O.getP().getB());  Plants.put(O,I);}
                Tile.setImage(Selection.getImage());
            }
            else if(ShovelSelected){ Tile.setImage(null); }
            Selection = null;
        }
    }

    public void Move_ZB()
    { if (ZB.getX()>950) { ZB.setX(ZB.getX()-(ZS*0.005));} else {} } // Write Game Winner Exception

    public void Move_Inventory(MouseEvent e)
    {
        ImageView I = (ImageView) e.getSource();
        if((I.getId().equals("100"))&& (I.getEffect().equals(On))) {Selection = new ImageView("sample/Resources/pea_shooter.gif"); Selection.setId("100");  I.setEffect(Off); Use_SunToken(100);}
    }

    public void Manage_Inventory()
    {
        if ((C_PS > 500) &&  ( Integer.parseInt(Select_PS.getId()) <= Integer.parseInt(STC.getText()) ))
        {Select_PS.setEffect(On); C_PS=0;}
    }


    public void Move_Pea()
    {
        for(Map.Entry<Plant,ImageView> P : Plants.entrySet())
        {
            Plant PO = P.getKey();
            ImageView PI = P.getValue();
            if ((PO!=null)&&(PI!=null))
            {
                if (String.valueOf(PO.getClass().getName()).equals("sample.Shooter"))
                {
                    ImageView I = ((Shooter) PO).getP().getB();
                    if (I.getX()<1440) {I.setX(I.getX()+ZS);}
                    else {I.setX(((Shooter) PO).getP().getPosition().getX());}
                }

            }
        }
    }

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
        C_PS++;C_SF++;C_WN++;C_PM++;C_TN++;C_JP++;
        Move_ZB();
        Move_SunToken();
        Move_Zombie();
        Move_Pea();
        Manage_Inventory();
        if(Time%100==0) {I_SunToken(); I_Zombie();}
    }

    public void Process()
    { T.start(); }

}

