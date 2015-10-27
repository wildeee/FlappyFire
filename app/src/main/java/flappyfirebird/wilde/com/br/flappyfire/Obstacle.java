package flappyfirebird.wilde.com.br.flappyfire;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

import java.io.InputStream;

public class Obstacle extends GameCoiso {

    private Bitmap figura;
    private Rect src;
    private Rect dst;

    private int spriteColumn;

    private int spriteWidth;
    private int spriteHeight;

    private static final int STEP = 5;

    private static final String TAG = "Obstacle";

    public Obstacle() {
        try {
            InputStream is = GameParameterSingleton.assetManager.open("obstacle.png");
            figura = BitmapFactory.decodeStream(is);

            spriteWidth = figura.getWidth();
            spriteHeight = figura.getHeight();

            setWidth(spriteHeight);
            setHeight(spriteHeight);

            src = new Rect(0, 0, getWidth(), getHeight());
            dst = new Rect();
        }
        catch (Exception ex){
            Log.d(TAG, "Erro ao carregar imagem.");
        }
    }

    @Override
    public void update() {

        int passoDistorcido = (int)(this.STEP * GameParameterSingleton.DISTORTION);
        setX(getX() - passoDistorcido);

        src.left = spriteColumn * spriteWidth;
        src.right = src.left + spriteWidth;
        src.top = 0;
        src.bottom = spriteHeight;

        dst.left = getX();
        dst.right = dst.left + getWidth();
        dst.top = getY();
        dst.bottom = getY() + getHeight();

        spriteColumn = (spriteColumn + 1) % 4;
    }

    @Override
    public void drow(Canvas canvas) {
        canvas.drawBitmap(figura, src, dst, null);;
    }
}
