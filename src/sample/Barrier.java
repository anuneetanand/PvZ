package sample;

public class Barrier extends Plant
{
    private String Type ; // Wallnut , Tallnut
    public Barrier(double H,double x, double y, String type,double c) { super(H,x,y,c);Type = type; }
    public String getType() { return Type; }
    public void setType(String type) { Type = type; }
}
