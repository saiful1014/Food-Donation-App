package com.example.DONATION_APP;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.DONATION_APP.volunteer.SignForV;

// MAIN PAGE


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button donate,volunteer;
    private ImageView donateImg,VolImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTitle("YOU ARE WELCOME");
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        donate=findViewById(R.id.donerId);
        donateImg=findViewById(R.id.DonerImg);

        volunteer=findViewById(R.id.volunteerId);
        VolImage=findViewById(R.id.volunteerImg);

        donate.setOnClickListener(this);
        donateImg.setOnClickListener(this);
        volunteer.setOnClickListener(this);
        VolImage.setOnClickListener(this);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            this.finish();
        }

        if(item.getItemId()==R.id.aboutUsId)
        {
          Intent intent=new Intent(this,ForAboutUs.class);
          startActivity(intent);
        }

      else if(item.getItemId()==R.id.feedbackId)
        {
            Intent intent=new Intent(this,ForFeedback.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(@NonNull View v) {

        if(v.getId()==R.id.donerId||v.getId()==R.id.DonerImg)
        {
            Intent intent=new Intent(this,ForSignOrLogIn.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.volunteerId||v.getId()==R.id.volunteerImg)
        {

            Intent intent=new Intent(this, SignForV.class);
            startActivity(intent);
        }
    }
}