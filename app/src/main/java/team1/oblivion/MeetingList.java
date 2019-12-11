package team1.oblivion;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class MeetingList {

    HomeFragment homeFragment;

    public MeetingList(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
    }

    public List<Meeting> getMeetingList() {
        return meetingList;
    }

    public void setMeetingList(List<Meeting> meetingList) {
        this.meetingList = meetingList;
    }

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference("Meetings");
    private List<Meeting> meetingList;

    List<Meeting> loadData(){
        // when I run this addValue....  This will create " a thread "
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){

                    meetingList = new ArrayList<Meeting>();
                    for(DataSnapshot child : dataSnapshot.getChildren()){
                     //   System.out.println(child.getKey());


                        Meeting meeting = child.getValue(Meeting.class);

                         //I can not add something if I dont have data ( vector)
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
