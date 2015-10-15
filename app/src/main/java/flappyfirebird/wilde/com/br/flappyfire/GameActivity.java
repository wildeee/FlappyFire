package flappyfirebird.wilde.com.br.flappyfire;

import android.app.Activity;
import android.os.Bundle;


public class GameActivity extends Activity {

    private GameScreen gameScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameScreen = new GameScreen(this);
        setContentView(gameScreen);

        Thread t = new Thread(gameScreen);
        t.start();
    }


}
