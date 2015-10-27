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
    private Obstacle obstacle;

    public GameScreen(Context context) {
        super(context);
        this.init();
    }

    public void update(){
        if (update){
            bg.update();
            bird.update();
            obstacle.update();
        }
    }

    protected void onDraw(Canvas canvas){
        //canvas.drawText("Valor do i: " + i, 50, 100, paint);
        bg.drow(canvas);
        bird.drow(canvas);
        obstacle.drow(canvas);
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
        bird.setX(10);
        bird.setY(10);
        bird.updateDistortion(0.5); // Diminuindo a distorção, que estava zicada.

        obstacle = new Obstacle();
        obstacle.setX(1000);
        obstacle.setY(0);
        obstacle.updateDistortion();

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
