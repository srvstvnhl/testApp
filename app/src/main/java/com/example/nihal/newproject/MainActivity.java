package com.example.nihal.newproject;

import android.graphics.Color;
import android.net.Uri;
import android.service.autofill.FillCallback;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ToxicBakery.viewpager.transforms.AccordionTransformer;

import java.util.ArrayList;

import devlight.io.library.ntb.NavigationTabBar;

public class MainActivity extends AppCompatActivity /*implements Tab1.OnFragmentInteractionListener,Tab2.OnFragmentInteractionListener,Tab3.OnFragmentInteractionListener*/ {
MyViewPager myViewPager;
TabLayout tabLayout;
//NavigationTabBar navigationTabBar;
    private static int COUNT=4;

    private ArrayList<NavigationTabBar.Model> models=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        myViewPager=new MyViewPager(getBaseContext());
        //navigationTabBar=new NavigationTabBar(getBaseContext());
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        myViewPager.setAdapter(viewPagerAdapter);
        //myViewPager.setPageTransformer(true, new AccordionTransformer());
        tabLayout.setupWithViewPager(myViewPager,true);
        /*models.add(
                new NavigationTabBar.Model.Builder(
                        ContextCompat.getDrawable(this,R.drawable.abc),
                        Color.rgb(7,94,84)
                ).title("Chats")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        ContextCompat.getDrawable(this,R.drawable.abc),
                        Color.rgb(255,102,0)
                ).title("Profile")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        ContextCompat.getDrawable(this,R.drawable.abc),
                        Color.BLUE
                ).title("Consult")
                        .build()
        );
        navigationTabBar.setModels(models);
        navigationTabBar.setViewPager(myViewPager);*/
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private int selection = 0;
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                if (selection == position)
                    return Fragment1.newInstance();
                else
                    return Fragment1.newInstance();
            }

            if (position == 1) {
                if (selection == position)
                    return Fragment2.newInstance();
                else
                    return Fragment2.newInstance();
            }
            if (position == 2){
                if(selection==position)
                    return Fragment3.newInstance();
                else
                    return Fragment3.newInstance();
            }

            else {
                if (selection == position)
                    return Fragment4.newInstance();
                else
                    return Fragment4.newInstance();
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0 : return "Consult";
                case 1 : return "Chats";
                case 2 : return "Peoples";
                case 3 : return "Profile";
                default: return "DUMMY";
            }
        }

        @Override
        public int getCount() {
            return COUNT;
        }
    }
}
/*TabLayout tabLayout = findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Consultant"));
        tabLayout.addTab(tabLayout.newTab().setText("Chats"));
        tabLayout.addTab(tabLayout.newTab().setText("Peoples"));
        tabLayout.addTab(tabLayout.newTab().setText("Profile"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager=findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
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

    @Override
    public void onFragmentInteraction(Uri uri) {

    }*/