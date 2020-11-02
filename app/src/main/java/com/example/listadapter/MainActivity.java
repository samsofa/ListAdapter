package com.example.listadapter;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieListAdapter.MovieClickInterface {

    private MovieListAdapter mMovieListAdapter;
    String SamehTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mMovieListAdapter = new MovieListAdapter(Movie.itemCallback, this);

        recyclerView.setAdapter(mMovieListAdapter);

        initMovieList();
    }

    private void initMovieList() {

        List<Movie> movieList = new ArrayList<>();

        movieList.add(new Movie("Sameh Safein ", "10"));
        movieList.add(new Movie("Love programming ", "10"));
        movieList.add(new Movie("Specially android ", "10"));

        mMovieListAdapter.submitList(movieList);

    }

    public void addItem(View view) {

        Movie movie = new Movie("Eva is happy with her real dreams", "10");
        List<Movie> movieList = new ArrayList<>(mMovieListAdapter.getCurrentList());
        movieList.add(movie);
        mMovieListAdapter.submitList(movieList);
    }

    public void updateItem(View view) {

    }

    @Override
    public void onDelete(int position) {

        List<Movie> movieList = new ArrayList<>(mMovieListAdapter.getCurrentList());
        movieList.remove(position);
        mMovieListAdapter.submitList(movieList);


    }
}
