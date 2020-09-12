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

public class LoginActivity extends AppCompatActivity {

    EditText emailId,password;
    Button BtnLogIn;
    TextView tvSignUp;
    ProgressBar progressBar;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.EmailId);
        password = findViewById(R.id.pwd);
        BtnLogIn = findViewById(R.id.btnLogIn);
        tvSignUp = findViewById(R.id.tvSignUp);

        progressBar = findViewById(R.id.progressBar);


        BtnLogIn.setOnClickListener(new View.OnClickListener() {
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

                //Authenticate user

                mFirebaseAuth.signInWithEmailAndPassword(email,passwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this,"Logged in successfully.",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else{
                            Toast.makeText(LoginActivity.this,"Error!"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }

                    }
                });
            }
        });


        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intSignUp = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intSignUp);
            }
        });
    }
}
