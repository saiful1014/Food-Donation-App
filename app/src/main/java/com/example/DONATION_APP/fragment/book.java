package com.example.DONATION_APP.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.DONATION_APP.R;
import com.example.DONATION_APP.UserProfile.CustomAdapterBookDemo;
import com.example.DONATION_APP.volunteer.VolunteerAcception;

public class book extends Fragment implements AdapterView.OnItemClickListener {

    private View bookFragmentView;

    private ListView listView;
    String[] startTimeString,endTimeString;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bookFragmentView = inflater.inflate(R.layout.fragment_book, container, false);
        listView=bookFragmentView.findViewById(R.id.listViewBookId);
        startTimeString=getResources().getStringArray(R.array.bookSting1);
        endTimeString=getResources().getStringArray(R.array.bookString2);

        CustomAdapterBookDemo customAdapteBook =new CustomAdapterBookDemo(getActivity(),startTimeString,endTimeString);
        listView.setAdapter(customAdapteBook);
        listView.setOnItemClickListener(this);
        return bookFragmentView;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent=new Intent(getActivity(), VolunteerAcception.class);
        startActivity(intent);
    }
}