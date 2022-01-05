package com.example.DONATION_APP.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.DONATION_APP.ForSignOrLogIn;
import com.example.DONATION_APP.R;
import com.example.DONATION_APP.UserProfile.UserProfile;

public class ThankYou extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(this, UserProfile.class);
        startActivity(i);
    }
}