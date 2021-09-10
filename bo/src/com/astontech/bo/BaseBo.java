package com.astontech.bo;

import java.util.Date;

public class BaseBo {
    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }


    public String test_method(){
        return "base method";
    }
}
