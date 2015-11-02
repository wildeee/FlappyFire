package flappyfirebird.wilde.com.br.flappyfire;

import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

public class Bird extends GameCoiso {
    private static final String TAG="Bird";
    private Bitmap bitmap;
    private int    spriteColumn;
    private Rect   src;
    private Rect   dst;
    private int    imageWidth;
    private int    imageHeight;

    private EMovementType direcao;

    public static final float boundingBoxReduction = 0.4f;

    public Bird(){
        try{
			/* ler o arquivo de imagem */
            InputStream is = GameParameterSingleton.assetManager.open("bird.png");
            bitmap = BitmapFactory.decodeStream(is);

			/* ajustar parametros de altura e largura */
            imageWidth = bitmap.getWidth() / 10;
            imageHeight = bitmap.getHeight();
            src = new Rect(0,0,imageWidth,imageHeight);
            setWidth(imageWidth);
            setHeight(imageHeight);

            // ajustando o bounding box;
            spriteColumn = 0;
            dst = new Rect();

            //setando direção inicial
            direcao = EMovementType.DESCE;

        }
        catch(Exception e){
            Log.d(TAG, "Erro ao carregar Sprite");
        }
    }

    @Override
    public void update() {

        if (direcao == EMovementType.SOBE){
            setY(getY() - (int)(direcao.getStep() * GameParameterSingleton.DISTORTION));
            getBoundingBox().setY(getBoundingBox().getY() - (int)(direcao.getStep() * GameParameterSingleton.DISTORTION));
        }
        else{
            setY(getY() + (int)(direcao.getStep() * GameParameterSingleton.DISTORTION));
            getBoundingBox().setY(getBoundingBox().getY() + (int)(direcao.getStep() * GameParameterSingleton.DISTORTION));
        }
        src.left = spriteColumn*imageWidth;
        src.right = src.left + imageWidth;

        spriteColumn = (spriteColumn+1)%10;

        dst.left   = super.getX();
        dst.top    = super.getY();
        dst.right  = dst.left + super.getWidth();
        dst.bottom = dst.top + super.getHeight();
    }

    public EMovementType getDirecao() {
        return direcao;
    }

    public void setDirecao(EMovementType direcao) {
        this.direcao = direcao;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, src, dst, null);
    }

}
