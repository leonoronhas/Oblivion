package team1.oblivion;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.common.base.MoreObjects;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.auth.User;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class NewMeetingActivity extends AppCompatActivity {

    // Firebase
    DatabaseReference databaseReference;

    // Create objects
    DateTimeName dateTimeName;
    Conductors conductors;
    Hymn hymns;
    Speakers speakers;
    Task tasks;
    Prayer prayers;
    Notes notes;
    String date;
    String timeTest;

    // Date and time pickers
    private TextView DisplayDate;
    private DatePickerDialog.OnDateSetListener DateSetListener;
    private TextView displayTime;
    private TimePickerDialog timePickerDialog;
    private int currentHour;
    private int currentMinute;
    private String amPm;

    // Inputs
    private EditText titleId;
    private EditText presidingId;
    private EditText conductingId;
    private EditText openingHymnId;
    private EditText sacramentHymnId;
    private EditText specialHymnId;
    private EditText closingHymnId;
    private EditText firstPrayerId;
    private EditText secondPrayerId;
    private EditText wardBusinessId;
    private EditText attendanceId;
    private EditText firstSpeakerId;
    private EditText secondSpeakerId;
    private EditText thirdSpeakerId;
    private EditText notesId;
    ImageButton saveButton;
    ImageButton cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_meeting);

        View decorView = getWindow().getDecorView();

        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // Get the inputs
        titleId = findViewById(R.id.editTextTitle);
        presidingId = findViewById(R.id.editTextPresiding);
        conductingId = findViewById(R.id.editTextConducting);
        openingHymnId = findViewById(R.id.editTextOpeningHymn);
        sacramentHymnId = findViewById(R.id.editTextSacramentHymn);
        specialHymnId = findViewById(R.id.editTextSpecialHymn);
        closingHymnId = findViewById(R.id.editTextClosingHymn);
        firstPrayerId = findViewById(R.id.editTextInvocation);
        secondPrayerId = findViewById(R.id.editTextBenediction);
        wardBusinessId = findViewById(R.id.editTextWardBusiness);
        notesId = findViewById(R.id.editTextNotes);
        attendanceId = findViewById(R.id.editTextAttendance);
        firstSpeakerId = findViewById(R.id.editTextFirstSpeaker);
        secondSpeakerId = findViewById(R.id.editTextSecondSpeaker);
        thirdSpeakerId = findViewById(R.id.editTextThirdSpeaker);
        saveButton = findViewById(R.id.imageButtonSaveTemplate);
        cancelButton = findViewById(R.id.imageButtonCancelTemplate);

        // Get the Firebase instance (Create parent)
        databaseReference = FirebaseDatabase.getInstance().getReference("newMeeting");

         /******************************************************************************************
         *  Android Date picker - Specific to android
         *  This will get the date in a calendar dialog
         *******************************************************************************************/
        DisplayDate = findViewById(R.id.selectDate);
        DisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(NewMeetingActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog, DateSetListener, year, month, day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(50, 25, 87))); // primary color
                dialog.show();
            }
        });
        DateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                date = month + "/" + day + "/" + year;
                DisplayDate.setText(date);
            }
        };

         /******************************************************************************************
         *  Android Time picker - Specific to android
         *  This will choose the time
         *******************************************************************************************/
        displayTime = findViewById(R.id.selectTime);
        displayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(NewMeetingActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if (hourOfDay >= 12) {
                            amPm = "PM";
                            hourOfDay -= 12;
                        } else {
                            amPm = "AM";
                        }
                        String time = hourOfDay + ":" + minute + " " + amPm;
                        timeTest = time;
                        displayTime.setText(time);
                    }
                }, currentHour, currentMinute, false);
                timePickerDialog.show();
            }
        });


        // Button call inside onCreate()
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveMeeting();
            }
        });
    }

    // Saving the meeting  on Firebase
    public void saveMeeting() {

        String id = databaseReference.push().getKey();

        // Convert inputs to strings
        String titleStr = titleId.getText().toString().trim();
        String presidingStr = presidingId.getText().toString().trim();
        String conductingStr = conductingId.getText().toString().trim();
        String openingHymnStr = openingHymnId.getText().toString().trim();
        String sacramentHymnStr = sacramentHymnId.getText().toString().trim();
        String specialHymnStr = specialHymnId.getText().toString().trim();
        String closingHymnStr = closingHymnId.getText().toString().trim();
        String firstPrayerStr = firstPrayerId.getText().toString().trim();
        String secondPrayerStr = secondPrayerId.getText().toString().trim();
        String wardBusinessStr = wardBusinessId.getText().toString().trim();
        String attendanceStr = attendanceId.getText().toString().trim();
        String firstSpeakerStr = firstSpeakerId.getText().toString().trim();
        String secondSpeakerStr = secondSpeakerId.getText().toString().trim();
        String thirdSpeakerStr = thirdSpeakerId.getText().toString().trim();
        String notesStr = notesId.getText().toString().trim();
        String dateStr = date;
        String timeStr = timeTest;

        // Assign each string to its class
        conductors = new Conductors(presidingStr, conductingStr);
        hymns = new Hymn(openingHymnStr, sacramentHymnStr, specialHymnStr, closingHymnStr);
        speakers = new Speakers(firstSpeakerStr, secondSpeakerStr, thirdSpeakerStr);
        prayers = new Prayer(firstPrayerStr, secondPrayerStr);
        notes = new Notes(notesStr, wardBusinessStr);
        dateTimeName = new DateTimeName(titleStr, timeStr, dateStr);

        // Send it to database under "newMeeting"
        databaseReference.child("DateTimeTitle").setValue(dateTimeName);
        databaseReference.child("Conductors").setValue(conductors);
        databaseReference.child("Hymns").setValue(hymns);
        databaseReference.child("Speakers").setValue(speakers);
        databaseReference.child("Prayer").setValue(prayers);
        databaseReference.child("Notes").setValue(notes);
        databaseReference.child("Attendance").setValue(attendanceStr);

        // Display if created successfully
        Toast.makeText(this,"New Meeting Saved Successfully",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}

