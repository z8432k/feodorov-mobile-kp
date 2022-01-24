package com.example.githubviewr;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommitPerson {
    @Expose
    @SerializedName("name")
    public String name;

    @Expose
    @SerializedName("email")
    public String email;

    @Expose
    @SerializedName("date")
    public String date;
}
