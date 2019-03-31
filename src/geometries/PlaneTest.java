package geometries;

import org.junit.Test;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.Assert.*;

public class PlaneTest {

    @Test
    public void findIntersections() {
        Vector vector= new Vector(-17,6,2);
        Point3D point3D = new Point3D (0,0,0);

        Plane plane=new Plane (vector,point3D);


    }
}