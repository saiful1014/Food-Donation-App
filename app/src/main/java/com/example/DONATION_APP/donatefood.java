package com.example.DONATION_APP;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
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
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.DONATION_APP.UserProfile.UserProfile;
import com.example.DONATION_APP.UserProfile.profile;
import com.example.DONATION_APP.data.foodprofile;
import com.example.DONATION_APP.fragment.ThankYou;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class donatefood extends AppCompatActivity implements View.OnClickListener {
    private Button foodDate,foodFirstTime,foodLastTime,foodDonation,foodYes,foodNo,foodComment;
    private TextView foodDateTxt,foodFirstTimeTxt,foodLastTimeTxt;
    private EditText foodCommentEdTxt;
    //private int Flag=0;
    String identity,date,first,last,com,user;

    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;



    /*//Doc

    private String[] fooddate,foodstime,foodetime;
    DataInter dataInter=new DataInter();




    //Doc
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donatefood);
        foodDate=findViewById(R.id.donationDateforFoodBtn);
        foodDateTxt=findViewById(R.id.donationDateforFoodTxt);
        foodFirstTime=findViewById(R.id.firstTimeToPickforFoodBtn);
        foodFirstTimeTxt=findViewById(R.id.firstTimeToPicforFoodTxt);
        foodLastTime=findViewById(R.id.lastTimeToPickforFoodBtn);
        foodLastTimeTxt=findViewById(R.id.lastTimeToPickforFoodTxt);
        foodYes=findViewById(R.id.yesforFoodBtn);
        foodNo=findViewById(R.id.noforFoodBtn);
        //foodComment=findViewById(R.id.sendCommentforFoodBtn);
        foodCommentEdTxt=findViewById(R.id.commentforFoodEdTxt);
        foodDonation=findViewById(R.id.DonteFoodBtn);
        foodDate.setOnClickListener(this);
        foodFirstTime.setOnClickListener(this);
        foodLastTime.setOnClickListener(this);
        foodDonation.setOnClickListener(this);
        foodYes.setOnClickListener(this);
        foodNo.setOnClickListener(this);
        //foodComment.setOnClickListener(this);

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
        if (v.getId() == R.id.donationDateforFoodBtn) {

            DatePicker datePicker=new DatePicker(this);
            int currentDate=datePicker.getDayOfMonth();
            int currentMonth=(datePicker.getMonth())+1;
            int currentYear=datePicker.getYear();


            datePickerDialog=new DatePickerDialog(this,

                    new DatePickerDialog.OnDateSetListener(){


                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                            foodDateTxt.setText(dayOfMonth+"/"+month+"/"+year);


                        }
                    },currentYear,currentMonth,currentDate);
            datePickerDialog.show();
        }
        else if(v.getId()==R.id.firstTimeToPickforFoodBtn)
        {
            TimePicker timePicker=new TimePicker(this);
            int currentHour=timePicker.getHour();
            int currentMinute=timePicker.getMinute();

            timePickerDialog=new TimePickerDialog(this,

                    new TimePickerDialog.OnTimeSetListener(){

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                            foodFirstTimeTxt.setText(hourOfDay+" :"+minute);


                        }
                    },currentHour,currentMinute,false);
            timePickerDialog.show();
        }
        else if(v.getId()==R.id.lastTimeToPickforFoodBtn)
        {
            TimePicker timePicker=new TimePicker(this);
            int currentHour=timePicker.getHour();
            int currentMinute=timePicker.getMinute();

            timePickerDialog=new TimePickerDialog(this,

                    new TimePickerDialog.OnTimeSetListener(){

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                            foodLastTimeTxt.setText(hourOfDay+" :"+minute);


                        }
                    },currentHour,currentMinute,false);
            timePickerDialog.show();
        }
        if(v.getId()==R.id.yesforFoodBtn)
        {
            identity="Yes";

        }
        else if(v.getId()==R.id.noforFoodBtn)
        {
            identity="No";

        }
        if(v.getId()==R.id.DonteFoodBtn)
        {


                 date=foodDateTxt.getText().toString();
                 first=foodFirstTimeTxt.getText().toString();
                 last=foodLastTimeTxt.getText().toString();
                 com=foodCommentEdTxt.getText().toString();

                 //dataInter.data212Inter(date,first,last);

                 if(date.length()==0|| first.length()==0||last.length()==0||identity.length()==0)
                 {
                     Toast.makeText(getApplicationContext(),"PLEASE GIVE ALL INFORMATION",Toast.LENGTH_LONG).show();
                 }
                 else
                 {
                     Calendar calendar = Calendar.getInstance();
                     SimpleDateFormat currentDateFormat = new SimpleDateFormat("MMM dd, yyyy");
                   String  currentDate = currentDateFormat.format(calendar.getTime());

                     Calendar calendarForTime = Calendar.getInstance();
                     SimpleDateFormat currentTimeFormat = new SimpleDateFormat("hh:mm a");
                    String currentTime = currentTimeFormat.format(calendarForTime.getTime());
                     Intent p=getIntent();
                     user= p.getStringExtra("phone");
                     DatabaseReference ref= FirebaseDatabase.getInstance().getReference("Food");
                     String key=currentTime+currentDate;
                     foodprofile  fp=new foodprofile(date,first,last,identity,com,user,key);

                     ref.child(user).setValue(fp);

                     ref.addListenerForSingleValueEvent(new ValueEventListener() {
                         @Override
                         public void onDataChange(@NonNull DataSnapshot snapshot) {

                         }

                         @Override
                         public void onCancelled(@NonNull DatabaseError error) {

                         }
                     });



                     Toast.makeText(getApplicationContext(),"Allhamdulillah you donate successfully",Toast.LENGTH_LONG).show();
                     Intent intent=new Intent(this, ThankYou.class);
                     startActivity(intent);

                 }



        }
       // String FoodComment=foodCommentEdTxt.getText().toString();
       /* if(v.getId()==R.id.sendCommentforFoodBtn)
        {
            if(FoodComment==null)
            {

                Toast.makeText(getApplicationContext(),"PLEASE WRITE A COMMENT",Toast.LENGTH_LONG).show();
            }
            else{
                com=foodCommentEdTxt.getText().toString();
                foodprofile  fp=new foodprofile(date,first,last,identity,com);
                DatabaseReference ref= FirebaseDatabase.getInstance().getReference("Food");
                Intent p=getIntent();
                user= p.getStringExtra("phone");
                ref.child(user).push().setValue(fp);


                Toast.makeText(getApplicationContext(),"THANK YOU FOR YOUR COMMENT",Toast.LENGTH_LONG).show();
            }
        }*/


    }
}