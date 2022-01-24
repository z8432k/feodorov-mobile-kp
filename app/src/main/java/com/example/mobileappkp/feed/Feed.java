package com.example.mobileappkp.feed;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "feed", strict = false)
public class Feed {
    @ElementList(name = "item", inline = true)
    @Path("channel")
    public List<Article> articleList;
}
