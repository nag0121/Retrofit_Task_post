package com.example.lenovo.retrofit_task_post;

import com.google.gson.annotations.SerializedName;

/**
 * Created by LENOVO on 23-03-2018.
 */

class OutgoingList {
    @SerializedName("Biller")
    private String Biller;
    @SerializedName("Amount")
    private String amount;
    @SerializedName("Time")
    private String time;


    public String getBiller() {
        return Biller;
    }

    public void setBiller(String biller) {
        Biller = biller;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

