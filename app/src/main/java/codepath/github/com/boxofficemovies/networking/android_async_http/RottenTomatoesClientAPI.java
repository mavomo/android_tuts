package codepath.github.com.boxofficemovies.networking.android_async_http;

import com.loopj.android.http.JsonHttpResponseHandler;

/**
 * Created by Michelle on 14/03/2015.
 */
public interface RottenTomatoesClientAPI {

    void getBoxOfficeMovies(JsonHttpResponseHandler handler);

}
