package com.example.githubviewr;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class Commit {
    @Expose
    @SerializedName("html_url")
    public String htmlUrl;

    @Expose
    @SerializedName("sha")
    public String hash;

    @Expose
    @SerializedName("commit")
    public CommitField commit;

    @Expose
    @SerializedName("author")
    public Author author;

    public static final class Author {
        @Expose
        @SerializedName("avatar_url")
        String avatarUrl;

        @Expose
        @SerializedName("html_url")
        String htmlUrl;

        @Expose
        @SerializedName("login")
        String login;
    }
}
