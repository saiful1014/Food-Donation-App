package com.example.DONATION_APP;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.DONATION_APP.data.donardata;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ForLgPage extends AppCompatActivity implements View.OnClickListener {
    private EditText e1, e2, e3, e4, e5, e6, e7;
    private Button b1;
    DatabaseReference my = FirebaseDatabase.getInstance().getReference("user");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("SIGN_IN");
        setContentView(R.layout.activity_for_lg_page2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        e1 = findViewById(R.id.firstNameId);
        e2 = findViewById(R.id.lastNameId);
        e3 = findViewById(R.id.email);
        e4 = findViewById(R.id.phone_number);
        e5 = findViewById(R.id.birthday);
        e6 = findViewById(R.id.epass);
        e7 = findViewById(R.id.cpass);
        b1 = findViewById(R.id.signup);
        b1.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        String first=e1.getText().toString().trim();
        String last=e2.getText().toString().trim();
        String email=e3.getText().toString().trim();
        String phone=e4.getText().toString().trim();
        String birth=e5.getText().toString().trim();
        String pass=e6.getText().toString().trim();
        String cpass=e7.getText().toString().trim();
        donardata dt=new donardata(first,last,email,phone,birth,pass,cpass);
        if(first.length()==0)
            e1.setError("Please enter your first name");
        else if(last.length()==0)
            e2.setError("Please enter your last name");
        else if(email.length()==0)
            e3.setError("Please enter your email");
        else if(phone.length()==0)
            e4.setError("Please enter your phone number");
        else if(pass.length()<6)
        {
            e6.setError("please enter atleast 6 digit");
        }
        else if(pass.equals(cpass)){

            e6.setError(null);



            my.child(phone).setValue(dt);


            Toast.makeText(this, "your data stored", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,ForLogInActivity.class);
            startActivity(intent);
        }
        else
        {
            e7.setError("Password is not matching");

        }
    }
}