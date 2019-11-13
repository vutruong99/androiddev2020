package vn.edu.usth.weather;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ForcastFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ForcastFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForcastFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = new View(getContext());
        v.setBackgroundColor(0xFF800080);
        return v;
    }


}
