package in.co.chicmic.viewtask.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import in.co.chicmic.viewtask.R;
import in.co.chicmic.viewtask.adapters.ViewPagerAdapter;
import in.co.chicmic.viewtask.fragments.FiveFragment;
import in.co.chicmic.viewtask.fragments.FourFragment;
import in.co.chicmic.viewtask.fragments.OneFragment;
import in.co.chicmic.viewtask.fragments.SixFragment;
import in.co.chicmic.viewtask.fragments.ThreeFragment;
import in.co.chicmic.viewtask.fragments.TwoFragment;
import in.co.chicmic.viewtask.utilities.AppConstants;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    public ViewPager mViewPager, mTempViewPager;
    public TabLayout mTabLayout;
    private ViewPagerAdapter mAdapter, tempAdapter;
    private TabLayout mDotTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mViewPager = findViewById(R.id.viewpager);
        mTempViewPager = new ViewPager(this);
        mTabLayout = findViewById(R.id.tabs);
        mDotTabs = findViewById(R.id.tab_layout);
        setupViewPager();
        mTabLayout.setupWithViewPager(mViewPager);
        setBottomPageAdapter();
        mDotTabs.setupWithViewPager(mTempViewPager, true);
    }

    private void setupViewPager() {
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mAdapter.addFragment(new OneFragment(), AppConstants.sFRAGMENT_ONE);
        mAdapter.addFragment(new TwoFragment(), AppConstants.sFRAGMENT_TWO);
        mAdapter.addFragment(new ThreeFragment(), AppConstants.sFRAGMENT_THREE);
        mAdapter.addFragment(new FourFragment(), AppConstants.sFRAGMENT_FOUR);
        mAdapter.addFragment(new FiveFragment(), AppConstants.sFRAGMENT_FIVE);
        mAdapter.addFragment(new SixFragment(), AppConstants.sFRAGMENT_SIX);
        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(this);
    }

    private void setBottomPageAdapter() {
        tempAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        int fragmentCount = mAdapter.getCount();
        Log.e(MainActivity.class.getName(), String.valueOf(fragmentCount));
        for (int index = 0; index < fragmentCount; index++) {
            tempAdapter.addFragment(null, "");
        }
        mTempViewPager.setAdapter(tempAdapter);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mTempViewPager.setCurrentItem(position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
