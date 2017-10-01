package donigian.generalizednewsaggregator;

import java.util.ArrayList;
import java.util.List;

import donigian.generalizednewsaggregator.model.Article;

/**
 * Created by arm on 10/1/17.
 */

public class ArticleDataStore {
    private static List<Article> newsArticles = new ArrayList<>();

    public static List<Article> getNewsArticles() {
        return newsArticles;
    }

    public static void setNewsArticles(List<Article> newsArticles) {
        ArticleDataStore.newsArticles = newsArticles;
    }
}
