package flappyfirebird.wilde.com.br.flappyfire;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class GameScreen extends View implements Runnable {

    private static final String TAG = "GameScreen";
    private boolean update;
    private int i;
    private Paint paint;

    private InfiniteBackground bg;
    private Bird bird;

    public GameScreen(Context context) {
        super(context);
        this.init();
    }

    public void update(){
        if (update){
            bg.update();
            bird.update();
        }
    }

    protected void onDraw(Canvas canvas){
        //canvas.drawText("Valor do i: " + i, 50, 100, paint);
        bg.drow(canvas);
        bird.drow(canvas);
    }

    public void init(){
        this.i = 0;
        this.update = true;
        paint = new Paint();
        paint.setColor(Color.BLACK);

        // criar objetos do jogo
        bg = new InfiniteBackground();
        // definir fator de distorcao
        GameParameterSingleton.DISTORTION = (float) GameParameterSingleton.SCREEN_HEIGHT / bg.getHeight();

        bg.updateDistortion();

        bird = new Bird();
        bird.setX(0);
        bird.setY(0);
        bird.updateDistortion();

    }

    @Override
    public void run() {
        while (true){
            try {
                this.update();
                postInvalidate();
                Thread.sleep(50);
            }
            catch (Exception ex){
                Log.d(TAG, "Erro no Loop do jogo.");
            }
        }
    }
}
