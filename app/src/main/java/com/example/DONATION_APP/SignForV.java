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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class SignForV extends AppCompatActivity implements View.OnClickListener {

    private EditText e1, e2;
    private Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_for_v);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        e1 = findViewById(R.id.lg_ph);
        e2 = findViewById(R.id.lg_ps);
        b1 = findViewById(R.id.lgbu);
        b1.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        loginuser(v);
        String pho = e1.getText().toString().trim();
        String pas = e2.getText().toString().trim();
        if ((pho.length() == 0) || (pas.length() == 0)) {
            Toast.makeText(this, "Please Enter Your Phone Number And Password", Toast.LENGTH_SHORT).show();

        } else {

        }

    }

    private void loginuser(View v) {
        if (!validateUsername() | !validatePassword()) {
            return;
        }
        else {
            isUser();
        }
    }

    private void isUser() {
        final String userEnteredUsername = e1.getText().toString().trim();
        final String userEnteredPassword = e2.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("volunteer");
        Query checkUser = reference.orderByChild("phone").equalTo(userEnteredUsername);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    e1.setError(null);

                    String passwordFromDB = snapshot.child(userEnteredUsername).child("pass").getValue(String.class);
                    if (passwordFromDB.equals(userEnteredPassword)) {
                        e1.setError(null);

                       /* String nameFromDB = snapshot.child(userEnteredUsername).child("firstname").getValue(String.class);
                        String usernameFromDB = snapshot.child(userEnteredUsername).child("lastname").getValue(String.class);
                        String phoneNoFromDB = snapshot.child(userEnteredUsername).child("phone").getValue(String.class);
                        String emailFromDB = snapshot.child(userEnteredUsername).child("email").getValue(String.class);
                        Intent intent = new Intent(getApplicationContext(), UserProfile.class);
                        intent.putExtra("firstname", nameFromDB);
                        intent.putExtra("lastname", usernameFromDB);
                        intent.putExtra("email", emailFromDB);
                        intent.putExtra("phone", phoneNoFromDB);
                        intent.putExtra("pass", passwordFromDB);
                        startActivity(intent);
                        */
                        Intent i=new Intent(getApplicationContext(),volunteer.class);
                        startActivity(i);

                    } else {

                        e2.setError("Wrong Password");
                        e2.requestFocus();
                    }
                } else {

                    e1.setError("No such User exist");
                    e1.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private boolean validatePassword() {
        String val = e2.getText().toString();
        if (val.isEmpty()) {
            e2.setError("Field cannot be empty");
            return false;
        } else {
            e2.setError(null);
            return true;
        }

    }


    private boolean validateUsername() {
        String val = e1.getText().toString();
        if (val.isEmpty()) {
            e1.setError("Field cannot be empty");
            return false;
        } else {
            e1.setError(null);
            return true;
        }


    }
}