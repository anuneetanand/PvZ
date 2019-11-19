package sample;

public class SunTokenGenerator extends Plant
{
    private String Type ; // Sunflower
    public SunTokenGenerator(int x, int y, String type) { super(x, y); Type=type; }
    public void Produce(){}
    public String getType() { return Type; }
    public void setType(String type) { Type = type; }
}
