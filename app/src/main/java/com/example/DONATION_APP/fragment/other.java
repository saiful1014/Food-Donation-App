package com.example.DONATION_APP.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.DONATION_APP.R;
import com.example.DONATION_APP.UserProfile.CustomAdapterOtherDemo;
import com.example.DONATION_APP.volunteer.VolunteerAcception;

public class other extends Fragment implements AdapterView.OnItemClickListener {

    private View otherFragmentView;

    private ListView listView;
    String[] startTimeString,endTimeString;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        otherFragmentView = inflater.inflate(R.layout.fragment_other, container, false);
        listView=otherFragmentView.findViewById(R.id.listViewOthersId);
        startTimeString=getResources().getStringArray(R.array.bookString2);
        endTimeString=getResources().getStringArray(R.array.bookSting1);

        CustomAdapterOtherDemo customAdapteother =new CustomAdapterOtherDemo(getActivity(),startTimeString,endTimeString);
        listView.setAdapter(customAdapteother);
        listView.setOnItemClickListener(this);
        return otherFragmentView;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent=new Intent(getActivity(), VolunteerAcception.class);
        startActivity(intent);
    }
}