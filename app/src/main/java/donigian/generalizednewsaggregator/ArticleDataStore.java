package donigian.generalizednewsaggregator;

import java.util.ArrayList;
import java.util.List;

import donigian.generalizednewsaggregator.model.News;

/**
 * Created by arm on 10/1/17.
 */

public class ArticleDataStore {
    private static List<News> newsArticles = new ArrayList<>();

    public static List<News> getNewsArticles() {
        return newsArticles;
    }

    public static void setNewsArticles(List<News> newsArticles) {
        ArticleDataStore.newsArticles = newsArticles;
    }
}
