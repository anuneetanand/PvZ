package sample;

public abstract class Character
{
    private int Health;
    private pair Position;

    public Character(int x, int y)
    { Health = 100 ; Position = new pair(x,y); }

    public int getHealth() { return Health; }
    public void setHealth(int health) { Health = health; }
    public pair getPosition() { return Position; }
}
