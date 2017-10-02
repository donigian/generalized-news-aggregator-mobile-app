package donigian.generalizednewsaggregator;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import donigian.generalizednewsaggregator.model.Article;

/**
 * Created by arm on 10/2/17.
 */

public class NewsWallAdapter extends RecyclerView.Adapter<NewsWallAdapter.NewsWallViewHolder> {
    private List<Article> newsArticles;

    public NewsWallAdapter(List<Article> newsArticles) {
        this.newsArticles = newsArticles;
    }

    @Override
    public NewsWallViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_news, parent, false);
        NewsWallViewHolder newsWallViewHolder = new NewsWallViewHolder(view);
        return newsWallViewHolder;
    }

    @Override
    public void onBindViewHolder(NewsWallViewHolder holder, int position) {
        Article article = newsArticles.get(position);
        Glide.with(holder.storyImageView.getContext()).load(article.getNewsImageUrl())
                .centerCrop()
                .into(holder.storyImageView);
        holder.storyTitleTextView.setText(article.getNewsTitle());
        holder.storyTimeTextView.setText(article.getNewsTime());
        holder.storyContentTextView.setText(article.getNewsDetails());
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
