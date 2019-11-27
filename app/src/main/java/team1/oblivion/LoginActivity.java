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

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    Button forgotPass;
    Button signUp;
    Button signOut;
    private String TAG = "FA_SIGNIN";
    private EditText username;
    private EditText password;

    //Authentication FireBase
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

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
        currentUser = mAuth.getCurrentUser();

        // Assign inputs & buttons
        loginButton = findViewById(R.id.buttonLogin);
        forgotPass = findViewById(R.id.buttonForgotPassword);
        signUp = findViewById(R.id.buttonSignUp);
        password = findViewById(R.id.editTextLogin);
        username = findViewById(R.id.editTextPassword);
        signOut = findViewById(R.id.signOutButton);

        // Login button call
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class); // redirected to main activity next
                // Sign user
                signUserIn();

                startActivity(intent);
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

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
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
        String email = username.getText().toString();
        String passwordString = password.getText().toString();

        // Check user input
        checkFormFields();

        // Firebase sign in
        mAuth.signInWithEmailAndPassword(email, passwordString).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                    currentUser = mAuth.getCurrentUser();
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
                }
            }


        });
    }
}



