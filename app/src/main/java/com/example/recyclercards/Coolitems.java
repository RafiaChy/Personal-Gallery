package com.example.recyclercards;

public class Coolitems {

    private int mImageResource;
    private String mText;

    public Coolitems(int imageResource, String text)
    {
        mImageResource = imageResource;
        mText = text;
    }


    public int getmImageResource() {
        return mImageResource;
    }

    public String getmText() {
        return mText;
    }
}
