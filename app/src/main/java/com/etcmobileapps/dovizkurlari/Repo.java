package com.etcmobileapps.dovizkurlari;


import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repo {

    @SerializedName("status")
    @Expose
    public Boolean status;
    @SerializedName("created")
    @Expose
    public Integer created;
    @SerializedName("desc")
    @Expose
    public String desc;
    @SerializedName("result")
    @Expose
    public Result result;
    @SerializedName("get")
    @Expose
    public List<Object> get = null;

    public Repo withStatus(Boolean status) {
        this.status = status;
        return this;
    }

    public Repo withCreated(Integer created) {
        this.created = created;
        return this;
    }

    public Repo withDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public Repo withResult(Result result) {
        this.result = result;
        return this;
    }

    public Repo withGet(ArrayList<Object> get) {
        this.get = get;
        return this;
    }

}
