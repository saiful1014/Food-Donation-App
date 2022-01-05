package com.example.DONATION_APP.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.DONATION_APP.DataInter;
import com.example.DONATION_APP.R;
import com.example.DONATION_APP.UserProfile.CustomAdapterFoodDemo;
import com.example.DONATION_APP.volunteer.VolunteerAcception;

import java.util.ArrayList;

public class food extends Fragment implements AdapterView.OnItemClickListener {

    private View foodFragmentView;

    private ListView listView;
    String[] startTimeString,endTimeString;
    ArrayList<String> ref = new ArrayList<>();
 /*   private int slength;
    DataInter dataInter=new DataInter();
    String a,b,c;*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        foodFragmentView = inflater.inflate(R.layout.fragment_food, container, false);
        listView=foodFragmentView.findViewById(R.id.listViewFoodId);
        startTimeString=getResources().getStringArray(R.array.bookSting1);
        endTimeString=getResources().getStringArray(R.array.bookString2);

       /* a=dataInter.getterA();
        b=dataInter.getterB();
        c=dataInter.getterC();*/

      /*  slength=startTimeString.length;
        startTimeString[slength]=b;
        endTimeString[slength]=c;
        datestring[slength]=a;*/


        CustomAdapterFoodDemo customAdaptefood =new CustomAdapterFoodDemo(getActivity(),startTimeString,endTimeString);
        listView.setAdapter(customAdaptefood);
        listView.setOnItemClickListener(this);
        return foodFragmentView;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent=new Intent(getActivity(), VolunteerAcception.class);
        startActivity(intent);
    }
}