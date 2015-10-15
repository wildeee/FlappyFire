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

    public GameScreen(Context context) {
        super(context);
        this.init();
    }

    public void update(){
        if (update){
            i++;
        }
    }

    protected void onDraw(Canvas canvas){
        canvas.drawText("Valor do i: " + i, 50, 100, paint);
    }

    public void init(){
        this.i = 0;
        this.update = true;
        paint = new Paint();
        paint.setColor(Color.BLACK);
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
