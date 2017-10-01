package donigian.generalizednewsaggregator.model;

/**
 * Created by arm on 10/1/17.
 */

public class Article {
    public Article(String newsTitle, String newsDetails, String newsImageUrl, String newsTime, String newsUrlToArticle) {
        this.newsTitle = newsTitle;
        this.newsDetails = newsDetails;
        this.newsImageUrl = newsImageUrl;
        this.newsTime = newsTime;
        this.newsUrlToArticle = newsUrlToArticle;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDetails() {
        return newsDetails;
    }

    public void setNewsDetails(String newsDetails) {
        this.newsDetails = newsDetails;
    }

    public String getNewsImageUrl() {
        return newsImageUrl;
    }

    public void setNewsImageUrl(String newsImageUrl) {
        this.newsImageUrl = newsImageUrl;
    }

    public String getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(String newsTime) {
        this.newsTime = newsTime;
    }

    public String getNewsUrlToArticle() {
        return newsUrlToArticle;
    }

    public void setNewsUrlToArticle(String newsUrlToArticle) {
        this.newsUrlToArticle = newsUrlToArticle;
    }

    private String newsTitle;
    private String newsDetails;
    private String newsImageUrl;
    private String newsTime;
    private String newsUrlToArticle;

}
