package com.myhostel;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddStudentDetails extends AppCompatActivity {

    EditText ed1;
    EditText ed2;
    EditText ed3;
    EditText ed4;
    EditText ed5;
    RadioGroup mGender;
    RadioButton mGenderOption;
    Spinner mySpinner;
    Spinner mySpinner2;
    //DatePicker dp1;
    DatabaseReference databaseDetails;
    String gender;
    private Button b7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_details);
        mySpinner=(Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter= new ArrayAdapter<String>(AddStudentDetails.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        mySpinner2=(Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(AddStudentDetails.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.years));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(adapter);

        b7=(Button)findViewById(R.id.Hbtn6);
        databaseDetails = FirebaseDatabase.getInstance().getReference("studentdetails");
        ed1 = (EditText) findViewById(R.id.A);
        ed2 = (EditText) findViewById(R.id.B);
        ed3 = (EditText) findViewById(R.id.C);
        ed4 = (EditText) findViewById(R.id.E);
        ed5 = (EditText) findViewById(R.id.F);
        mGender = findViewById(R.id.rg_gender);
        mGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                mGenderOption = mGender.findViewById(i);
                switch (i){
                    case R.id.rb_male:
                        gender = mGenderOption.getText().toString();
                        break;
                    case R.id.rb_female:
                        gender = mGenderOption.getText().toString();
                        break;
                    default:

                }

            }
        });

        //dp1 = (DatePicker) findViewById(R.id.DP);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDetail();
                Intent c=new Intent(AddStudentDetails.this,StudentDetails.class);
                startActivity(c);
                finish();

            }
        });
    }
    private void addDetail(){
        String name = ed1.getText().toString().trim();
        String password = ed2.getText().toString().trim();
        String email = ed3.getText().toString().trim();
        String dept = mySpinner.getSelectedItem().toString();
        String year = mySpinner2.getSelectedItem().toString();
        String room = ed4.getText().toString().trim();
        String rollno = ed5.getText().toString().trim();


        if(!TextUtils.isEmpty(name)){
            String id = databaseDetails.push().getKey();

            Student studentdetails = new Student(name,password,gender,email,dept,year,room,rollno);

            databaseDetails.child(id).setValue(studentdetails);


            Toast.makeText(this,"Details added",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"Enter the details",Toast.LENGTH_LONG).show();
        }
    }
}
