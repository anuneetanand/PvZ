package sample;

public class LawnMower extends Character
{
    boolean Used;
    public LawnMower(double x, double y) { super(100,x,y);Used = false; }
    public void Use() {Used = true;}
    public boolean isUsed() { return Used; }
}
