package com.poison.loadpagertest;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTab;
    private ViewPager mPager;
    private String[] mTitls = {"加载成功","加载为空","加载失败","失败后成功"};
    private List<Fragment> mDatas;
    private MyAdapter mAdapter;

    private void assignViews() {
        mTab = (TabLayout) findViewById(R.id.tab);
        mPager = (ViewPager) findViewById(R.id.pager);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
        mDatas = new ArrayList<>();
        mDatas.add(new SuccessFragment());
        mDatas.add(new EmptyFragment());
        mDatas.add(new ErrorFragment());
        mDatas.add(new ErrorToSuccessFragment());
        mAdapter = new MyAdapter(getSupportFragmentManager());
        mTab.setTabMode(TabLayout.MODE_FIXED);
        mPager.setAdapter(mAdapter);
        mTab.setupWithViewPager(mPager);
        mTab.setTabsFromPagerAdapter(mAdapter);
    }


    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mDatas.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitls[position];
        }

        @Override
        public int getCount() {
            return mDatas.size();
        }
    }
}
