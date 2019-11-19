package sample;

public class LawnMower
{
    int Row;
    boolean Used;
    public LawnMower(int row) { Row = row;Used = false; }
    public void Use() {Used = true;}
    public boolean isUsed() { return Used; }
}
