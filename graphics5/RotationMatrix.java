package graphics5;

public class RotationMatrix extends Matrix4x4{
	private float _alpha;
    public float get_alpha() {
		return _alpha;
	}

	public void set_alpha(float _alpha) {
		this._alpha = _alpha;
		CalculateMatrix();
	}

	private Vector4_ _rotationAxis;

    public RotationMatrix(Vector4_ rotationAxis, float alpha) //=0f
    {
        _alpha = alpha;
        RotationAxis = rotationAxis;
    }

    public Vector4_ RotationAxis;
    
    public Vector4_ getRotationAxis() {
		return _rotationAxis;
	}

	public void setRotationAxis(Vector4_ rotationAxis) {
		_rotationAxis = rotationAxis;
        _rotationAxis.Normalize();
        CalculateMatrix();
	}
	
    private void CalculateMatrix()
    {
        Vector4_ rotationAxis = RotationAxis;
        float num = (float)Math.sin(_alpha);
        float num2 = (float)Math.cos(_alpha);
        float[][] array = new float[4][4];
        array[0][0] = rotationAxis.getX() * rotationAxis.getX() + (1f - rotationAxis.getX() * rotationAxis.getX()) * num2;
        array[0][1] = rotationAxis.getX() * rotationAxis.getY() * (1f - num2) - rotationAxis.getZ() * num;
        array[0][2] = rotationAxis.getX() * rotationAxis.getZ() * (1f - num2) + rotationAxis.getY() * num;
        array[1][0] = rotationAxis.getX() * rotationAxis.getY() * (1f - num2) + rotationAxis.getZ() * num;
        array[1][1] = rotationAxis.getY() * rotationAxis.getY() + (1f - rotationAxis.getY() * rotationAxis.getY()) * num2;
        array[1][2] = rotationAxis.getY() * rotationAxis.getZ() * (1f - num2) - rotationAxis.getX() * num;
        array[2][0] = rotationAxis.getX() * rotationAxis.getZ() * (1f - num2) - rotationAxis.getY() * num;
        array[2][1] = rotationAxis.getY() * rotationAxis.getZ() * (1f - num2) + rotationAxis.getX() * num;
        array[2][2] = rotationAxis.getZ() * rotationAxis.getZ() + (1f - rotationAxis.getZ() * rotationAxis.getZ()) * num2;
        array[3][3] = 1f;
        float[][] array2 = array;
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                super.get_m()[i][j] = array2[i][j];
            }
        }
    }
}

