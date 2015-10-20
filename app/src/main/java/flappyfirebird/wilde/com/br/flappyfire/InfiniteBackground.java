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

    private static final int STEP = 5;

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

    public void updateDistortion(){
        setWidth((int) (getWidth() * GameParameterSingleton.DISTORTION));
        setHeight((int) (getHeight() * GameParameterSingleton.DISTORTION));

        first.left = 0;
        first.top = 0;
        first.right = width;
        first.bottom = height;

        second.top = 0;
        second.left = width;
        second.right = second.left + width;
        second.bottom = height;

    }

    public void update(){
        // como se move
        int passoDistorcido = (int) (STEP * GameParameterSingleton.DISTORTION);
        first.left -= passoDistorcido;
        first.right -= passoDistorcido;
        first.top = 0;
        first.bottom = getHeight();

        second.top = 0;
        second.bottom = getHeight();
        second.left -= passoDistorcido;
        second.right -= passoDistorcido;

        if (first.right <= 0){
            first.left = second.right;
            first.right = second.right + width;
        }

        if (second.right <= 0){
            second.left = first.right;
            second.right = first.right + width;
        }
    }

    public void drow(Canvas canvas){

        canvas.drawBitmap(figura, src, first, null);
        canvas.drawBitmap(figura, src, second, null);

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
