package com.iit.glidapp.core;

import java.io.Serializable;

/**
 * Created by slim on 19/04/16.
 */
public class Person implements Serializable {

    private String mName;
    private int mAge;


    public Person() {

    }

    public Person(String name, int age) {
        mName = name;
        mAge = age;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        this.mAge = age;
    }
}
