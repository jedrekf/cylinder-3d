package graphics5;

import java.awt.Graphics;
import java.awt.List;
import java.util.ArrayList;

public class TriangularMesh extends ArrayList<Triangle3D>{
	
	protected static ArrayList<Triangle3D> instance = new ArrayList<Triangle3D>();
	
    public void DrawOnlyMesh(Graphics g, Vector4_ viewDirection, Matrix4x4 m)
    {
        for (Triangle3D current : this)
        {
            Triangle3D triangle3D = Triangle3D.mul(m, current);
            if (Vector4_.mul(viewDirection,triangle3D.getNormal()) <= 0f)
            {
                triangle3D.Draw(g);
            }
        }
    }

    public static TriangularMesh mul(Matrix4x4 m, TriangularMesh t)
    {
    	TriangularMesh triangularMesh = new TriangularMesh();
    	for (int i=0; i<t.size(); i++)
    	{
    		triangularMesh.add(Triangle3D.mul(m,t.get(i)));
        }

        // triangularMesh.AddRange(t.Select(current => m * current));
        //triangularMesh.addAll(mul(m,t));
        return triangularMesh;
    }

    public static TriangularMesh CreateCilinderTriangularMesh(float y, float num) //(float y = 200f, float num = 50f)
    {
    	TriangularMesh triangularMesh = new TriangularMesh();

        int Num2 = 20; //density of mesh
        for (int i = 0; i < 360; i += Num2)
        {
        	Vector4_ v = new Vector4_(0f, 0f, 0f);
        	Vector4_ v2 = new Vector4_(num * (float)Math.sin((i + Num2) * Math.PI / 180.0), 0f,
                                 num * (float)Math.cos((i + Num2) * Math.PI / 180.0));
        	Vector4_ v3 = new Vector4_(num * (float)Math.sin(i * Math.PI / 180.0), 0f, num * (float)Math.cos(i * Math.PI / 180.0));
        	triangularMesh.add(new Triangle3D(v, v2, v3));
            v = new Vector4_(num * (float)Math.sin(i * Math.PI / 180.0), y, num * (float)Math.cos((i) * Math.PI / 180.0));
            v2 = new Vector4_(num * (float)Math.sin(i * Math.PI / 180.0), 0f, num * (float)Math.cos(i * Math.PI / 180.0));
            v3 = new Vector4_(num * (float)Math.sin((i + Num2) * Math.PI / 180.0), 0f,
                             num * (float)Math.cos((i + Num2) * Math.PI / 180.0));
            triangularMesh.add(new Triangle3D(v, v2, v3));

            v = new Vector4_(num * (float)Math.sin((i + Num2) * Math.PI / 180.0), 0f,
                            num * (float)Math.cos((i + Num2) * Math.PI / 180.0));
            v3 = new Vector4_(num * (float)Math.sin(i * Math.PI / 180.0), y, num * (float)Math.cos(i * Math.PI / 180.0));
            v2 = new Vector4_(num * (float)Math.sin((i + Num2) * Math.PI / 180.0), y,
                             num * (float)Math.cos((i + Num2) * Math.PI / 180.0));
            triangularMesh.add(new Triangle3D(v, v2, v3));

            v = new Vector4_(0f, y, 0f);
            v2 = new Vector4_(num * (float)Math.sin(i * Math.PI / 180.0), y, num * (float)Math.cos(i * Math.PI / 180.0));
            v3 = new Vector4_(num * (float)Math.sin((i + Num2) * Math.PI / 180.0), y,
                             num * (float)Math.cos((i + Num2) * Math.PI / 180.0));
            triangularMesh.add(new Triangle3D(v, v2, v3));
        }
        return triangularMesh;
    }


    public static TriangularMesh CreateMesh() //=0
    {
        TriangularMesh mesh = new TriangularMesh();
        TranslationMatrix transMesh = new TranslationMatrix(0, -150, 0);
        TriangularMesh trianMesh =CreateCilinderTriangularMesh(300, 100);
        mesh.addAll((mul(transMesh,trianMesh)));
        return mesh;
    }
}

