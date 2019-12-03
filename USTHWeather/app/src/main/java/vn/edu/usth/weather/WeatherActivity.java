package vn.edu.usth.weather;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.support.v4.app.FragmentActivity;
import android.widget.TableLayout;
import android.support.design.widget.TabLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class WeatherActivity extends AppCompatActivity {

    MediaPlayer mp;

    final Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
// This method is executed in main thread
            String content = msg.getData().getString("server_response");
            Toast.makeText(getApplicationContext(), content, Toast.LENGTH_SHORT).show();
        }
    };

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

        InputStream is = getResources().openRawResource(R.raw.humble);

        writeExternal();

        mp = MediaPlayer.create(getApplicationContext(), R.raw.humble);

        mp.start();

    }



    //Labwork 12
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.refresh:
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
// this method is run in a worker thread
                        try {
// wait for 5 seconds to simulate a long network access
                            Thread.sleep(5000);
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }
// Assume that we got our data from server
                        Bundle bundle = new Bundle();
                        bundle.putString("server_response", "some sample json here");
// notify main thread
                        Message msg = new Message();
                        msg.setData(bundle);
                        handler.sendMessage(msg);
                    }
                });
                t.start();
                return true;
            case R.id.settings:
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

    //labwork 11
    private void writeExternal() {
        String filename = "humble.mp3";
        String filepath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/";

        try {
            InputStream is = getApplicationContext().getResources().openRawResource(R.raw.humble);
            File myFile = new File(filepath + filename);
            myFile.createNewFile();
            OutputStream fout = new FileOutputStream(myFile);
            fout.write(is.read());
            fout.close();
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        mp.stop();
        mp.release();
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
