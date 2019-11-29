package sample;

public class Shooter extends Plant
{
    private String Type ; // PeaShooter , SnowPea
    private Projectile P ;
    public Shooter(int x, int y, String type) { super(x, y); Type=type; }
    public void Shoot(){}

    public String getType() { return Type; }
    public void setType(String type) { Type = type; }
}
