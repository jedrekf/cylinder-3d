package graphics5;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle3D {
    private Vector4_[] _v;

    public Vector4_ get_v(int i) {
		return _v[i];
	}

	public void set_v(int i, Vector4_ _v) {
		this._v[i] = _v;
	}

	public Triangle3D(Vector4_ v1, Vector4_ v2, Vector4_ v3)
    {
        _v = new Vector4_[]
                 {
                     v1,
                     v2,
                     v3
                 };
    }

    public Vector4_ getNormal() {
    	for (int i = 0; i < 4; i++)
        {
            _v[1]._p[i] -= _v[0]._p[i];
            _v[2]._p[i] -= _v[0]._p[i];

        }
        Vector4_ vector3 = Vector4_.CrossProduct(_v[1], _v[2]);
        for (int i = 0; i < 4; i++)
        {
            _v[1]._p[i] += _v[0]._p[i];
            _v[2]._p[i] += _v[0]._p[i];
        }
        float num = vector3.EuclidLen();
        for (int k = 0; k < 3; k++)
        {
            vector3._p[k] /= num;
        }
        return vector3;
	}

    public static Triangle3D mul(Matrix4x4 m, Triangle3D t)
    {
        return new Triangle3D(Vector4_.mul(m,t._v[0]), Vector4_.mul(m,t._v[1]), Vector4_.mul(m,t._v[2]));
    }

    public void Draw(Graphics g)
    {
    	g.drawLine((int)_v[0].getX(), (int)_v[0].getY(), (int)_v[1].getX(), (int)_v[1].getY());
    	g.drawLine((int)_v[1].getX(), (int)_v[1].getY(), (int)_v[2].getX(), (int)_v[2].getY());
    	g.drawLine((int)_v[2].getX(), (int)_v[2].getY(), (int)_v[0].getX(), (int)_v[0].getY());
    }
}
