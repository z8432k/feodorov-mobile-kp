package com.example.mobileappkp.feed;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "item", strict = false)
public class Article {
    @Element(name = "title")
    public String title;

    @Element(name = "link")
    public String link;

    @Element(name = "description", required = false)
    public String description;

    @Element(name = "pubDate")
    public String pubDate;
}
