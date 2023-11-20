package com.example.firebaseex2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.firebaseex2.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   private ActivityMainBinding activityMainBinding;
   private RecyclerView recyclerView;
   private CricketAdapter cricketAdapter;
   ArrayList<CricketModel> cricketModelArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference= firebaseDatabase.getReference("Cricket");
        recyclerView=activityMainBinding.recyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    CricketModel cricketModel=dataSnapshot.getValue(CricketModel.class);
                    cricketModelArrayList.add(cricketModel);
                }
                cricketAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "DATA IS EMPTY", Toast.LENGTH_SHORT).show();

            }
        });
        cricketModelArrayList=new ArrayList<>();
        cricketAdapter=new CricketAdapter(cricketModelArrayList,this);
        recyclerView.setAdapter(cricketAdapter);


    }
}