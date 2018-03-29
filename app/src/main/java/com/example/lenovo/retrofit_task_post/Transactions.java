package com.example.lenovo.retrofit_task_post;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by LENOVO on 23-03-2018.
 */

class Transactions {
    @SerializedName("IncomingList")
    private List<IncomingList> incomingLists;
    @SerializedName("OutgoingList")
    private List<OutgoingList> outgoingLists;
    @SerializedName("AllTranList")
    private List<AlltransList> alltransLists;

    public List<IncomingList> getIncomingLists() {
        return incomingLists;
    }

    public void setIncomingLists(List<IncomingList> incomingLists) {
        this.incomingLists = incomingLists;
    }

    public List<OutgoingList> getOutgoingLists() {
        return outgoingLists;
    }

    public void setOutgoingLists(List<OutgoingList> outgoingLists) {
        this.outgoingLists = outgoingLists;
    }

    public List<AlltransList> getAlltransLists() {
        return alltransLists;
    }

    public void setAlltransLists(List<AlltransList> alltransLists) {
        this.alltransLists = alltransLists;
    }
}
