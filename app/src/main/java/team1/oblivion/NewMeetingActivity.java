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

    private final static String TAG = "NewMeetingActivity";
    ImageButton saveButton;
    ImageButton cancelButton;
    DatabaseReference databaseReference;
    DateTimeName dateTimeName;
    Conductors conductors;
    Hymn hymn;
    Task task;
    Notes notes;
    private TextView DisplayDate;
    private DatePickerDialog.OnDateSetListener DateSetListener;
    private TextView displayTime;
    private TimePickerDialog timePickerDialog;
    private int currentHour;
    private int currentMinute;
    private String amPm;
    private EditText titleId;
    private EditText presidingId;
    private EditText conductingId;
    private EditText openingHymnId;
    private EditText sacramentHymnId;
    private EditText specialHymnId;
    private EditText closingHymnId;
    private EditText firstPrayerId;
    private EditText secondPrayerId;
    //    private EditText specialPrayerId;
    private EditText wardBusinessId;
    private EditText notesId;
    private EditText attendanceId;
    private EditText firstSpeakerId;
    private EditText secondSpeakerId;
    private EditText thirdSpeakerId;
    private ArrayAdapter<CharSequence> typeAdapter;
    private Spinner typeId;

    ProgressDialog progressDialog;

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
//        specialPrayerId = findViewById(R.id.editTextSpecialPrayerId);
        wardBusinessId = findViewById(R.id.editTextWardBusiness);
        notesId = findViewById(R.id.editTextNotes);
        attendanceId = findViewById(R.id.editTextAttendance);
        firstSpeakerId = findViewById(R.id.editTextFirstSpeaker);
        secondSpeakerId = findViewById(R.id.editTextSecondSpeaker);
        thirdSpeakerId = findViewById(R.id.editTextThirdSpeaker);
        saveButton = findViewById(R.id.imageButtonSaveTemplate);
        cancelButton = findViewById(R.id.imageButtonCancelTemplate);

        databaseReference = FirebaseDatabase.getInstance().getReference("newMeeting");



        // trying to dismiss window after meeting is saved
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Saving...");

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveMeeting();
            }
        });

        // WE DON'T KNOW WHY IT DOESN'T WORK
//        typeAdapter = ArrayAdapter.createFromResource(this,
//                R.array.meeting_type, android.R.layout.simple_spinner_item);
//        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        typeId.setAdapter(typeAdapter);


        /********************************************************************************************/


        // This will get the date in a calendar dialog
        DisplayDate = findViewById(R.id.selectDate);
        DisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(NewMeetingActivity.this, android.R.style.Theme_Holo_Light_Dialog, DateSetListener, year, month, day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(50, 25, 87)));
                dialog.show();
            }
        });
        DateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                String date = month + "/" + day + "/" + year;
                DisplayDate.setText(date);
            }
        };

        /********************************************************************************************/

        // This will choose the time

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

                        displayTime.setText(hourOfDay + ":" + minute + " " + amPm);
                    }
                }, currentHour, currentMinute, false);
                timePickerDialog.show();

            }
        });

        /*************************************************************************************************/


        // Button call
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveMeeting();
            }
        });


    }

    // saving the meeting  on firebase
    public void saveMeeting() {

        String id = databaseReference.push().getKey();
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
        String notesStr = notesId.getText().toString().trim();
        String attendanceStr = attendanceId.getText().toString().trim();
        String firstSpeakerStr = firstSpeakerId.getText().toString().trim();
        String secondSpeakerStr = secondSpeakerId.getText().toString().trim();
        String thirdSpeakerStr = thirdSpeakerId.getText().toString().trim();

        progressDialog.show();

        Conductors conductors = new Conductors(presidingStr, conductingStr);
        Hymn hymns = new Hymn(openingHymnStr, sacramentHymnStr, specialHymnStr, closingHymnStr);
        Speakers speakers = new Speakers(firstSpeakerStr, secondSpeakerStr, thirdSpeakerStr);
        Prayer prayer = new Prayer(firstPrayerStr, secondPrayerStr);
        Notes notes = new Notes(notesStr, wardBusinessStr);

        databaseReference.child("Title").setValue(titleStr);
        databaseReference.child("Conductors").setValue(conductors);
        databaseReference.child("Hymns").setValue(hymns);
        databaseReference.child("Speakers").setValue(speakers);
        databaseReference.child("Prayer").setValue(prayer);
        databaseReference.child("Notes").setValue(notes);

        progressDialog.dismiss();
        Toast.makeText(this,"New Meeting Saved Successfully",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);

    }


}

