package codepath.github.com.boxofficemovies.networking.android_async_http;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Utility class to wrap HTTP requests
 * Created by Michelle on 14/03/2015.
 */
public class RottenTomatoesClient implements RottenTomatoesClientAPI {

    private final String API_KEY = "9htuhtcb4ymusd73d4z6jxcj";

    private final String API_BASE_URL = "http://api.rottentomatoes.com/api/public/v1.0/";
    private AsyncHttpClient asyncHttpClient;

    private final String TAG = "RottenTomatoesClient";

    public RottenTomatoesClient(){
        Log.i(TAG, " calling constructor");
        this.asyncHttpClient = new AsyncHttpClient();
    }

    private String getApiUrl(String relativeUrl){
        return API_BASE_URL + relativeUrl;
    }


    @Override
    public void getBoxOfficeMovies(JsonHttpResponseHandler handler) {
        Log.i(TAG, " Calling remote API with params via URLs");
        String url = this.getApiUrl("lists/movies/box_office.json");
        RequestParams params = new RequestParams("apiKey", API_KEY);
        asyncHttpClient.get(url,params,handler);
    }
}
