package com.myhostel;
        import android.content.Intent;
        import android.os.Bundle;
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

        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;

public class FacultyWardenRegisterForm extends AppCompatActivity {

    EditText ed1;
    EditText ed2;
    RadioGroup mGender;
    RadioButton mGenderOption;
    //DatePicker dp1;
    DatabaseReference databaseDetails;
    String gender;
    private Button b7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_warden_register_form);
        Spinner mySpinner=(Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter= new ArrayAdapter<String>(FacultyWardenRegisterForm.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        b7=(Button)findViewById(R.id.Hbtn6);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent h=new Intent(FacultyWardenRegisterForm.this,FacultyWardenRegister.class);
                startActivity(h);
            }
        });
        databaseDetails = FirebaseDatabase.getInstance().getReference("facultydetails");
        ed1 = (EditText) findViewById(R.id.A);
        ed2 = (EditText) findViewById(R.id.B);
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
                Intent c=new Intent(FacultyWardenRegisterForm.this,FacultyWardenRegister.class);
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

            FacultyWardenRegDetails facultydetails = new FacultyWardenRegDetails(name,pass,gender);

            databaseDetails.child(id).setValue(facultydetails);


            Toast.makeText(this,"Details added",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"Enter a name",Toast.LENGTH_LONG).show();
        }
    }
}
