/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometries;

import primitives.Material;

/**
 *
 * @author user
 */
public abstract class RadialGeometry extends Geometry
{
    protected double _radius;
    // <editor-fold defaultstate="collapsed" desc="constructors">
    public RadialGeometry()
    {
        super();
        this.setRadius(0);
    }

    public RadialGeometry(double radius, Material material) {
        super(material);
        this.setRadius(radius);
    }
    
    public RadialGeometry(double radius)
    {
        super();
        this.setRadius(radius);
    }
    
    // <editor-fold defaultstate="collapsed" desc="constructors">
    public double getRadius()
    {
        return this._radius;
    }
    public final void setRadius(double radius)
    {
        if(radius<0) 
            throw new ArithmeticException();//the rsdius can't be negtive
        this._radius = radius;
    }
}
