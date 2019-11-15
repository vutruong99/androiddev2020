package vn.edu.usth.weather;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;


public class ForecastFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_weather, container, false);

        LinearLayout linearLayout = v.findViewById(R.id.linear_layout);

        TextView day = new TextView(getActivity());
        day.setText("Thursday");
        day.setPadding(0, 10, 0, 10);
        day.setTextSize(35);
        day.setTypeface(null, Typeface.BOLD);
        day.setGravity(Gravity.CENTER);

        ImageView weatherIcon = new ImageView(getActivity());
        weatherIcon.setImageResource(R.drawable.snowandrain);
        weatherIcon.setScaleType(ImageView.ScaleType.FIT_CENTER);
        weatherIcon.setScaleX((float) 0.5);
        weatherIcon.setScaleY((float) 0.5);
        weatherIcon.setAdjustViewBounds(true);

        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.addView(day);
        linearLayout.addView(weatherIcon);

        v.setBackgroundResource(R.drawable.gradient_background);

        return v;
    }


}
