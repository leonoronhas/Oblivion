package team1.oblivion;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private View rootView;
//    FirebaseDatabase database = FirebaseDatabase.getInstance();

//    final DatabaseReference meeting_user = database.getReference("Meetings");

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        FloatingActionButton fab = rootView.findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), NewMeetingActivity.class);
                startActivity(intent);
            }
        });

//        meeting_user.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot ds : dataSnapshot.getChildren()) {
//                    String title = ds.child("DateTimeTitle").child("title").getValue().toString();
//                    String date = ds.child("DateTimeTitle").child("date").getValue().toString();
//                    String time = ds.child("DateTimeTitle").child("time").getValue().toString();
//                }
//            }

//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {

//            }
//        });

        return rootView;
    }
}
