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

public class SignUpActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    EditText confPassword;
    private String emailString;
    private String passString;
    private String confPassString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //Get inputs
        email = findViewById(R.id.emailInputEditText);
        password = findViewById(R.id.editTextPassword);
        confPassword = findViewById(R.id.editTextConfirmPass);
        Button button = findViewById(R.id.buttonDone);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                // Convert it to string
                emailString = email.getText().toString();
                passString = password.getText().toString();
                confPassString = confPassword.getText().toString();

                if(emailString.isEmpty() || passString.isEmpty() || confPassString.isEmpty()){
                    displayError();
                }
                else if(!passString.equals(confPassString)) {
                    displayError();
                }
                else {
                    startActivity(intent);
                }
            }
        });
    }

    private void displayError() {
        // Toast message for empty inputs
        Toast toast = Toast.makeText(this, "Please, enter your information correctly!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, -20);
        toast.show();
    }
}
