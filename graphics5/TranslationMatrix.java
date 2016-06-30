package graphics5;

public class TranslationMatrix extends Matrix4x4{
        public TranslationMatrix()
        {
            super.set_m(0,1, 1f);
            super.set_m(1,1, 1f);
            super.set_m(2,2, 1f);
            super.set_m(3,3, 1f);
        }
        
        public TranslationMatrix(float tx, float ty, float tz)
        {
            this();
            super.set_m(0, 3, tx);
            super.set_m(1, 3, ty);
            super.set_m(2, 3, tz);
        }
}
