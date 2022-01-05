package com.example.DONATION_APP;


import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class DemoFragment extends Fragment {



    private int value1;
    DataInter dataInter=new DataInter();
    private View view;
    private TextView Vname,Vphone,VId,Vmail,Vadd;
    String[] VSAddress;
    String[] VSname;
    String[] VSid;
    String[] VSmail;
    String[] VSphone;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_demo, container, false);
        Vadd=view.findViewById(R.id.mar);
        Vname=view.findViewById(R.id.fragmentIdName);
        Vphone=view.findViewById(R.id.fragmentIdmobile);
        Vmail=view.findViewById(R.id.fragmentIdmail);
        VId=view.findViewById(R.id.fragmetIdBirth);
        //value1=dataInter.Data21Inter();
        value1=DataInter.val;
        //Toast.makeText(getActivity(),"Position "+value1,Toast.LENGTH_SHORT).show();
        VSAddress=view.getResources().getStringArray(R.array.address_id);
        VSname=view.getResources().getStringArray(R.array.name_id);
        VSid=view.getResources().getStringArray(R.array.birthId_id);
        VSphone=view.getResources().getStringArray(R.array.phone_id);
        VSmail=view.getResources().getStringArray(R.array.email_id);

        String data1=VSAddress[value1];
        String data2=VSname[value1];;
        String data3=VSid[value1];
        String data4=VSphone[value1];
        String data5=VSmail[value1];
        Vadd.setText(data1);
        Vmail.setText(data5);
        Vphone.setText(data4);
        Vname.setText(data2);
        VId.setText(data3);



        return view;
    }
}