package codepath.github.com.boxofficemovies.networking.volley;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;

import codepath.github.com.boxofficemovies.R;
import codepath.github.com.boxofficemovies.model.BoxOffice;

/**
 * Created by Michelle on 22/03/2015.
 */
public class BoxOfficeMoviesApi {

    private static final String API_KEY = "9htuhtcb4ymusd73d4z6jxcj";
    private static final String API_BASE_URL = "http://api.rottentomatoes.com/api/public/v1.0/";

    private BoxOfficeMovieRequest boxOfficeMovieRequest;

    private Context context;

    public BoxOfficeMoviesApi(Context context){
        this.context = context;
    }

    public void requestMovies(String url, Response.Listener<BoxOffice> responseListener, Response.ErrorListener errorListener){
        String completeUrl = this.getUrl(url);
        boxOfficeMovieRequest = new BoxOfficeMovieRequest(completeUrl, BoxOffice.class, null, responseListener, errorListener);
        RequestQueueHandler.getInstance(context).addToRequestQueue(boxOfficeMovieRequest);
    }

    public ImageLoader getImageLoader(){
        return RequestQueueHandler.getInstance(context).getImageLoader();
    }


    private String getUrl(String relativePath){
     return API_BASE_URL + relativePath + "?apikey=" + API_KEY;
    }
}
