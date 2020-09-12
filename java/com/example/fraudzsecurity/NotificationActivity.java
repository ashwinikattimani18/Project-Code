package com.example.fraudzsecurity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NotificationActivity extends AppCompatActivity {

    Button btnyes,btnno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        btnyes = findViewById(R.id.btn_yes);
        btnno = findViewById(R.id.btn_no);

        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NotificationActivity.this,NavigationActivity.class);
                startActivity(i);
                Toast.makeText(NotificationActivity.this,"Okay!",Toast.LENGTH_SHORT).show();
            }
        });

        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NotificationActivity.this,"Transaction Unsuccessful!",Toast.LENGTH_SHORT).show();
            }
        });



        getSupportActionBar().setTitle("Notifications");
    }
}