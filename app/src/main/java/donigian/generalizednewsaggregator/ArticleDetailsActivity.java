package donigian.generalizednewsaggregator;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ArticleDetailsActivity extends AppCompatActivity {
    private static final String KEY_INDEX = "news_index";
    private WebView webView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        webView = (WebView) findViewById(R.id.activity_news_details_webview);
        progressBar = (ProgressBar) findViewById(R.id.activity_news_details_progressbar);

        int index = getIntent().getIntExtra(KEY_INDEX, -1);
        if(index!=-1){
            updateArticleDetails(index);
        }
        else {
            Toast.makeText(ArticleDetailsActivity.this, "Incorrect index", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateArticleDetails(int index){
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(ArticleDetailsActivity.this, "Error in loading web page", Toast.LENGTH_SHORT).show();
            }
        });
        webView.loadUrl(ArticleDataStore.getNewsArticles().get(index).getNewsUrlToArticle());
        getSupportActionBar().setTitle(ArticleDataStore.getNewsArticles().get(index).getNewsTitle());
    }

    public static void launch(Context context, int index){
        Intent intent = new Intent(context, ArticleDetailsActivity.class);
        intent.putExtra(KEY_INDEX, index);
        context.startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
