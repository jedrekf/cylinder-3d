package graphics5;

import java.awt.Point;
import java.awt.geom.Point2D;

public class Vector4_ {
	 public float[] _p = new float[4];

     public float get_p(int i) {
		return _p[i];
	}

	public void set_p(int i, float _p) {
		this._p[i] = _p;
	}

	public Vector4_()
     {
     }

     public Vector4_(float x, float y, float z)
     {
         _p[0] = x;
         _p[1] = y;
         _p[2] = z;
         _p[3] = 1f;
     }
     
     public float getX() {
		return _p[0];
	}

    public float getY() {
		return _p[1];
	}

    public float getZ() {
		return _p[2];
	}

     public void Normalize()
     {
         for (int i = 0; i < 4; i++)
             this._p[i] /= this._p[3];

     }

     public float EuclidLen()
     {
         return (float)Math.sqrt((getX() * getX() + getY() * getY() + getZ() * getZ()));
     }

     public static float mul(Vector4_ m, Vector4_ v)
     {
         float num = 0f;
         for (int i = 0; i < 3; i++)
         {
             num += m._p[i] * v._p[i];
         }
         return num;
     }

     public static Vector4_ CrossProduct(Vector4_ v1, Vector4_ v2)
     {
         return new Vector4_(v1.getY() * v2.getZ() - v2.getY() * v1.getZ(), -v1.getX() * v2.getZ() 
        		 + v2.getX() * v1.getZ(), -v1.getY() * v2.getX() + v2.getY() * v1.getX());
     }




     public static Vector4_ mul(Matrix4x4 m, Vector4_ v)
     {
         Vector4_ vector = new Vector4_();
         for (int i = 0; i < 4; i++)
             for (int j = 0; j < 4; j++)
                 vector._p[i] += m.get_m()[i][j] * v._p[j];

         vector.Normalize();
         return vector;
     }
}
