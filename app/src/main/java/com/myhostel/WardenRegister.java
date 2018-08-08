package com.myhostel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WardenRegister extends AppCompatActivity implements View.OnClickListener {
    private Button b3;
    private Button b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warden_login);
        b3 = (Button) findViewById(R.id.Hbtn3);
	b3.setOnClickListener(new View.OnClickListener() {
		@Override
            public void onClick(View view) {
                Intent i=new Intent(WardenRegister.this,Warden.class);
                startActivity(i);
            }
    });
	b4 = (Button) findViewById(R.id.Hbtn4);
	b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent f=new Intent(WardenRegister.this,WardenRegisterForm.class);
                startActivity(f);
            }
        });

    }
}
