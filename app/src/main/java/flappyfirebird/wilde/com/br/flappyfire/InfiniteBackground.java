package flappyfirebird.wilde.com.br.flappyfire;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

import java.io.InputStream;

public class InfiniteBackground {

    private Bitmap figura;
    private int height;
    private int width;
    private Rect src;
    private Rect first;
    private Rect second;

    private static final String TAG = "InfiniteBackground";

    public InfiniteBackground(){
        try {
            InputStream is = GameParameterSingleton.assetManager.open("cenario1.png");
            figura = BitmapFactory.decodeStream(is);
            height = figura.getHeight();
            width = figura.getWidth();

            src = new Rect(0, 0, width, height);
            first = new Rect();
            second = new Rect();

        }
        catch (Exception ex){
            Log.d(TAG, "Erro ao decodificar imagem");
        }
    }

    public void update(){
        // como se move
        first.left = 0;
        first.right = width;
        first.top = 0;
        first.bottom = height;
    }

    public void drow(Canvas canvas){
        canvas.drawBitmap(figura, src, first, null);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
