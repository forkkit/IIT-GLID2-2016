package com.iit.glidapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.iit.glidapp.R;
import com.iit.glidapp.core.Person;
import com.iit.glidapp.ui.PersonAdapter;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class ListingFragment extends Fragment{

    private ListView mListView;

    PersonAdapter mPersonAdapter;
    private ArrayList<Person> mPersonsList;

    public ListingFragment() {
        mPersonsList = new ArrayList<>();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listing, container,false);
         mListView = (ListView) view.findViewById(R.id.list_view);





        mPersonAdapter = new PersonAdapter(getActivity().getApplicationContext(),mPersonsList);
        mListView.setAdapter(mPersonAdapter);
        fillAdapter();
        return view;
    }

    private void fillAdapter(){
        for (int i = 0; i<1000; i++){
            mPersonsList.add(new Person("item "+i,i));
        }

        mPersonAdapter.notifyDataSetChanged();
    }


}
