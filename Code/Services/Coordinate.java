package Services;

public class Coordinate 
{
    private int x,y;

    public int GetX() { return x; }
    public int GetY() { return y; }

    public Coordinate(int x, int y) 
    {
        this.x = x;
        this.y = y;
    }

    public int GetDistanceTo(Coordinate targetPos)
    {
        int xDist = Math.abs(x - targetPos.x);
        int yDist = Math.abs(y - targetPos.y);

        if (xDist > yDist) 
        {
            return xDist;
        }
        return yDist;
    }

    public String toString()
    {
        return String.format("(%d,%d)", x, y);
    }
}