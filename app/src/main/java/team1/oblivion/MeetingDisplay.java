package team1.oblivion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class MeetingDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_display);

        //retrieve intent data from homeFragments
        Intent i = getIntent();

        Gson gson = new Gson();

        // getting views
        TextView titleTv = findViewById(R.id.titlefromlistviewvalue);
        TextView dateTv = findViewById(R.id.dateTextViewValue);
        TextView timeTv = findViewById(R.id.timeViewValue);
        TextView presidingTv = findViewById(R.id.presidingViewValue);
        TextView conductingTv = findViewById(R.id.conductingViewValue);
        TextView openHymnTv = findViewById(R.id.openingHymnViewValue);
        TextView invocationTv = findViewById(R.id.invocationViewValue);
        TextView wardBusinessTv = findViewById(R.id.wardBusinessViewValue);
        TextView sacreHymnTv = findViewById(R.id.sacreHymnViewValue);
        TextView firstSpeakerTv = findViewById(R.id.firstSpeakerViewValue);
        TextView secondSpeakerTv = findViewById(R.id.secondSpeakerViewValue);
        TextView specialHymnTv = findViewById(R.id.specialHymnViewValue);
        TextView thirdSpeakerTv = findViewById(R.id.thirdSpeakerViewValue);
        TextView closingHymnTv = findViewById(R.id.closingHymnViewValue);
        TextView benedictionTv = findViewById(R.id.benedictionViewValue);
        TextView attendanceTv = findViewById(R.id.attendanceViewValue);
        TextView notesTv = findViewById(R.id.notesViewValue);

        //retrieve meeting taped from listView in homeFragment
        String data = i.getStringExtra("mtg");

        //getting the Json data
        Meeting m = gson.fromJson(data,Meeting.class);

        // assign values to each corresponding view
        titleTv.setText(m.getDateTimeNames().getTitle());
        dateTv.setText(m.getDateTimeNames().getDate());
        timeTv.setText(m.getDateTimeNames().getTime());
        presidingTv.setText(m.getConductors().getPresiding());
        conductingTv.setText(m.getConductors().getConducting());
        openHymnTv.setText(m.getHymns().getOpeningHymn());
        invocationTv.setText(m.getPrayers().getfirstPrayer());
        wardBusinessTv.setText(m.getNotes().getWardBusiness());
        sacreHymnTv.setText(m.getHymns().getSacramentHymn());
        firstSpeakerTv.setText(m.getSpeakers().getFirstSpeaker());
        secondSpeakerTv.setText(m.getSpeakers().getSecondSpeaker());
        specialHymnTv.setText(m.getHymns().getSpecialHymn());
        thirdSpeakerTv.setText(m.getSpeakers().getThirdSpeaker());
        closingHymnTv.setText(m.getHymns().getClosingHymn());
        benedictionTv.setText(m.getPrayers().getsecondPrayer());
        attendanceTv.setText(m.getNotes().getAttendance());
        notesTv.setText(m.getNotes().getNotes());

    }

}
