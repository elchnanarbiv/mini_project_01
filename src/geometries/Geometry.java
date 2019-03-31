/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometries;
import primitives.*;
import java.awt.Color;
import java.util.List;
import java.util.Objects;
/**
 *
 * @author user
 */
public abstract class Geometry
{

    private Material _material = new Material();
    private double _nShininess = 1;
    private Color _emmission = new Color(0, 0, 0);
    public abstract List<Point3D> FindIntersections (Ray ray);
    
    // <editor-fold defaultstate="collapsed" desc="constructors">
    // ***************** Constructors ********************** //
    public Geometry(Material material)
    {    
    }

    public Geometry() 
    {
        
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters/Setters">

    public double   getShininess()
    {
        return _nShininess;
    }
    public Material getMaterial()
    {
        return _material;
    }
    public Color getEmmission()
    {
        return _emmission;
    }
    public void setShininess(double n)
    {
        _nShininess = n;
    }   
    public void setMaterial(Material _material)
    {
        this._material= new Material(_material);
    }
    public void setEmmission(Color emmission)
    {
        this._emmission = new Color(emmission.getRGB());
    }
    public void setKs(double ks)
    {
        this._material.setKs(ks);
    }
    public void setKd(double kd)
    {
        this._material.setKd(kd);
    }
    
    public void setKr(double Kr)
    {
        this._material.setKr(Kr);
    }
    
    public void setKt(double Kt)
    {
        this._material.setKt(Kt);
    }
        // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Administration">
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Geometry rdlGmt = (Geometry) obj;
        if (!Objects.equals(this._material, rdlGmt._material)) {
            return false;
        }
        if (Double.doubleToLongBits(this._nShininess) != Double.doubleToLongBits(rdlGmt._nShininess)) {
            return false;
        }
        if (!Objects.equals(this._emmission, rdlGmt._emmission)) {
            return false;
        }
        final Material mat = (Material) obj;
        return true && mat.equals(this);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Operations">
    public abstract Vector getNormal(Point3D point);
    
    @Override
    public String toString() {
        return "RadialGeometry{" + "_material=" + _material + ", _nShininess" + _nShininess + ", _emmission=" + _emmission + '}';
    }
    // </editor-fold>

}