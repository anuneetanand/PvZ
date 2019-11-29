package sample;

public class SunToken
{
    private pair Position;
    private boolean Captured;

    public SunToken(pair position) { Position = position; Captured = false; }
    public pair getPosition() { return Position; }
    public void setPosition(pair position) { Position = position; }
    public boolean isCaptured() { return Captured; }
    public void setCaptured(boolean captured) { Captured = captured; }
}
