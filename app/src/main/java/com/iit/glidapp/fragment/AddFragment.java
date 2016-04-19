package com.iit.glidapp.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.iit.glidapp.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class AddFragment extends Fragment implements View.OnClickListener {

    private Button mButton;
    private EditText mInputName;
    private EditText mInputAge;

    private static AddPersonListener mAddPersonListener;

    public static AddFragment newInstance(AddPersonListener listener){
        AddFragment fragment =  new AddFragment();
        mAddPersonListener =listener;
        return fragment;
    }


    public AddFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        mButton = (Button) view.findViewById(R.id.fragment_button);
        mInputName = (EditText) view.findViewById(R.id.edit_name);
        mInputAge = (EditText) view.findViewById(R.id.edit_age);

        mButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fragment_button) {
            String name = mInputName.getText().toString();
            String age = mInputAge.getText().toString();
            if (!name.isEmpty() && !age.isEmpty()) {
                mAddPersonListener.onFinishAddPerson(name, Integer.valueOf(age));
            }
        }
    }


    public interface AddPersonListener {
        public void onFinishAddPerson(String name, int age);
    }
}
