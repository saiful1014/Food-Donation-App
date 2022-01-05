package com.example.DONATION_APP.UserProfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.DONATION_APP.R;

public class profile extends AppCompatActivity {
    private TextView a,b,c,d,e,p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        a=findViewById(R.id.t1);
        b=findViewById(R.id.t2);
        c=findViewById(R.id.t3);
        d=findViewById(R.id.t4);
        e=findViewById(R.id.t5);
        p=findViewById(R.id.t);
        Showall();

    }

    private void Showall() {
        Intent i=getIntent();
        String aa= i.getStringExtra("firstname");
        String bb= i.getStringExtra("lastname");
        String cc= i.getStringExtra("email");
        String dd= i.getStringExtra("phone");
        String ee= i.getStringExtra("pass");
        p.setText("HI "+aa+" "+bb);
        a.setText("First Name:"+aa);
        b.setText("Last Name:"+bb);
        c.setText("Email:"+cc);
        d.setText("Phone Number:"+dd);
        e.setText("Password:"+ee);
    }
}