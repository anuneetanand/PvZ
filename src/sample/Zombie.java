package sample;

public class Zombie extends Character
{
    private int Damage;
    private String Type;
    private boolean Blocked;
    public Zombie(int H, int x, int y, String type, int r , int d) { super(H,x,y); Type=type; Damage = d; Blocked = false;}
    public String getType() { return Type; }
    public void setType(String type) { Type = type; }
    public int getDamage() { return Damage; }
    public boolean isBlocked() { return Blocked; }
    public void setBlocked(boolean blocked) { Blocked = blocked; }
    public void Eat(){}
}
