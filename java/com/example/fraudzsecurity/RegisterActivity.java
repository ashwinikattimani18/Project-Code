package com.example.fraudzsecurity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity {

    EditText firstName, lastName, DoB, MobileNo, emailId, password, confpassword;
    Button BtnSignUp;
    TextView tvLogIn;
    FirebaseAuth mFirebaseAuth;
    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebaseAuth = FirebaseAuth.getInstance();

        firstName = findViewById(R.id.Fname);
        lastName = findViewById(R.id.Lname);
        DoB = findViewById(R.id.DoB);
        MobileNo = findViewById(R.id.Mob);
        emailId = findViewById(R.id.EmailId);
        password = findViewById(R.id.pwd);
        confpassword = findViewById(R.id.confpwd);
        BtnSignUp = findViewById(R.id.btnSignUp);
        tvLogIn = findViewById(R.id.tvlogin);

        progressBar = findViewById(R.id.progressBar2);


        if(mFirebaseAuth.getCurrentUser() != null){

            startActivity(new Intent(getApplicationContext(),NavigationActivity.class));
            finish();
        }




        BtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailId.getText().toString().trim();
                String passwd = password.getText().toString().trim();

                if(TextUtils.isEmpty(email)){

                    emailId.setError("Email Address is required!");
                    return;
                }

                if(TextUtils.isEmpty(passwd)){
                  password.setError("Password is required!");
                  return;
                }

                if(passwd.length()<6){
                    password.setError("Password should be 6 characters or more!");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //Register the user in firebase

                mFirebaseAuth.createUserWithEmailAndPassword(email,passwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this,"User Created.",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else{
                            Toast.makeText(RegisterActivity.this,"Error!"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });




        tvLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
}







