package sample;

public class SunTokenGenerator extends Plant
{
    private String Type ; // Sunflower
    public SunTokenGenerator(int H, int x, int y, String type,int c) { super(H,x,y,c); Type=type; }
    public String getType() { return Type; }
    public void setType(String type) { Type = type; }
    public void Produce(){}
}
