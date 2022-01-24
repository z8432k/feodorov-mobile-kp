package com.example.mobileappkp.feed;

import org.simpleframework.xml.Attribute;
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

    @Element(name = "enclosure", required = false)
    public Enclosure enclosure;

    static public class Enclosure {
        @Attribute(name = "url", required = false)
        public String url;
    }
}
