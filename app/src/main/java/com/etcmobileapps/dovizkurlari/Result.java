package com.etcmobileapps.dovizkurlari;


import com.etcmobileapps.dovizkurlari.Rates;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("rates")
    @Expose
    public Rates rates;
    @SerializedName("base")
    @Expose
    public String base;
    @SerializedName("date")
    @Expose
    public String date;

    public Result withRates(Rates rates) {
        this.rates = rates;
        return this;
    }

    public Result withBase(String base) {
        this.base = base;
        return this;
    }

    public Result withDate(String date) {
        this.date = date;
        return this;
    }

}
