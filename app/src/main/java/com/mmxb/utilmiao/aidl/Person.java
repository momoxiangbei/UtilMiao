package com.mmxb.utilmiao.aidl;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by wxy on 2018/9/25
 */
public class Person implements Parcelable {
    private String mName;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mName);
    }

    public Person() {

    }

    public Person(Parcel in) {
        this.mName = in.readString();
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
