package sample;

public class Shooter extends Plant
{
    private String Type ; // PeaShooter , SnowPea
    private Projectile P ;
    public Shooter(int H, int x, int y, String type,int c) { super(H,x,y,c); Type=type; }
    public String getType() { return Type; }
    public void setType(String type) { Type = type; }
    public void Shoot(){}
}
