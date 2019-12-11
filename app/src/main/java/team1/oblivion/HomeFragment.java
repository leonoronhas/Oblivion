package team1.oblivion;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.lang.reflect.Method;

public class HomeFragment extends Fragment {

    private View rootView;
    private MainActivity mainActivity;
    private MeetingList meetingList;
    ListView listView;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        FloatingActionButton fab = rootView.findViewById(R.id.floatingActionButton);
        listView = rootView.findViewById(R.id.listViewField);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), NewMeetingActivity.class);
                startActivity(intent);
            }
        });

        //in this case " this " will be the homeFragment itself
        meetingList = new MeetingList(this);
        meetingList.loadData();

        //dataReady();

        return rootView;
    }

    public void dataReady(){
        ArrayAdapter<Meeting> adapter = new ArrayAdapter<Meeting>(getActivity(), android.R.layout.simple_list_item_1, meetingList.getMeetingList());
        listView.setAdapter(adapter);

    }
}

