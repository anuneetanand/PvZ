package sample;

public class Bomb extends Plant
{
    private String Type ; // CherryBomb , PotatoMine
    public Bomb(double H,double x, double y, String type,double c) { super(H,x,y,c); Type=type;}
    public String getType() { return Type; }
    public void setType(String type) { Type = type; }

    public void Blast(){}

}
