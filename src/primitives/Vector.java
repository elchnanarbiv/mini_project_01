/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primitives;
import java.util.Objects;


public class Vector implements Comparable
{
    private Point3D _head;
    
    // <editor-fold defaultstate="collapsed" desc="constructors">
    public Vector()
    {
        _head = new Point3D();
    }
    public Vector(Point3D head)
    {
        this.setHead(head);
    }
    public Vector(Vector vector)
    {
        this.setHead(vector.getHead());
    }
    public Vector(double xHead, double yHead, double zHead)
    {
        this.setHead(new Point3D(xHead,yHead,zHead));
    }
    public Vector(Point3D p1, Point3D p2)
    {
        double X = p1.get_x().getCoord()-p1.get_x().getCoord();
        double Y = p1.get_y().getCoord()-p1.get_y().getCoord();
        double Z = p1.get_z().getCoord()-p1.get_z().getCoord();
        this.setHead(new Point3D(X,Y,Z));
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" getters and setters">
    public Point3D getHead()
    {
        return new Point3D(_head);
    }
    public final void setHead(Point3D head)
    {
        _head = new Point3D(head);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="addministration">
    // ***************** Administration ******************** //
    
    @Override
    public int compareTo(Object o)
    {
        return (this.equals(o))? 0 : 1;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vector other = (Vector) obj;
        if (!Objects.equals(this._head, other._head)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return this._head.toString();
    }
        // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="operation">

    // ***************** Operations ******************** //
    
    public Vector add (Vector vector )
    {
        return new Vector(this._head.add(vector));
    }
    
    public Vector subtract(Vector vector)
    {
        return new Vector(this._head.subtruct(vector));
    }
    
    public Vector scale(double scalingFactor)
    {
        Coordinate X = new Coordinate(this._head.get_x().getCoord()*scalingFactor);
        Coordinate Y = new Coordinate(this._head.get_y().getCoord()*scalingFactor);
        Coordinate Z = new Coordinate(this._head.get_z().getCoord()*scalingFactor);
        
        return new Vector(new Point3D(X,Y,Z));
    }
    public Vector crossProduct(Vector vector)
    {
        Coordinate X = new Coordinate( this.getHead().get_y().getCoord()*vector.getHead().get_z().getCoord()-this.getHead().get_z().getCoord()*vector.getHead().get_y().getCoord());
        Coordinate Y = new Coordinate(this.getHead().get_z().getCoord()*vector.getHead().get_x().getCoord() - this.getHead().get_x().getCoord()*vector.getHead().get_z().getCoord());
        Coordinate Z = new Coordinate( this.getHead().get_x().getCoord()*vector.getHead().get_y().getCoord()-this.getHead().get_y().getCoord()*vector.getHead().get_x().getCoord());
       
        return new Vector(new Point3D(X,Y,Z));
    }
    
    public double length()
    {
        return this._head.distance(new Point3D(0,0,0));
    }
    
    public Vector normalize()
    {
        double distance = this.length();
       // Throws exception if length = 0
        if(distance==0) throw new ArithmeticException();
        //*************************************//
        return this.scale(1/distance);
    }
        
    
    public double dotProduct(Vector vector)
    {
        return   this.getHead().get_x().getCoord()*vector.getHead().get_x().getCoord()
                +this.getHead().get_y().getCoord()*vector.getHead().get_y().getCoord()
                +this.getHead().get_z().getCoord()*vector.getHead().get_z().getCoord();
    }
    // </editor-fold>
}
