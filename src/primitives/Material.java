package primitives;

public class Material implements Comparable
{
    
    private double _Kd; // Diffusion attenuation coefficient
    private double _Ks; // Specular attenuation coefficient
    private double _Kr; // Reflection coefficient (1 for mirror)
    private double _Kt; // Refraction coefficient (1 for transparent)
    private double _n; // Refraction index
    
    // <editor-fold defaultstate="collapsed" desc="constructors">
    public Material()
    {
        _Kd = 1;
        _Ks = 1;
        _Kr = 0;
        _Kt = 0;
        _n = 1;
    }
    
    public Material(Material material)
    {
        
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="setters & getters">
    public double getKd()
    {
        return _Kd;
    }
    public double getKs()
    {
        return _Ks;
    }
    public double getKr()
    {
        return _Kr;
    }
    public double getKt()
    {
        return _Kt;
    }
    public double getN()
    {
        return _n;
    }
    
    public void setKd(double _Kd)
    {
          this._Kd = _Kd;
    }
    public void setKs(double _Ks)
    {
          this._Kd = _Ks;
    }
    public void setKt(double _Kt)
    {
          this._Kt = _Kt;
    }
    
    public void setKr(double _Kr)
    {
          this._Kr = _Kr;
    }
    
    public void setN(double _n)
    {
          this._n = _n;
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
        final Material other = (Material) obj;
        if (Double.doubleToLongBits(this._Kd) != Double.doubleToLongBits(other._Kd)) {
            return false;
        }
        if (Double.doubleToLongBits(this._Ks) != Double.doubleToLongBits(other._Ks)) {
            return false;
        }
        if (Double.doubleToLongBits(this._Kr) != Double.doubleToLongBits(other._Kr)) {
            return false;
        }
        if (Double.doubleToLongBits(this._Kt) != Double.doubleToLongBits(other._Kt)) {
            return false;
        }
        if (Double.doubleToLongBits(this._n) != Double.doubleToLongBits(other._n)) {
            return false;
        }
        return true;
    }

    
    @Override
    public int compareTo(Object o)
    {
        return (this.equals(o))?0:1;
    }
    
    @Override
    public String toString()
    {
        return "Material{" + "_Kd=" + _Kd + ", _Ks=" + _Ks + ", _Kr=" + _Kr + ", _Kt=" + _Kt + ", _n=" + _n + '}';
    }

    // </editor-fold>
}
