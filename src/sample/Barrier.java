package sample;

public class Barrier extends Plant
{
    private String Type ; // Wallnut , Tallnut
    public Barrier(int H,int x, int y, String type,int c) { super(H,x,y,c);Type = type; }
    public String getType() { return Type; }
    public void setType(String type) { Type = type; }
}
