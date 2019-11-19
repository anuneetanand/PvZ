package sample;

public class Bomb extends Plant
{
    private pair Range; // +- xr , +- yr
    private String Type ; // CherryBomb , PotatoMine
    public Bomb(int x, int y, String type, int xr, int yr) { super(x, y); Type=type; Range = new pair(xr,yr);}
    public void Blast(){}

    public String getType() { return Type; }
    public void setType(String type) { Type = type; }
    public pair getRange() { return Range; }

}
