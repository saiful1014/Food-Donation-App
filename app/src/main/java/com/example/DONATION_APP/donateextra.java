package com.example.DONATION_APP;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.DONATION_APP.UserProfile.UserProfile;
import com.example.DONATION_APP.UserProfile.profile;
import com.example.DONATION_APP.data.extraprofile;
import com.example.DONATION_APP.fragment.ThankYou;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class donateextra extends AppCompatActivity implements View.OnClickListener {
    private Button WhatFirstDate, WhatLastDate, WhatDonation, WhatYes, WhatNo;
    private TextView WhatFirstDateTxt, WhatLastDateTxt;
    private EditText DonationDesctiptionEdTxt, DontionTitleEdTxt;
    private int Flag;
    private DatePickerDialog datePickerDialog;
    private String identity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donateextra);
        WhatFirstDate = findViewById(R.id.firstDateToPicforWhatBtn);
        WhatFirstDateTxt = findViewById(R.id.firstDateToPicforWhatTxt);

        WhatLastDate = findViewById(R.id.lastDateToPicforWhatBtn);
        WhatLastDateTxt = findViewById(R.id.lastDateToPicforWhatTxt);

        WhatDonation = findViewById(R.id.DonateWhatBtn);

        WhatYes = findViewById(R.id.yesforWhatBtn);
        WhatNo = findViewById(R.id.noForWhatBtn);


        DonationDesctiptionEdTxt = findViewById(R.id.commentforWhatEdTxt);

        DontionTitleEdTxt = findViewById(R.id.donationAmountforWhatEdTxt);


        WhatFirstDate.setOnClickListener(this);
        WhatLastDate.setOnClickListener(this);
        WhatDonation.setOnClickListener(this);
        WhatYes.setOnClickListener(this);
        WhatNo.setOnClickListener(this);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.profile,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.mp)
        {
            Intent p=getIntent();
            Intent i=new Intent(this, profile.class);
            i.putExtra("firstname",p.getStringExtra("firstname"));
            i.putExtra("lastname",p.getStringExtra("lastname"));
            i.putExtra("email",p.getStringExtra("email"));
            i.putExtra("phone",p.getStringExtra("phone"));
            i.putExtra("pass",p.getStringExtra("pass"));

            startActivity(i);

        }
        else if(item.getItemId()==R.id.mlo)
        {

            this.finishAndRemoveTask();
            Intent i=new Intent(this,MainActivity.class);
            startActivity(i);
        }
        else if(item.getItemId()==R.id.md)
        {
            Intent i=new Intent(this, UserProfile.class);
            Intent p=getIntent();
            i.putExtra("phone",p.getStringExtra("phone"));
            startActivity(i);

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.firstDateToPicforWhatBtn) {
            DatePicker datePicker = new DatePicker(this);
            int currentDate = datePicker.getDayOfMonth();
            int currentMonth = (datePicker.getMonth()) + 1;
            int currentYear = datePicker.getYear();


            datePickerDialog = new DatePickerDialog(this,

                    new DatePickerDialog.OnDateSetListener() {


                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                            WhatFirstDateTxt.setText(dayOfMonth + "/" + month +1+ "/" + year);

                        }
                    }, currentYear, currentMonth, currentDate);
            datePickerDialog.show();

        } else if (v.getId() == R.id.lastDateToPicforWhatBtn) {
            DatePicker datePicker = new DatePicker(this);
            int currentDate = datePicker.getDayOfMonth();
            int currentMonth = (datePicker.getMonth()) + 1;
            int currentYear = datePicker.getYear();


            datePickerDialog = new DatePickerDialog(this,

                    new DatePickerDialog.OnDateSetListener() {


                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                            WhatLastDateTxt.setText(dayOfMonth + "/" + month+1+ "/" + year);

                        }
                    }, currentYear, currentMonth, currentDate);
            datePickerDialog.show();
        }
        if (v.getId() == R.id.yesforWhatBtn)
        {
            identity="Yes";

        }
        else if (v.getId() == R.id.noForWhatBtn)
        {
            identity="No";

        }
        if (v.getId() == R.id.DonateWhatBtn) {
            String flag1=WhatFirstDateTxt.getText().toString();
            String flag2=WhatLastDateTxt.getText().toString();
            String  DontionTitle= DontionTitleEdTxt.getText().toString();
            String DonationDesctiption = DonationDesctiptionEdTxt.getText().toString();

            if (flag1.length()==0||flag2.length()==0||DontionTitle.length()==0) {
                Toast.makeText(getApplicationContext(), "PLEASE GIVE ALL INFORMATION", Toast.LENGTH_LONG).show();
            } else {
                extraprofile fp=new extraprofile(DontionTitle,flag1,flag2,identity,DonationDesctiption);

                DatabaseReference ref= FirebaseDatabase.getInstance().getReference("Extra");
                Intent p=getIntent();
                String user= p.getStringExtra("phone");
                ref.child(user).push().setValue(fp);

                Toast.makeText(getApplicationContext(), "Allhamdulillah", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, ThankYou.class);
                startActivity(intent);
            }
        }



    }
}