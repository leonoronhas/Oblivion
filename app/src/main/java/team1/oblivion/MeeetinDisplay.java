package team1.oblivion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStream;

public class MeeetinDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeetin_display);

        Intent i = getIntent();

        Gson gson = new Gson();

        TextView titleTv = findViewById(R.id.titlefromlistviewvalue);
        TextView dateTv = findViewById(R.id.dateTextViewValue);
        TextView timeTv = findViewById(R.id.timeViewValue);
        TextView presidingTv = findViewById(R.id.presidintViewValue);


        String data = i.getStringExtra("mtg");
        Meeting m = gson.fromJson(data,Meeting.class);
        titleTv.setText(m.getDateTimeNames().getTitle());
        dateTv.setText(m.getDateTimeNames().getDate());
        timeTv.setText(m.getDateTimeNames().getTime());
        presidingTv.setText(m.getConductors().getPresiding());



    }

}
