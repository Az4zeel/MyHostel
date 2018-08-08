package com.myhostel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FacultyWardenRegister extends AppCompatActivity {
    private Button b6;
    private Button b8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_warden_login);
        b8=(Button)findViewById(R.id.Hbtn8);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(FacultyWardenRegister.this,Warden.class);
                startActivity(i);
            }
        });
        b6=(Button)findViewById(R.id.Hbtn7);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent f=new Intent(FacultyWardenRegister.this,FacultyWardenRegisterForm.class);
                startActivity(f);
            }
        });

    }
}