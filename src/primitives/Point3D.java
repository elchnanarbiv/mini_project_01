/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primitives;
import java.util.Objects;

public class Point3D extends Point2D implements Comparable
{
    private Coordinate _z;
    
    // <editor-fold defaultstate="collapsed" desc="constructors getters and setters">
    public Point3D()
    {
        super(0,0);
        set_z(new Coordinate(0));
    }
    
    public Point3D(double x, double y, double z) 
    {
        super(x, y);
        this.set_z(new Coordinate(z));
    } 
    
    public Point3D(Coordinate x, Coordinate y, Coordinate z) 
    {
        super(x, y);
        this.set_z(z);
    } 

    public Point3D(Point3D other)
    {
        super(other.get_x(),other.get_y());
        this.set_z(other.get_z());
    }

    
    public Coordinate get_z()
    {
        return new Coordinate( _z);
    }

    public final void set_z(Coordinate z)
    {
        this._z =new Coordinate(z);//when i define the vaiue of z i suppose that you don't give me z that used in anothe place
    }
    
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="administration: including compare & toString & equal functions">
   
    @Override
    public int compareTo(Object o)
    {
        return (this.equals(o))? 0:1;
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
        final Point3D other = (Point3D) obj;
        if (!Objects.equals(this._z, other._z))
        {
            return false;
        }
        return true && super.equals(obj);
    }

    @Override
    public String toString() 
    {
        return String.format("%s, %s)",super.toString(),this.get_z()); 
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="operations: distanceInPow + distance">
    
    public double distanceInPow(Point3D other)
    {
        if(other==null) throw new ArithmeticException();
        double distX = this.get_x().getCoord() - other.get_x().getCoord();
        double distY = this.get_y().getCoord() - other.get_y().getCoord();
        double distZ = this.get_z().getCoord() - other.get_z().getCoord();
        return distX*distX+distY*distY+distZ*distZ;
    }
    
    public double distance(Point3D other)
    {
        return Math.sqrt(distanceInPow(other));
    }
    
    public Point3D subtruct(Vector vector)
    {
        //notice!! subtract func' return nothig and get func' return a copy X / Y /Z
        if(vector==null) throw new ArithmeticException();

        Point3D pVec = vector.getHead();
        
        Coordinate X= this.get_x().subtract(pVec.get_x());
        Coordinate Y= this.get_y().subtract(pVec.get_y());
        Coordinate Z= this.get_z().subtract(pVec.get_z());
     
        return new Point3D(X,Y,Z);
    }
    
    public Point3D add(Vector vector)
    {
        if(vector==null) throw new ArithmeticException();

        Point3D pVec = vector.getHead();
        
        Coordinate X= this.get_x().add(pVec.get_x());
        Coordinate Y= this.get_y().add(pVec.get_y());
        Coordinate Z= this.get_z().add(pVec.get_z());
     
        return new Point3D(X,Y,Z);
    }
    
    // </editor-fold>

}