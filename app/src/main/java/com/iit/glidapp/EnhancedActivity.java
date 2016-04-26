package com.iit.glidapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.iit.glidapp.core.Person;
import com.iit.glidapp.fragment.AddFragment;
import com.iit.glidapp.fragment.ListingFragment;

import java.util.ArrayList;

public class EnhancedActivity extends AppCompatActivity implements AddFragment.AddPersonListener, View.OnClickListener {

    private static final String PERSONS_LIST_KEY = "persons_list_key";

    private FloatingActionButton mFab;
    private ArrayList<Person> mPersonsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enhanced);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mFab.setOnClickListener(this);

        if (savedInstanceState == null) {
            mPersonsList = new ArrayList<>();
        } else {
            mPersonsList = (ArrayList<Person>) savedInstanceState.getSerializable(PERSONS_LIST_KEY);
        }


        getSupportFragmentManager().beginTransaction().replace(R.id.content, ListingFragment.newInstance(mPersonsList)).commit();
    }

    @Override
    public void onFinishAddPerson(String name, int age) {
        performPersonAdd(name, age);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab:
                mFab.setVisibility(View.INVISIBLE);
                launchAdd();
                break;

        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(PERSONS_LIST_KEY, mPersonsList);

    }

    private void launchAdd() {
        getSupportFragmentManager().beginTransaction().replace(R.id.content, AddFragment.newInstance(this)).commit();
    }

    private void performPersonAdd(String name, int age) {
//TODO do something
        Person person = new Person(name, age);
        mPersonsList.add(person);


        getSupportFragmentManager().beginTransaction().replace(R.id.content, ListingFragment.newInstance(mPersonsList)).commit();
        mFab.setVisibility(View.VISIBLE);
    }
}
