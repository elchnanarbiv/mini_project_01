/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometries;
import java.util.ArrayList;
import primitives.*;
import java.util.List;
/**
 *
 * @author user
 */
public class Plane extends Geometry implements FlatGeometry
{
    private Vector _normal;
    private Point3D _Q;
    
    // ***************** Constructors ********************** // 
    
    public Plane()
    {
        this.setNormal(new Vector());
        this.setQ(new Point3D());
    }
    
    public Plane (Plane plane)
    {
        this.setQ(plane.getQ());
        this.setNormal(plane.getNormal(plane.getQ()));
    }
    
    public Plane(Vector normal, Point3D q)
    {
        this.setQ(new Point3D(q));
        this.setNormal(new Vector(normal));
    }
 
    // ***************** Getters/Setters ********************** // 
    
    @Override
    public Vector getNormal(Point3D point)
    {
        return new Vector(this._normal);
    }
    public Point3D getQ()
    {
        return new Point3D(_Q);
    }
    public final void setNormal(Vector normal)
    {
        this._normal = new Vector(normal);
    }
    public final void setQ(Point3D d)
    {
        this._Q = new Point3D(d);
    }
 
    // ***************** Operations ******************** //
    public List<Point3D> FindIntersections(Ray ray)
    {
        
        //checking if the direction of ray is orthognal to the normal.
        //in this case there is no intersections and the function return null  
        if(ray.getDirection().dotProduct(this.getNormal(this.getQ()))==0)
        {
           //
            return null;
        }
        
        double t = -this._normal.dotProduct(new Vector(ray.getPOO().subtruct(new Vector(this._Q))))
                /ray.getDirection().dotProduct(this.getNormal(this.getQ()));
        
        //the plane must be in back off the camera 
        if(t<=0)
            return null;
        
        //the plane must be in front off the camera
        ArrayList<Point3D> intersections = new ArrayList<Point3D>();
        intersections.add(ray.getPOO().add(ray.getDirection().scale(t)));
        return intersections;
        
    }
}
