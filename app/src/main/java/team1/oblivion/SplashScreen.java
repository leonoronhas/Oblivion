package team1.oblivion;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        //int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        //decorView.setSystemUiVisibility(uiOptions);
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
       ActionBar actionBar = getSupportActionBar();
       actionBar.hide();

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    // 2 seconds delay
                    sleep(2000);
                    // Send it to Login Activity
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class); // redirected to login activity next
                    startActivity(intent);

                    // Destroy activity when done
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        // Start when done
        thread.start();
    }
}
