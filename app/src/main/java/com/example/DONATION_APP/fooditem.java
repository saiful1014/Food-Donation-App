package com.example.DONATION_APP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.DONATION_APP.data.fitem;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class fooditem extends AppCompatActivity {
    private EditText a,b;
    private TextView t;
    private Button c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fooditem);
        a=findViewById(R.id.e1);
        b=findViewById(R.id.e2);
        c=findViewById(R.id.b1);
        t=findViewById(R.id.t1);

    }
    public void fi(View view)
    {
        DatabaseReference my = FirebaseDatabase.getInstance().getReference("Food");
        String type=a.getText().toString();
        String quan=b.getText().toString();
        fitem ft=new fitem(type,quan);
        Intent p=getIntent();
        String tt=p.getStringExtra("phone");
       // t.setText(tt);

        my.child(tt).push().setValue(ft);

    }
}