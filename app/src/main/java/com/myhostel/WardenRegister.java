package com.myhostel;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class WardenRegister extends AppCompatActivity implements View.OnClickListener {
    private EditText e1;
    private EditText e2;
    private Button b3;
    private Button b4;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warden_login);
        firebaseAuth = FirebaseAuth.getInstance();


        if (firebaseAuth.getCurrentUser() != null) {
            finish();

            startActivity(new Intent(getApplicationContext(), Warden.class));
        }
        e1 = (EditText) findViewById(R.id.A);
        e2 = (EditText) findViewById(R.id.B);
        progressDialog = new ProgressDialog(this);
        b4 = (Button) findViewById(R.id.Hbtn4);

        b3 = (Button) findViewById(R.id.Hbtn3);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }

    private void registerUser() {
        String email = e1.getText().toString().trim();
        String password = e2.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        progressDialog.setMessage("Logging you in, please wait...");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        //checking if success
                        if(task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(), Warden.class));
                        }

                    }
                });

    }
    public void onClick(View view) {
        if(view == b3){
            registerUser();
        }

        if(view == b4){
            //open login activity when user taps on the already registered textview
            startActivity(new Intent(this, WardenRegisterForm.class));
        }
    }
}
