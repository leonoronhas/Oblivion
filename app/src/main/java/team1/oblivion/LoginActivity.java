package team1.oblivion;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private String checkUser;  //username
    private String checkPass;  //password
    private EditText username;
    private EditText password;
    private boolean checkInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // Assign inputs & buttons
        Button loginButton = findViewById(R.id.buttonLogin);
        password = findViewById(R.id.editTextLogin);
        username = findViewById(R.id.editTextPassword);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class); // redirected to main activity next

                // Convert to string
                checkUser = username.getText().toString();
                checkPass = password.getText().toString();

                if (checkUser.isEmpty() && checkPass.isEmpty()) {
                    checkInput = false;
                } else
                    checkInput = true;

                if (checkInput) {
                    startActivity(intent);
                }
                else {
                    displayError();
                }
            }
        });
    }


    public void displayError() {
        // Toast message as reminder
        Toast toast = Toast.makeText(this, "Incorrect Username or Password!", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, -600);
        toast.show();
    }
}



