package graphics5;

import javafx.scene.layout.Pane;

import java.awt.*;

import javax.swing.JPanel;

public class DoubleBufferedPanel extends JPanel {
    @Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
        Matrix4x4 matrix = new Matrix4x4();
            matrix.set_m(0,0, 1f);
            matrix.set_m(1,1, 1f);
            matrix.set_m(3,2, -0.002f);
            matrix.set_m(3,3, 1f);
        //matrix.set_m(new float[][]{{(float)(1f/Math.tan(Math.PI/2)),0,0,0}, {0, (float)(1f/Math.tan(Math.PI/2))/(666/510),0,0},
         //       {0,0,-1,0}, {0,0,-1,0}});
        matrix = Matrix4x4.mul(new TranslationMatrix(this.getWidth() / 2.0f, this.getHeight() / 2.0f, 0f),matrix);
        (TriangularMesh.mul(_m,PanelMesh)).DrawOnlyMesh(g, new Vector4_(0f, 0f, -1f), matrix);
	}

		private float _alpha = 0;
        private float _alphaX = 0;
        private float _alphaY = 0;
		private float _alphaZ = 0;
        private Matrix4x4 _m;
        private float _transX = 0;
        private float _transY = 0;
        private float _transZ = 0;
        
        public float get_alphaY() {
			return _alphaY;
		}


		public void set_alphaY(float _alphaY) {
			this._alphaY = _alphaY;
			CalculeM();
            this.repaint();
		}


		public float get_alphaZ() {
			return _alphaZ;
		}


		public void set_alphaZ(float _alphaZ) {
			this._alphaZ = _alphaZ;
			CalculeM();
            this.repaint();
		}


		public float get_transX() {
			return _transX;
		}


		public void set_transX(float _transX) {
			this._transX = _transX;
			CalculeM();
            this.repaint();
		}


		public float get_transY() {
			return _transY;
		}


		public void set_transY(float _transY) {
			this._transY = _transY;
			CalculeM();
            this.repaint();
		}


		public float get_transZ() {
			return _transZ;
		}


		public void set_transZ(float _transZ) {
			this._transZ = _transZ;
			CalculeM();
            this.repaint();
		}
        
        public float get_alpha() {
			return _alpha;
		}


		public void set_alpha(float _alpha) {
			this._alpha = _alpha;
            CalculeM();
            this.repaint();
		}

        public float get_alphaX() {
			return _alphaX;
		}


		public void set_alphaX(float _alphaX) {
			this._alphaX = _alphaX;
			CalculeM();
			this.repaint();
		}

        public DoubleBufferedPanel()
        {
            super.setDoubleBuffered(true);
            CalculeM();
            PanelMesh = new TriangularMesh();
            PanelMesh.addAll(TriangularMesh.CreateMesh());
        }

        public TriangularMesh PanelMesh;

        private void CalculeM()
        {
            RotationMatrix rotationMatrix = new RotationMatrix(new AxisVector(1f, 0f, 0f), get_alphaX());
            Matrix4x4 m = Matrix4x4.mul(rotationMatrix,
                          new RotationMatrix(new AxisVector(0f, 1f, 0f), get_alphaY()));

            m = Matrix4x4.mul(m,new RotationMatrix(new AxisVector(0, 0, 1), get_alphaZ()));

            Matrix4x4 m2 = new TranslationMatrix(get_transX(), get_transY(), get_transZ());
            _m = Matrix4x4.mul(m2,m);
            System.out.println("space calculated");
            Matrix4x4 x = new Matrix4x4();
            float[][] multi = new float[][]{
            	{1, 0, 0, 0},
            	{0, 1, 0, 0},
            	{0, 0, 1, 0},
            	{0, 0, 0, 1}};
            x.set_m(multi);
           _m = x;
        }
}
