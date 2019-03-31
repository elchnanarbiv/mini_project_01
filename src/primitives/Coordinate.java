package primitives;

import static primitives.Util.*;

public final class Coordinate implements Comparable
{
    //private static final double EPSILON = 0.0000001;
    private double _coord;

    // <editor-fold defaultstate="collapsed" desc="constructors">
    public Coordinate(double coord)
    {
        // if it too close to zero make it zero
        _coord = alignZero(coord);
    }

    public Coordinate()
    {
        this.setCoord(0);
    }

    public Coordinate(Coordinate other) {
        _coord = other._coord;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="getters % setters">
    public double getCoord() {
        return _coord;
    }

    public void setCoord(double _coord) {
        this._coord = _coord;
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Addministration">    
    @Override
    public int compareTo(Object o)
    {  
        if (getClass() != o.getClass())
        {
            throw new IllegalArgumentException();
        }
        Coordinate coord = (Coordinate)o;
        return Double.compare(this.getCoord(),coord.getCoord());
    }
    
    @Override
    public String toString()
    {
        return String.format("%,.2f", _coord);
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coordinate other = (Coordinate) obj;
        if (Double.doubleToLongBits(this._coord) != Double.doubleToLongBits(other._coord)) {
            return false;
        }
        return true;
    }
        // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Operation">    
    public Coordinate subtract(Coordinate other)
    {
        return new Coordinate(usubtract(_coord, other._coord));
    }

    public Coordinate add(Coordinate other)
    {
         return new Coordinate(uadd(_coord, other._coord));
    }
    // </editor-fold>
    
}
