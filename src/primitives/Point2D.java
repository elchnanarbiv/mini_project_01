package primitives;

import java.util.Objects;

public class Point2D implements Comparable
{
    private Coordinate _x;
    private Coordinate _y;
    
    // <editor-fold defaultstate="collapsed" desc="constructor">
    
    public Point2D(Coordinate x, Coordinate y) {
        this.set_x(x);
        this.set_y(y);
    }
    public Point2D(double x, double y) {
        this.set_x(new Coordinate(x));
        this.set_y(new Coordinate(y));
    }
    public Point2D(Point2D other)
    {
        this.set_x(other.get_x());
        this.set_y(other.get_y());
    }

    public Point2D()
    {
        this.set_x(new Coordinate(0));
        this.set_y(new Coordinate(0));
        
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="getters and setters">
    public Coordinate get_y()
    {
        //consideration of security return back copy of Y
        return new Coordinate(_y);
    }

    public Coordinate get_x()
    {
        //consideration of security return back copy of X
        return new Coordinate(_x);
    }

    public final void set_y(Coordinate _y) {
        this._y = new Coordinate(_y);
    }

    public final void set_x(Coordinate _x) {
        this._x = new Coordinate(_x);
    }
    
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="to string + compare">
    
    @Override
    public String toString()
    {
        String str  =  String.format("(%s, %s",_x.toString(),_y.toString());
        if(this.getClass()==Point2D.class) str=str + ')';
        return str;
    }
    
    @Override
    public int compareTo(Object o)
    {
        return (this.equals(o))? 0 :1; 
    }     

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Point2D other = (Point2D) obj;
        if (!Objects.equals(this._x, other._x)) {
            return false;
        }
        if (!Objects.equals(this._y, other._y)) {
            return false;
        }
        return true;
    }
    
    // </editor-fold>

}