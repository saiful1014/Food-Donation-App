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
import com.example.DONATION_APP.data.clothprofile;
import com.example.DONATION_APP.fragment.ThankYou;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class donatecloth extends AppCompatActivity implements View.OnClickListener {
    private Button clothFirstDate, clothLastDate, clothDonation, clothYes, clothNo;
    private TextView clothFirstDateTxt, clothLastDateTxt;
    private EditText clothCommentEdTxt, clothAmountEdTxt;
    private int Flag;
    private DatePickerDialog datePickerDialog;
    private String identity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donatecloth);
        clothFirstDate = findViewById(R.id.firstDateToPicforClothBtn);
        clothFirstDateTxt = findViewById(R.id.firstDateToPicforClothTxt);

        clothLastDate = findViewById(R.id.lastDateToPicforClothBtn);
        clothLastDateTxt = findViewById(R.id.lastDateToPicforClothTxt);

        clothDonation = findViewById(R.id.DonateClothBtn);

        clothYes = findViewById(R.id.yesforClothBtn);
        clothNo = findViewById(R.id.noForClothBtn);


        clothCommentEdTxt = findViewById(R.id.commentforClothEdTxt);

        clothAmountEdTxt = findViewById(R.id.donationAmountforClothEdTxt);


        clothFirstDate.setOnClickListener(this);
        clothLastDate.setOnClickListener(this);
        clothDonation.setOnClickListener(this);
        clothYes.setOnClickListener(this);
        clothNo.setOnClickListener(this);

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
        if (v.getId() == R.id.firstDateToPicforClothBtn) {
            DatePicker datePicker = new DatePicker(this);
            int currentDate = datePicker.getDayOfMonth();
            int currentMonth = (datePicker.getMonth()) + 1;
            int currentYear = datePicker.getYear();


            datePickerDialog = new DatePickerDialog(this,

                    new DatePickerDialog.OnDateSetListener() {


                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                            clothFirstDateTxt.setText(dayOfMonth + "/" + month+1 + "/" + year);

                        }
                    }, currentYear, currentMonth, currentDate);
            datePickerDialog.show();

        } else if (v.getId() == R.id.lastDateToPicforClothBtn) {
            DatePicker datePicker = new DatePicker(this);
            int currentDate = datePicker.getDayOfMonth();
            int currentMonth = (datePicker.getMonth()) + 1;
            int currentYear = datePicker.getYear();


            datePickerDialog = new DatePickerDialog(this,

                    new DatePickerDialog.OnDateSetListener() {


                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                            clothLastDateTxt.setText(dayOfMonth + "/" + month+1 + "/" + year);

                        }
                    }, currentYear, currentMonth, currentDate);
            datePickerDialog.show();
        }
        if (v.getId() == R.id.yesforClothBtn)
        {
            identity="Yes";

        }
        else if (v.getId() == R.id.noForClothBtn)
        {
            identity="No";

        }
        if (v.getId() == R.id.DonateClothBtn) {
            String flag1=clothFirstDateTxt.getText().toString();
            String flag2=clothLastDateTxt.getText().toString();
            String  ClothAmount= clothAmountEdTxt.getText().toString();

            if (flag1.length()==0||flag2.length()==0||ClothAmount.length()==0) {
                Toast.makeText(getApplicationContext(), "PLEASE GIVE ALL INFORMATION", Toast.LENGTH_LONG).show();
            } else {
                String ClothComment = clothCommentEdTxt.getText().toString();
                clothprofile fp=new clothprofile(ClothAmount,flag1,flag2,identity,ClothComment);
                DatabaseReference ref= FirebaseDatabase.getInstance().getReference("Cloth");
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