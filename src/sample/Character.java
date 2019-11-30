package sample;

public abstract class Character
{
    private double Health;
    private pair Position;
    public Character(double H,double x, double y) { Health = H ; Position = new pair(x,y); }
    public double getHealth() { return Health; }
    public void setHealth(double health) { Health = health; }
    public pair getPosition() { return Position; }
}
