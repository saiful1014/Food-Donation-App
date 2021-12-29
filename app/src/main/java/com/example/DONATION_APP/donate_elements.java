package com.example.DONATION_APP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class donate_elements extends AppCompatActivity {
    private Button f,c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_elements);
        f=findViewById(R.id.food);
        c=findViewById(R.id.cloths);
    }
    public void foodclick(View view)
    {
        Intent i=new Intent(this,donatefood.class);
        Intent p=getIntent();
        i.putExtra("phone",p.getStringExtra("phone"));
        startActivity(i);

    } public void clothclick(View view)
    {
        Intent i=new Intent(this,donatefood.class);
        Intent p=getIntent();
        i.putExtra("phone",p.getStringExtra("phone"));
        startActivity(i);

    }

}