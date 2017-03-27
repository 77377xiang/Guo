package com.yude.judicialauctionproject.entity;

/**
 * Created by hexiang on 17/3/21.
 */
public class CheckBoxData {

    private  String title;
    private int   picture;
    private  boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
