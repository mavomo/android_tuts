package codepath.github.com.boxofficemovies.networking.volley;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by Michelle on 15/03/2015.
 */
public class BoxOfficeMovieRequest <T> extends Request<T> {

    private final String TAG = "BoxOfficeMovieRequest";

    private Response.Listener<T> _listener = null;

    private final Gson gson = new Gson();
    private Type type;
    private Map<String, String> headers;

    //Used to request a single item
    public BoxOfficeMovieRequest(String url, Type type, Map<String, String> headers, Response.Listener<T> listener, Response.ErrorListener errorListener){
        super(Method.GET, url, errorListener);
       this._listener = listener;
       this.type = type;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers != null ? headers : super.getHeaders();
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        Log.i(TAG, "Inside parseNetworkResponse");
        String jsonResponse = null;
            try {
               jsonResponse = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
                T output = gson.fromJson(jsonResponse, this.type);
               return Response.success(output, HttpHeaderParser.parseCacheHeaders(response));
            } catch (UnsupportedEncodingException | JsonSyntaxException e) {
                return Response.error(new ParseError(e));
            }
    }


    @Override
    protected void deliverResponse(T boxOfficeMovieResponse) {
        Log.i(TAG, "Inside deliverResponse method");
        _listener.onResponse(boxOfficeMovieResponse);
    }

}
