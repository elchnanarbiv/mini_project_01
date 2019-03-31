/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primitives;

public class Ray implements Comparable
{
    private Point3D _POO;
    private Vector _direction;
    
    // <editor-fold defaultstate="collapsed" desc="constructors">
    // ***************** Constructors ********************** //
    public Ray()
    {
        setPOO(new Point3D(0,0,0));
        setDirection(new Vector(0,0,0));
    }
    public Ray(Ray ray)
    {
        setPOO(new Point3D(ray.getPOO()));
        setDirection(new Vector(ray.getDirection()));
    }
    public Ray(Point3D poo, Vector direction)        
    {
        setPOO(poo);
        setDirection(direction);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="getters and setters">
    // ***************** Getters/Setters ********************** //
    public void setPOO(Point3D _POO)
    {
        this._POO=_POO;
    }
    public void setDirection(Vector _direction)
    {
        this._direction = _direction;
    }
    public Vector getDirection()
    {
        return _direction;
    }
    public Point3D getPOO()
    {
        return this._POO;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Addministration">
    @Override
    public int compareTo(Object o)
    {
        return (this.equals(o))?0:1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ray other = (Ray) obj;
        if (!this._POO.equals(other._POO)) {
            return false;
        }
        if (!this._direction.equals(other._direction)) {
            return false;
        }
        return true;
    }
    // </editor-fold>
    
}