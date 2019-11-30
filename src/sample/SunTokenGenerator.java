package sample;

public class SunTokenGenerator extends Plant
{
    private String Type ; // Sunflower
    public SunTokenGenerator(double H, double x, double y, String type,double c) { super(H,x,y,c); Type=type; }
    public String getType() { return Type; }
    public void setType(String type) { Type = type; }
    public void Produce(){}
}
