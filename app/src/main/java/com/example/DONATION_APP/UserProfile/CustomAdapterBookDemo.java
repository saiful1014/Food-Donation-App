package com.example.DONATION_APP.UserProfile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.DONATION_APP.R;

public class CustomAdapterBookDemo extends BaseAdapter {

    String[] endTimeString,startTimeString;
    Context context;
    private LayoutInflater inflater;
    private TextView textViewbookstart,textViewbookend;

    public CustomAdapterBookDemo(Context context, String[] endTimeString, String[] startTimeSting)
    {
        this.endTimeString=endTimeString;
        this.startTimeString=startTimeSting;
        this.context=context;
    }



    @Override
    public int getCount() {
        return endTimeString.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.simple_book_demo,parent,false);
        }
        textViewbookstart=convertView.findViewById(R.id.bookendtimeId);
        textViewbookend=convertView.findViewById(R.id.bookstarttimeId);

        textViewbookend.setText(endTimeString[position]);
        textViewbookstart.setText(startTimeString[position]);

        return convertView;
    }
}
