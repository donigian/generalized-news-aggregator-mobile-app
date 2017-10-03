package donigian.generalizednewsaggregator;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.List;

import donigian.generalizednewsaggregator.model.News;

/**
 * Created by arm on 10/2/17.
 */

public class NewsWallAdapter extends RecyclerView.Adapter<NewsWallAdapter.NewsWallViewHolder> {
    private List<News> newsArticles;

    public NewsWallAdapter(List<News> newsArticles) {
        this.newsArticles = newsArticles;
    }

    @Override
    public NewsWallViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_news, parent, false);
        NewsWallViewHolder newsWallViewHolder = new NewsWallViewHolder(view);
        return newsWallViewHolder;
    }

    @Override
    public void onBindViewHolder(NewsWallViewHolder holder, final int position) {
        News article = newsArticles.get(position);
        Glide.with(holder.storyImageView.getContext()).load(article.getUrlToImage())
                .centerCrop()
                .into(holder.storyImageView);
        holder.storyTitleTextView.setText(article.getTitle());
        holder.storyTimeTextView.setText(article.getPublishedAt());
        holder.storyContentTextView.setText(article.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // log analytics
                FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(v.getContext());
                Bundle bundle = new Bundle();
                bundle.putString("index", String.valueOf(position));
                firebaseAnalytics.logEvent("cardClicked", bundle);
                ArticleDetailsActivity.launch(v.getContext(), position);

            }
        });
    }

    @Override
    public int getItemCount() {
        return newsArticles.size();
    }

    public static class NewsWallViewHolder extends RecyclerView.ViewHolder{
        ImageView storyImageView;
        TextView storyTitleTextView;
        TextView storyTimeTextView;
        TextView storyContentTextView;

        public NewsWallViewHolder(View itemView) {
            super(itemView);
            storyImageView = (ImageView) itemView.findViewById(R.id.card_news_image);
            storyTitleTextView = (TextView) itemView.findViewById(R.id.card_news_title);
            storyTimeTextView = (TextView) itemView.findViewById(R.id.card_news_time);
            storyContentTextView = (TextView) itemView.findViewById(R.id.card_news_content);
        }
    }
}
