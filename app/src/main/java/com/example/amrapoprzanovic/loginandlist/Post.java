package com.example.amrapoprzanovic.loginandlist;

/**
 * Created by amrapoprzanovic on 14/04/15.
 */
public class Post {

    private int mId;
    private String mTitle;
    private String mContent;

    public Post(int id, String title, String content ) {
        mId = id;
        mTitle = title;
        mContent = content;

    }

    public String toString(){
        return mTitle + " \n "  + mContent;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }
}
