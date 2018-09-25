package com.mmxb.utilmiao.data.enums;

public enum EatType {
    A(0, "hhhh");

    int id;
    String name;

    EatType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
