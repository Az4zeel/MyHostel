package com.myhostel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class StudentDetails extends AppCompatActivity {
    private Button b1;
    private Button b2;
    public Spinner mySpinner3;
    public Spinner mySpinner4;
    private EditText room;
    private EditText rollno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        b1=(Button)findViewById(R.id.viewdetails);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(StudentDetails.this,ViewStudentDetails.class);
                a.putExtra("deptvalues",mySpinner3.getSelectedItem().toString());
                a.putExtra("yearvalues",mySpinner4.getSelectedItem().toString());
                a.putExtra("roomvalues",room.getText().toString());
                a.putExtra("rollnovalues",rollno.getText().toString());
                startActivity(a);
                finish();
            }
        });
        b2=(Button)findViewById(R.id.adddetails);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(StudentDetails.this,AddStudentDetails.class);
                startActivity(a);
                finish();
            }
        });
        mySpinner3=(Spinner)findViewById(R.id.spinner3);
        ArrayAdapter<String> myAdapter= new ArrayAdapter<String>(StudentDetails.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner3.setAdapter(myAdapter);
        mySpinner4=(Spinner)findViewById(R.id.spinner4);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(StudentDetails.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.years));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner4.setAdapter(adapter);
        room = (EditText) findViewById(R.id.ed5);
        rollno = (EditText) findViewById(R.id.ed6);
    }
}
