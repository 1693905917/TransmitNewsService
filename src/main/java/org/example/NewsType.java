package org.example;

import java.util.Objects;

public class NewsType {
    private int newstypeId;
    private String  newsTitle;
    private String  newsContext;
    private String  newsTime;

    public NewsType(int newstypeId, String newsTitle, String newsContext, String newsTime) {
        this.newstypeId = newstypeId;
        this.newsTitle = newsTitle;
        this.newsContext = newsContext;
        this.newsTime = newsTime;
    }

    public NewsType() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsType newsType = (NewsType) o;
        return newstypeId == newsType.newstypeId && Objects.equals(newsTitle, newsType.newsTitle) && Objects.equals(newsContext, newsType.newsContext) && Objects.equals(newsTime, newsType.newsTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newstypeId, newsTitle, newsContext, newsTime);
    }

    @Override
    public String toString() {
        return "NewsType{" +
                "newstypeId=" + newstypeId +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsContext='" + newsContext + '\'' +
                ", newsTime='" + newsTime + '\'' +
                '}';
    }

    public int getNewstypeId() {
        return newstypeId;
    }

    public void setNewstypeId(int newstypeId) {
        this.newstypeId = newstypeId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContext() {
        return newsContext;
    }

    public void setNewsContext(String newsContext) {
        this.newsContext = newsContext;
    }

    public String getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(String newsTime) {
        this.newsTime = newsTime;
    }
}
