package com.iit.glidapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.iit.glidapp.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailFragment extends Fragment implements View.OnClickListener{

    private Button mButton;

    public DetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container,false);
         mButton = (Button) view.findViewById(R.id.fragment_button);
        mButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Log.v("iit","fragment button");
    }
}
