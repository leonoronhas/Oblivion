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
    private String TAG = "FA_SIGNIN";
    private EditText username;
    private EditText password;

    //authentication FireBase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

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
        loginButton = findViewById(R.id.buttonLogin);
        forgotPass = findViewById(R.id.buttonForgotPassword);
        signUp = findViewById(R.id.buttonSignUp);
        password = findViewById(R.id.editTextLogin);
        username = findViewById(R.id.editTextPassword);


        //Get a reference to the Firebase auth object
        mAuth = FirebaseAuth.getInstance();


        //Attach a new AuthListener to detect sig in and out
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Log.d(TAG, "Signed in: " + user.getUid());
                } else {
                    Log.d(TAG, "Currently Signed out");
                }
            }
        };

        updateStatus();


        // Login button algorithm
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class); // redirected to main activity next

                signUserIn();

                startActivity(intent);

            }

        });

        // Sign Up button algorithm
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class); // redirected to main activity next
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

    @Override
    protected void onStart() {
        super.onStart();

        //add the Auth Listener
        mAuth.addAuthStateListener(mAuthListener);

    }

    @Override
    protected void onStop() {
        super.onStop();


        //Remove the AuthListener
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);

        }


    }

    private void updateStatus() {
        TextView tvStat = findViewById(R.id.tvSignInStatus);
        //get the current user
        FirebaseUser user = mAuth.getCurrentUser();

        if (user != null) {
            tvStat.setText(("Signed in: " + user.getEmail()));
        }
//        else
//            tvStat.setText(("Signed Out"));

    }


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

        return true;
    }

    private void signUserOut() {

        // sign the user out

        mAuth.signOut();
        updateStatus();
    }

    private void createUserAccount() {
        if (!checkFormFields())
            return;

        String email = username.getText().toString();
        String passwordString = password.getText().toString();


        //Create the user account
        mAuth.createUserWithEmailAndPassword(email, passwordString).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "User was created", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Account created failed", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void signUserIn() {
        if (!checkFormFields())
            return;

        String email = username.getText().toString();
        String passwordString = password.getText().toString();

        // TODO: sign the user in with email and password credentials
        mAuth.signInWithEmailAndPassword(email, passwordString).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Signed in", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
                updateStatus();
            }


        });


    }


    // Forgot Password
}



