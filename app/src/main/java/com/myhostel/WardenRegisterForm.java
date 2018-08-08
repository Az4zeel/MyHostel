package com.myhostel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WardenRegisterForm extends AppCompatActivity {

    EditText ed1;
    EditText ed2;
    Button butt;
    RadioGroup mGender;
    RadioButton mGenderOption;
    //DatePicker dp1;
    DatabaseReference databaseDetails;
    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warden_register_form);

        databaseDetails = FirebaseDatabase.getInstance().getReference("details");
        ed1 = (EditText) findViewById(R.id.A);
        ed2 = (EditText) findViewById(R.id.B);
        butt = (Button) findViewById(R.id.D);
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
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDetail();
                Intent c=new Intent(WardenRegisterForm.this,WardenRegister.class);
                startActivity(c);
                finish();

            }
        });
    }
    private void addDetail(){
        String name = ed1.getText().toString().trim();
        String pass = ed2.getText().toString().trim();

        if(!TextUtils.isEmpty(name)){
            String id = databaseDetails.push().getKey();

            WardenRegDetails details = new WardenRegDetails(name,pass,gender);

            databaseDetails.child(id).setValue(details);


            Toast.makeText(this,"Details added",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"Enter a name",Toast.LENGTH_LONG).show();
        }
    }
}
