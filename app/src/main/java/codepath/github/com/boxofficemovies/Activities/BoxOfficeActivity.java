package codepath.github.com.boxofficemovies.Activities;

import android.app.ListActivity;
import android.preference.PreferenceActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import codepath.github.com.boxofficemovies.R;
import codepath.github.com.boxofficemovies.adapter.BoxOfficeMoviesAdapter;
import codepath.github.com.boxofficemovies.client.RottenTomatoesClient;
import codepath.github.com.boxofficemovies.model.BoxOfficeMovie;
import codepath.github.com.boxofficemovies.model.BoxOfficeMovieFactory;


public class BoxOfficeActivity extends ListActivity {

    //Set the Movies Adapter
    private BoxOfficeMoviesAdapter boxOfficeMoviesAdapter;

    private RottenTomatoesClient rottenTomatoesClient = new RottenTomatoesClient();

    private final String TAG = "BoxOfficeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, " inside onCreate method");
        setContentView(R.layout.activity_box_office);

        List<BoxOfficeMovie> movies = new ArrayList<>();
        boxOfficeMoviesAdapter = new BoxOfficeMoviesAdapter(this, movies);
        //FIXME : check if the device is using the WIFI.
        fetchBoxOfficeMovies();
        setListAdapter(boxOfficeMoviesAdapter);
    }

    private void fetchBoxOfficeMovies() {
        Log.i(TAG, " Start fetching data");
        rottenTomatoesClient.getBoxOfficeMovies(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Log.i(TAG, " fetching data is successful");
                //FIXME : Check status code before processing
                 JSONArray items = null;
                    try {
                        // Get the movies json array
                        items = response.getJSONArray("movies");
                        // Parse json array into array of model objects
                        List<BoxOfficeMovie> movies = BoxOfficeMovieFactory.fromJson(items);
                        // Load model objects into the adapter
                        boxOfficeMoviesAdapter.addAll(movies);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                Log.i(TAG, " fetching data has failed. Just fix it.");
            }
        });
    }
}
