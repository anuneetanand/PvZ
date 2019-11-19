package sample;

public class Zombie extends Character
{
    private int Damage;
    private int Row;
    private String Type;
    public Zombie(int x, int y, String type, int r , int d) { super(x, y); Type=type; Damage = d; Row = r; }
    public void Eat(){}
    public String getType() { return Type; }
    public void setType(String type) { Type = type; }
    public int getDamage() { return Damage; }
    public int getRow() { return Row; }
}
