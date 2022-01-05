package com.example.DONATION_APP.UserProfile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.DONATION_APP.DonarListView;
import com.example.DONATION_APP.ForSignOrLogIn;
import com.example.DONATION_APP.MainActivity;
import com.example.DONATION_APP.R;
import com.example.DONATION_APP.activities;
import com.example.DONATION_APP.donatebook;
import com.example.DONATION_APP.donatecloth;
import com.example.DONATION_APP.donateextra;
import com.example.DONATION_APP.donatefood;

public class UserProfile extends AppCompatActivity implements View.OnClickListener {

    private Button food, book, cloth, ex;
    private Button lastAc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        setTitle(null);
        food = findViewById(R.id.FOOD);
        book = findViewById(R.id.BOOK);
        cloth = findViewById(R.id.CLOTH);
        ex = findViewById(R.id.OTHER);
        lastAc = findViewById(R.id.TopAC);

        food.setOnClickListener(this);
        book.setOnClickListener(this);
        cloth.setOnClickListener(this);
        ex.setOnClickListener(this);
        lastAc.setOnClickListener(this);

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
            Intent i=new Intent(this, MainActivity.class);
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
        if (v.getId() == R.id.FOOD) {
            Intent intent = new Intent(this, donatefood.class);
            Intent p=getIntent();
            intent.putExtra("phone",p.getStringExtra("phone"));
            startActivity(intent);

        } else if (v.getId() == R.id.BOOK) {
            Intent intent = new Intent(this, donatebook.class);
            Intent p=getIntent();
            intent.putExtra("phone",p.getStringExtra("phone"));
            startActivity(intent);

        } else if (v.getId() == R.id.CLOTH) {
            Intent intent = new Intent(this, donatecloth.class);
            Intent p=getIntent();
            intent.putExtra("phone",p.getStringExtra("phone"));
            startActivity(intent);

        } else if (v.getId() == R.id.OTHER) {
            Intent intent = new Intent(this, donateextra.class);
            Intent p=getIntent();
            intent.putExtra("phone",p.getStringExtra("phone"));
            startActivity(intent);

        }
        if (v.getId() == R.id.TopAC) {
            Intent intent = new Intent(this, DonarListView.class);
        /*    Intent p=getIntent();
            intent.putExtra("phone",p.getStringExtra("phone"));*/
            startActivity(intent);
        }

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(this, ForSignOrLogIn.class);
        startActivity(i);
    }
}