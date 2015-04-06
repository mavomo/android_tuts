package codepath.github.com.boxofficemovies.Activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;

import java.util.ArrayList;
import java.util.List;

import codepath.github.com.boxofficemovies.R;
import codepath.github.com.boxofficemovies.adapter.BoxOfficeMoviesAdapter;
import codepath.github.com.boxofficemovies.model.BoxOffice;
import codepath.github.com.boxofficemovies.model.Movie;


public class BoxOfficeActivity extends ListActivity {

    //Set the Movies Adapter
    private BoxOfficeMoviesAdapter boxOfficeMoviesAdapter;

    private final String TAG = "BoxOfficeActivity";
    private BoxOffice boxOfficeInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, " inside onCreate method");
        setContentView(R.layout.activity_box_office);

        boxOfficeInstance = new BoxOffice();

        boxOfficeMoviesAdapter = new BoxOfficeMoviesAdapter(this, boxOfficeInstance.getMovies());

        //FIXME : check if the device is using the WIFI.
        setListAdapter(boxOfficeMoviesAdapter);
    }

}
