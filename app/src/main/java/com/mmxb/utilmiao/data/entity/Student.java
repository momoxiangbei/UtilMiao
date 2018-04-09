package com.mmxb.utilmiao.data.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by xueying on 2018/1/31.
 */

public class Student implements Serializable {

    @SerializedName(value = "name", alternate = {"nickName", "fullName"})
    private String name;

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }
}
