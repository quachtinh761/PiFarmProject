package vn.com.gant.pifarm.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.com.gant.pifarm.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ActionBarHasBackFragment extends Fragment {


    public ActionBarHasBackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_action_bar_has_back, container, false);
    }

}
