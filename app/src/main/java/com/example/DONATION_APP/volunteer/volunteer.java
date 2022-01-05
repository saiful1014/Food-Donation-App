package com.example.DONATION_APP.volunteer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.DONATION_APP.ForSignOrLogIn;
import com.example.DONATION_APP.R;
import com.example.DONATION_APP.account.Volunteer_Book;
import com.example.DONATION_APP.fragment.book;
import com.example.DONATION_APP.fragment.cloth;
import com.example.DONATION_APP.fragment.food;
import com.example.DONATION_APP.fragment.other;
import com.google.android.material.tabs.TabLayout;

public class volunteer extends AppCompatActivity{
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer);
        tabLayout = findViewById(R.id.tablayoutId);
        viewPager = findViewById(R.id.viewPageId);
        viewPager.setAdapter(new MyPageAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
    public void foodclickvolunteer(View view)
    {
        Intent i=new Intent(this,food.class);
        startActivity(i);


    } public void bookclickvolunteer(View view)
    {
        Intent i=new Intent(this, Volunteer_Book.class);
        startActivity(i);

    } public void clothclickvolunteer(View view)
    {
        Intent i=new Intent(this,cloth.class);
        startActivity(i);

    } public void othersclickvolunteer(View view)
    {
        Intent i=new Intent(this,other.class);
        startActivity(i);

    }
    class MyPageAdapter extends FragmentPagerAdapter {

        String[] text = {"FOOD", "BOOK", "CLOTH","OTHERS"};

        public MyPageAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            if (position == 0)
            {
                Toast.makeText(getApplicationContext(),"This is position "+position,Toast.LENGTH_LONG).show();
                return new food();
            }

            else if (position == 1)
            {
                Toast.makeText(getApplicationContext(),"This is position "+position,Toast.LENGTH_LONG).show();
                return new book();
            }

            else if (position == 2)
            {
                Toast.makeText(getApplicationContext(),"This is position "+position,Toast.LENGTH_LONG).show();
                return new cloth();
            }
            else if(position==3)
            {
                Toast.makeText(getApplicationContext(),"This is position "+position,Toast.LENGTH_LONG).show();
                return new other();
            }


            return null;

        }

        @Override
        public int getCount() {
            return text.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {

            return text[position];
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(this, ForSignOrLogIn.class);
        startActivity(i);
    }

}