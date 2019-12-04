package team1.oblivion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    Button forgotPass;
    Button signUp;
    Button signOut;
    Intent intent;
    private EditText username;
    private EditText password;
    private FirebaseAuth mAuth;

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

        //Get a reference to the Firebase auth object
        mAuth = FirebaseAuth.getInstance();

        // Assign inputs & buttons
        loginButton = findViewById(R.id.buttonLogin);
        forgotPass = findViewById(R.id.buttonForgotPassword);
        signUp = findViewById(R.id.buttonSignUp);
        password = findViewById(R.id.editTextPassword);
        username = findViewById(R.id.editTextLogin);

        // Login button call
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), MainActivity.class); // redirected to main activity next
                // Sign user
                signUserIn();
            }

        });

        // Sign Up button call
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class); // redirected to sign up activity next
                startActivity(intent);
            }
        });

        //forgot password
        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ForgotActivity.class); // redirected  to forgot activity
                startActivity(intent);
            }
        });

    }



    // Check user input
    private boolean checkFormFields() {
        String email, passwordString;

        email = username.getText().toString();
        passwordString = password.getText().toString();

        if (email.isEmpty()) {
            username.setError("Email Required");
            return false;
        }
        if (passwordString.isEmpty()) {
            password.setError("Password Required");
            return false;
        }
        // True if no issue was found
        return true;
    }

    // Login user
    private void signUserIn() {
        if (!checkFormFields())
            return;

        // Convert the inputs to strings
        final String email = username.getText().toString();
        String passwordString = password.getText().toString();

        // Firebase sign in
        mAuth.signInWithEmailAndPassword(email, passwordString).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Logged in", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 100);
                    toast.show();
                    startActivity(intent);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 100);
                    toast.show();
                }
            }
        });
    }
}



