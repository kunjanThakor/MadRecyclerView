package com.mca.recyclertwo;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowData extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EmployeeAdapter employeeAdapter;
    private List<EmployeeInfo> employeeList;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.idRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the employee list and adapter
        employeeList = new ArrayList<>();
        employeeAdapter = new EmployeeAdapter(employeeList);
        recyclerView.setAdapter(employeeAdapter);

        // Firebase Database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("EmployeeInfo");

        // Retrieve data from Firebase
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                employeeList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    EmployeeInfo employee = dataSnapshot.getValue(EmployeeInfo.class);
                    employeeList.add(employee);
                }
                employeeAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ShowData.this, "Failed to retrieve data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
