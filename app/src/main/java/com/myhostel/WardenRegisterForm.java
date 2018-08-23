package com.myhostel;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WardenRegisterForm extends AppCompatActivity {

    EditText ed1;
    EditText ed2;
    EditText ed3;
    Button butt;
    RadioGroup mGender;
    RadioButton mGenderOption;
    //DatePicker dp1;
    DatabaseReference databaseDetails;
    String gender;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warden_register_form);
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null){
            //that means user is already logged in
            //so close this activity
            finish();

            //and open profile activity
            startActivity(new Intent(getApplicationContext(), Warden.class));
        }

        databaseDetails = FirebaseDatabase.getInstance().getReference("details");
        ed1 = (EditText) findViewById(R.id.A);
        ed2 = (EditText) findViewById(R.id.B);
        ed3 = (EditText) findViewById(R.id.nameid);
        butt = (Button) findViewById(R.id.D);
        progressDialog = new ProgressDialog(this);
        mGender = findViewById(R.id.rg_gender);
        mGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                mGenderOption = mGender.findViewById(i);
                switch (i) {
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
                registerUser();
                Intent c = new Intent(WardenRegisterForm.this, WardenRegister.class);
                startActivity(c);
                finish();

            }
        });
    }

    private void registerUser() {

        //getting email and password from edit texts
        String email = ed1.getText().toString().trim();
        String password = ed2.getText().toString().trim();

        //checking if email and passwords are empty
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }

        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();

        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()) {
                            finish();
                            startActivity(new Intent(getApplicationContext(), WardenRegister.class));
                        }
                        progressDialog.dismiss();
                    }
                });

    }

    private void addDetail() {
        String email = ed1.getText().toString().trim();
        String pass = ed2.getText().toString().trim();
        String name = ed3.getText().toString().trim();

        if (!TextUtils.isEmpty(email)) {
            String id = databaseDetails.push().getKey();

            WardenRegDetails details = new WardenRegDetails(email, pass, gender,name);

            databaseDetails.child(id).setValue(details);


            Toast.makeText(this, "Details added", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Enter a name", Toast.LENGTH_LONG).show();
        }
    }

    public void onClick(View view) {
        if (view == butt) {
            registerUser();
        }
    }
}
