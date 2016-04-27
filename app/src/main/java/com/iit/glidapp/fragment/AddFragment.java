package com.iit.glidapp.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
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
public class AddFragment extends DialogFragment {

    private EditText mInputName;
    private EditText mInputAge;

    private static AddPersonListener mAddPersonListener;

    public static AddFragment newInstance(AddPersonListener listener) {
        AddFragment fragment = new AddFragment();
        mAddPersonListener = listener;
        return fragment;
    }


    public AddFragment() {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

//get the inflater
        LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //inflate the dialog view
        View dialogView = layoutInflater.inflate(R.layout.fragment_add_dialog, null);
        //get views references
        mInputName = (EditText) dialogView.findViewById(R.id.edit_name);
        mInputAge = (EditText) dialogView.findViewById(R.id.edit_age);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = mInputName.getText().toString();
                        String age = mInputAge.getText().toString();
                        if (!name.isEmpty() && !age.isEmpty()) {
                            mAddPersonListener.onFinishAddPerson(name, Integer.valueOf(age));
                        }
                    }
                }
        ).setNegativeButton(android.R.string.cancel, null).setTitle(R.string.add_fragment_title).setView(dialogView);

        return builder.create();

    }

    public void onDismiss (DialogInterface dialog){
        Log.d("IIT", "onDismiss: ");
        mAddPersonListener.onCancelAddPerson();
    }


    public interface AddPersonListener {
        public void onFinishAddPerson(String name, int age);
        public void onCancelAddPerson();
    }
}
