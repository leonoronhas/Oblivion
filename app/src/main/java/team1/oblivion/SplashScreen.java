package team1.oblivion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    // 3 seconds delay
                    sleep(3000);
                    // Send it to Main Activity
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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
