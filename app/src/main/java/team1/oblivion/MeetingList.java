package team1.oblivion;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

class MeetingList {

    HomeFragment homeFragment;

    //connecting to a Firebase and getting root data "meetings"
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference("Meetings");

    private List<Meeting> meetingList;


    public MeetingList(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
    }

    public List<Meeting> getMeetingList() {
        return meetingList;
    }

    public void setMeetingList(List<Meeting> meetingList) {
        this.meetingList = meetingList;
    }

    // retrieve meeting for firebase
    List<Meeting> loadData() {
        // when I run this addValue....  This will create " a thread "
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    meetingList = new ArrayList<Meeting>();
                    for (DataSnapshot child : dataSnapshot.getChildren()) {

                        Meeting meeting = child.getValue(Meeting.class);

                        //Add new meeting in to a list meetings
                        meetingList.add(meeting);
                        homeFragment.dataReady();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return meetingList;
    }
}
