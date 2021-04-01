package com.androidTest.movieDemo.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.androidTest.movieDemo.R;
import com.androidTest.movieDemo.databinding.ItemMovieBinding;
import com.androidTest.movieDemo.model.Results;
import com.androidTest.movieDemo.util.Router;

import java.util.List;

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.ViewHolder> {

    private Router router;
    private static final String TAG = "PostListAdapter";
    private List<Results.Movie> postList;

    public PostListAdapter() {

    }

    public PostListAdapter(List<Results.Movie> postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        router = new Router((AppCompatActivity) parent.getContext());
        ItemMovieBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_movie, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(postList.get(position));

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemMovieBinding binding;

        public ViewHolder(ItemMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Results.Movie movie) {
            movie.setRank(String.valueOf((getAdapterPosition() + 1)));
            binding.setMovie(movie);


        }

    }
}
