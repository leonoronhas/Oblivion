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
        TextView dateTv = findViewById(R.id.datefromlistviewvalue);


        String data = i.getStringExtra("mtg");
        Meeting m = gson.fromJson(data,Meeting.class);
        titleTv.setText(m.getDateTimeNames().getTitle());



    }
//    public String loadJson(){
//        String json = null;
//        try {
//            InputStream loadJson = getAssets().open("mtg");
//            int size = loadJson.available();
//            byte[] buffer = new byte[size];
//            loadJson.read(buffer);
//            loadJson.close();
//            json = new String(buffer,"UTF-8");
//        }
//        catch (IOException ex){
//        }
//        return json;
//    }
}
