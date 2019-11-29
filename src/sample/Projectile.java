package sample;

public class Projectile
{
    private pair Position;
    private boolean Hit;

    public Projectile(pair position)
    { Position = position; Hit = false; }

    public pair getPosition() { return Position; }
    public void setPosition(pair position) { Position = position; }
    public boolean isHit() { return Hit; }
    public void setHit(boolean hit) { Hit = hit; }
}
