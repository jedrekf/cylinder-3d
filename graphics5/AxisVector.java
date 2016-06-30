package graphics5;

public class AxisVector extends Vector4_{

        public AxisVector(float x, float y, float z)
        {
            super(x,y,z);
            super._p[3] = (float) Math.sqrt((x*x + y*y + z*z));
            super.Normalize();
        }

}
