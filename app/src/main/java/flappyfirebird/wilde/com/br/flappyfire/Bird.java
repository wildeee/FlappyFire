package flappyfirebird.wilde.com.br.flappyfire;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

import java.io.InputStream;

public class Bird extends GameCoiso {

    private Bitmap figura;
    private Rect src;
    private Rect dst;

    private int spriteWidth;
    private int spriteHeight;

    private static final int spriteImagesAmountHorizontal = 6;
    private static final int spriteImagesAmountVerical = 10;

    private int currentSprite;
    private static final String TAG = "Bird";

    public Bird() {
        try {
            InputStream is = GameParameterSingleton.assetManager.open("bird.png");
            figura = BitmapFactory.decodeStream(is);

            spriteWidth = figura.getWidth() / spriteImagesAmountHorizontal; // Número de imagens na spritesheet
            spriteHeight = figura.getHeight() / spriteImagesAmountVerical;

            setWidth(spriteHeight);
            setHeight(spriteHeight);
            currentSprite = 0;

            src = new Rect(0, 0, getWidth(), getHeight());
            dst = new Rect();
        }
        catch (Exception ex){
            Log.d(TAG, "Erro ao carregar imagem.");
        }
    }

    @Override
    public void update() {
        src.top = 0;
        src.bottom = spriteHeight;
        src.left = currentSprite * spriteWidth;
        src.right = src.left + spriteWidth;

        dst.top = getY();
        dst.bottom = getY() + getHeight();
        dst.left = getX();
        dst.right = getX() + getWidth();

        currentSprite = (currentSprite + 1) % spriteImagesAmountHorizontal;
    }

    @Override
    public void drow(Canvas canvas) {
        canvas.drawBitmap(figura, src, dst, null);;
    }

}
