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
import com.example.DONATION_APP.UserProfile.CustomAdapterClothDemo;
import com.example.DONATION_APP.volunteer.VolunteerAcception;

public class cloth extends Fragment implements AdapterView.OnItemClickListener {

    private View clothFragmentView;

    private ListView listView;
    String[] startTimeString,endTimeString;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        clothFragmentView = inflater.inflate(R.layout.fragment_cloth, container, false);
        listView=clothFragmentView.findViewById(R.id.listViewClothId);
        startTimeString=getResources().getStringArray(R.array.bookSting1);
        endTimeString=getResources().getStringArray(R.array.bookString2);

        CustomAdapterClothDemo customAdaptecloth =new CustomAdapterClothDemo(getActivity(),startTimeString,endTimeString);
        listView.setAdapter(customAdaptecloth);
        listView.setOnItemClickListener(this);
        return clothFragmentView;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent=new Intent(getActivity(), VolunteerAcception.class);
        startActivity(intent);
    }
}