package com.example.mobileappkp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommitField {
    @Expose
    @SerializedName("author")
    public CommitPerson author;

    @Expose
    @SerializedName("committer")
    public CommitPerson committer;

    @Expose
    @SerializedName("url")
    public String url;

    @Expose
    @SerializedName("message")
    public String message;
}
