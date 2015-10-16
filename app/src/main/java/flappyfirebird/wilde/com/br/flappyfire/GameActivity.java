package flappyfirebird.wilde.com.br.flappyfire;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;


public class GameActivity extends Activity {

    private GameScreen gameScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setupParameters();
        this.gameScreen = new GameScreen(this);

        super.setContentView(gameScreen);

        Thread t = new Thread(gameScreen);
        t.start();
    }

    private void setupParameters() {
        GameParameterSingleton.ORIENTATION = GameParameterSingleton.PORTRAIT;
        GameParameterSingleton.SCREEN_HEIGHT = getWindowManager().getDefaultDisplay().getHeight();
        GameParameterSingleton.SCREEN_WIDTH = getWindowManager().getDefaultDisplay().getWidth();

        GameParameterSingleton.assetManager = getAssets();

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //retrato

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }


}
