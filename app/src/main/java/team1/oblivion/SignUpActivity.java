package team1.oblivion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    // Input fields
    EditText emailEditText;
    EditText passwordEditText;
    EditText confPassword;
    Intent intent;

    //authentication FireBase
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

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

        //Get a reference to the Firebase auth object
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        //Get inputs from the view
        emailEditText = findViewById(R.id.emailInputEditText);
        passwordEditText = findViewById(R.id.editTextPassword);
        confPassword = findViewById(R.id.editTextConfirmPass);
        Button button = findViewById(R.id.buttonDone);

        // When the create user button is clicked
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), MainActivity.class);

                createUserAccount();
            }
        });
    }

    // Create account
    private void createUserAccount() {
        if (!checkFormFields())
            return;

        // Convert to strings
        final String emailString = emailEditText.getText().toString();
        String passwordString = passwordEditText.getText().toString();

        //Create the user account
        mAuth.createUserWithEmailAndPassword(emailString, passwordString).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast toast = Toast.makeText(getApplicationContext(),"Account created Successfully", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 500);
                    toast.show();
                    startActivity(intent);
                }
                // Handle same email address case
                else if(currentUser.getEmail().equals(emailString)){
                    Toast toast = Toast.makeText(getApplicationContext(),"Email already in use", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 500);
                    toast.show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Account creation failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Check user input
    private boolean checkFormFields() {

        // Convert it to string
        String emailString    = emailEditText.getText().toString();
        String passString     = passwordEditText.getText().toString();
        String confPassString = confPassword.getText().toString();
        int passwordSize = 6;

        // Check input fields for required information
        if (emailString.isEmpty()) {
            emailEditText.setError("Email Required");
            return false;
        }
        if (passString.isEmpty()) {
            passwordEditText.setError("Password Required");
            return false;
        }
        if (passString.length() < passwordSize)
            passwordEditText.setError("Password must have 6 characters or more");
        if (confPassString.isEmpty()) {
            confPassword.setError("Confirm Password Required");
            return false;
        }
        if (!passString.equals(confPassString)) {
            confPassword.setError("Password must match");
            return false;
        }

        // Check if password and conf password match
        return true;
    }


}
