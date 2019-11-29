package sample;

public class Bomb extends Plant
{
    private pair Range; // +- xr , +- yr
    private String Type ; // CherryBomb , PotatoMine
    public Bomb(int H,int x, int y, String type, int xr, int yr,int c) { super(H,x,y,c); Type=type; Range = new pair(xr,yr);}
    public String getType() { return Type; }
    public void setType(String type) { Type = type; }
    public pair getRange() { return Range; }

    public void Blast(){}

}
