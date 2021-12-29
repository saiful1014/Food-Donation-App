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

import com.example.DONATION_APP.data.bookprofile;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class donatebook extends AppCompatActivity implements View.OnClickListener {
    private Button BookFirstDate, BookLastDate, BookDonation, BookYes, BookNo;
    private TextView BookFirstDateTxt, BookLastDateTxt;
    private EditText BookCommentEdTxt, BookAmountEdTxt;
    private int Flag;
    private DatePickerDialog datePickerDialog;
    String identity,comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donatebook);
        BookFirstDate = findViewById(R.id.firstDateToPicforBookBtn);
        BookFirstDateTxt = findViewById(R.id.firstDateToPicforBookTxt);

        BookLastDate = findViewById(R.id.lastDateToPicforBookBtn);
        BookLastDateTxt = findViewById(R.id.lastDateToPicforBookTxt);

        BookDonation = findViewById(R.id.DonateBookBtn);

        BookYes = findViewById(R.id.yesforBookBtn);
        BookNo = findViewById(R.id.noForBookBtn);


        BookCommentEdTxt = findViewById(R.id.commentforBookEdTxt);

        BookAmountEdTxt = findViewById(R.id.donationAmountforBookEdTxt);


        BookFirstDate.setOnClickListener(this);
        BookLastDate.setOnClickListener(this);
        BookDonation.setOnClickListener(this);
        BookYes.setOnClickListener(this);
        BookNo.setOnClickListener(this);

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
            Intent i=new Intent(this,profile.class);
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
            Intent i=new Intent(this,UserProfile.class);
            Intent p=getIntent();
            i.putExtra("phone",p.getStringExtra("phone"));
            startActivity(i);

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.firstDateToPicforBookBtn) {
            DatePicker datePicker = new DatePicker(this);
            int currentDate = datePicker.getDayOfMonth();
            int currentMonth = (datePicker.getMonth()) + 1;
            int currentYear = datePicker.getYear();


            datePickerDialog = new DatePickerDialog(this,

                    new DatePickerDialog.OnDateSetListener() {


                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                            BookFirstDateTxt.setText(dayOfMonth + "/" + month+1 + "/" + year);

                        }
                    }, currentYear, currentMonth, currentDate);
            datePickerDialog.show();

        } else if (v.getId() == R.id.lastDateToPicforBookBtn) {
            DatePicker datePicker = new DatePicker(this);
            int currentDate = datePicker.getDayOfMonth();
            int currentMonth = (datePicker.getMonth()) + 1;
            int currentYear = datePicker.getYear();


            datePickerDialog = new DatePickerDialog(this,

                    new DatePickerDialog.OnDateSetListener() {


                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                            BookLastDateTxt.setText(dayOfMonth + "/" + month+1 + "/" + year);

                        }
                    }, currentYear, currentMonth, currentDate);
            datePickerDialog.show();
        }
        if (v.getId() == R.id.yesforBookBtn)
        {
            identity="Yes";

        }
        else if (v.getId() == R.id.noForBookBtn)
        {
            identity="No";

        }
        if (v.getId() == R.id.DonateBookBtn) {
            String flag1=BookFirstDateTxt.getText().toString();
            String flag2=BookLastDateTxt.getText().toString();
            String  BookAmount= BookAmountEdTxt.getText().toString();
            comment=BookCommentEdTxt.getText().toString();

            if (flag1.length()==0||flag2.length()==0||BookAmount.length()==0) {
                Toast.makeText(getApplicationContext(), "PLEASE GIVE ALL INFORMATION", Toast.LENGTH_LONG).show();
            } else {
                bookprofile fp=new bookprofile(BookAmount,flag1,flag2,identity,comment);
                DatabaseReference ref= FirebaseDatabase.getInstance().getReference("Book");
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