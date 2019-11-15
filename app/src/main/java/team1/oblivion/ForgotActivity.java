package team1.oblivion;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotActivity extends AppCompatActivity {

    private EditText emailInput;
     String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //get input from the user
        emailInput = findViewById(R.id.editTextRecover);

        // making the button work
         Button buttonRecover = findViewById(R.id.buttonRecover);


    }

    //display message onclick button
    public void onClick(View view){

         text = emailInput.getText().toString();

        if (!text.isEmpty()) {

            // Toast message as reminder
            Toast toast = Toast.makeText(this, "Email sent!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, -850);
            toast.show();
        }
        else
            displayMessage();
    }

    public void displayMessage(){

        // convert the  information to a string

         text = emailInput.getText().toString();

        if (text.isEmpty()) {

            // Toast message as reminder
            Toast toast = Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, -852);
            toast.show();

        }


    }
}
