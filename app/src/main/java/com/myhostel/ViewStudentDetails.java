package com.myhostel;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewStudentDetails extends AppCompatActivity {
    ListView listViewStudents;
    List<Student> studentList;
    DatabaseReference databaseDetails;
    String c, d, e, f;
    //Boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student_details);
        listViewStudents = (ListView) findViewById(R.id.listViewStudents);
        studentList = new ArrayList<>();
        databaseDetails = FirebaseDatabase.getInstance().getReference().child("studentdetails");
        Intent a = getIntent();
        Bundle b = a.getExtras();
        c = b.getString("deptvalues");
        d = b.getString("yearvalues");
        e = b.getString("roomvalues");
        f = b.getString("rollnovalues");

    }

    @Override
    protected void onStart() {
        super.onStart();
        //databaseDetails.orderByChild("dept").equalTo("IT").addValueEventListener(new ValueEventListener() {
        databaseDetails.orderByChild("dept").equalTo(c).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                studentList.clear();

                for (DataSnapshot studentSnapshot : dataSnapshot.getChildren()) {
                    Student student = studentSnapshot.getValue(Student.class);

                    studentList.add(student);

                }

                StudentList adapter = new StudentList(ViewStudentDetails.this, studentList);
                listViewStudents.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });
         databaseDetails.orderByChild("year").equalTo(d).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot studentSnapshot : dataSnapshot.getChildren()) {
                        Student student = studentSnapshot.getValue(Student.class);

                        studentList.add(student);
                    }

                    StudentList adapter = new StudentList(ViewStudentDetails.this, studentList);
                    listViewStudents.setAdapter(adapter);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        databaseDetails.orderByChild("room").equalTo(e).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot studentSnapshot : dataSnapshot.getChildren()) {
                    Student student = studentSnapshot.getValue(Student.class);

                    studentList.add(student);
                }

                StudentList adapter = new StudentList(ViewStudentDetails.this, studentList);
                listViewStudents.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        databaseDetails.orderByChild("rollno").equalTo(f).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot studentSnapshot : dataSnapshot.getChildren()) {
                    Student student = studentSnapshot.getValue(Student.class);

                    studentList.add(student);
                }

                StudentList adapter = new StudentList(ViewStudentDetails.this, studentList);
                listViewStudents.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
