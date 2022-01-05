package com.example.DONATION_APP;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class DonarListView extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    String[] nameId/*,mobileId,BirthID,EmailID,AddressId*/;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar_list_view);

        listView=findViewById(R.id.idfragment);
        nameId=getResources().getStringArray(R.array.name_id);
        /*mobileId=getResources().getStringArray(R.array.phone_id);
        BirthID=getResources().getStringArray(R.array.birthId_id);
        EmailID=getResources().getStringArray(R.array.email_id);
        AddressId=getResources().getStringArray(R.array.address_id);*/


        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.simple_layout_listview,R.id.ListViewNameId,nameId);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Fragment fragment;
        // dataInter=new DataInter();
        DataInter.val=position;
        //dataInter.Data2Inter(position);
        fragment = new DemoFragment();
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentId,fragment);
        fragmentTransaction.commit();

    }
}