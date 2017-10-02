package donigian.generalizednewsaggregator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import donigian.generalizednewsaggregator.model.Article;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Article> newsArticles = new ArrayList<>();
        newsArticles.add(new Article("Article Title", "Article 1 Details", "Article1Url", "Article1 news time", "Article1 NewsURL"));
        newsArticles.add(new Article("Article Title", "Article 2 Details", "Article2Url", "Article2 news time", "Article2 NewsURL"));
        newsArticles.add(new Article("Article Title", "Article 3 Details", "Article3Url", "Article3 news time", "Article3 NewsURL"));
        ArticleDataStore.setNewsArticles(newsArticles);
        recyclerView = (RecyclerView) findViewById(R.id.activity_main_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        NewsWallAdapter newsWallAdapter = new NewsWallAdapter(ArticleDataStore.getNewsArticles());
        recyclerView.setAdapter(newsWallAdapter);
    }
}
