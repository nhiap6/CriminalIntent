package com.example.nino666.realcriminalintent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by nino666 on 8.8.2016.
 */
public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime(){
        this(UUID.randomUUID());
    }

    public Crime(UUID id) {
        mId = id;
        mDate = new Date();
    }


    public Date getDate() {
        return mDate;
    }

    public String getOnlyDate(){
        return new SimpleDateFormat("EEE, MMM d, \''yy").format(mDate);
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getTime(){

        return new SimpleDateFormat("HH:mm").format(mDate);
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
