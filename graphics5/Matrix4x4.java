package graphics5;

public class Matrix4x4 {
        private float[][] _m;
        

        public float[][] get_m() {
			return _m;
		}
		public void set_m(float[][] _m) {
			this._m = _m;
		}
        public void set_m(int i, int j, float val){
            this._m[i][j] = val;
        }
		
		public Matrix4x4()
        {
            float[][] m = new float[4][4];
            _m = m;
        }
		
        public static Matrix4x4 mul(Matrix4x4 m1, Matrix4x4 m2)
        {
            Matrix4x4 result = new Matrix4x4();
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                    for (int k = 0; k < 4; k++)
                        result._m[i][j] += m1._m[i][k] * m2._m[k][j];
            return result;
        }
}
