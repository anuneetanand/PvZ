package sample;

public class Zombie extends Character
{
    private int Damage;
    private String Type;
    public Zombie(int H,int x, int y, String type, int r , int d) { super(H,x,y); Type=type; Damage = d; }
    public String getType() { return Type; }
    public void setType(String type) { Type = type; }
    public int getDamage() { return Damage; }
    public void Eat(){}
}
