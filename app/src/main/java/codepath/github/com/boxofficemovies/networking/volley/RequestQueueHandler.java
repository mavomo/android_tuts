package codepath.github.com.boxofficemovies.networking.volley;

import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import codepath.github.com.boxofficemovies.networking.volley.caching.LruBitmapCache;

/**
 * Created by Michelle on 15/03/2015.
 */
public class RequestQueueHandler<T> {

    private final String TAG = "RequestQueueHandler";
    private RequestQueue requestQueue;
    private static Context _context;
    private ImageLoader mImageLoader;

    public ImageLoader getImageLoader() {
        requestQueue = getRequestQueue();
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.requestQueue, new LruBitmapCache(_context));
        }
        return mImageLoader;
    }

    //Singleton
    private static RequestQueueHandler instance;

    private RequestQueueHandler(Context context){
        _context = context;
        requestQueue = this.getRequestQueue();
    }

    public static synchronized RequestQueueHandler getInstance(Context context) {
        if(instance == null){
            instance = new RequestQueueHandler(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(_context.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request){
        getRequestQueue().add(request);
    }

    public void cancelPendingRequests(Object tag) {
        if (requestQueue != null) {
            requestQueue.cancelAll(tag);
        }
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }
}
