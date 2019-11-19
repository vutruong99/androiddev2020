package vn.edu.usth.weather;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.support.v4.app.FragmentActivity;
import android.widget.TableLayout;
import android.support.design.widget.TabLayout;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Log.i("onCreate","Weather activity is being created");

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new HomeFragmentAdapter(getSupportFragmentManager());
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("onStart","Weather activity is starting");
    }

    protected void onResume() {
        super.onResume();
        Log.i("onResume","Weather activity is resuming");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("onPause","Weather activity is pausing");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i("onStop","Weather activity is stopping");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("onDestroy","Weather activity is being destroyed");
    }
}