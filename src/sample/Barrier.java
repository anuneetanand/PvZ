package sample;

public class Barrier extends Plant
{
    private String Type ; // Wallnut , Tallnut
    public Barrier(int x, int y, String type) { super(x,y);Type = type; }
    public String getType() { return Type; }
    public void setType(String type) { Type = type; }
}
