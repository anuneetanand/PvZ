package sample;

public class Shooter extends Plant
{
    private String Type ; // PeaShooter , SnowPea
    private Projectile P ;
    public Shooter(double H, double x, double y, String type,double c) { super(H,x,y,c); Type=type; P = new Projectile(getPosition()); }
    public String getType() { return Type; }
    public void setType(String type) { Type = type; }
    public Projectile getP() {return P; }
    public void Shoot(){}
}
